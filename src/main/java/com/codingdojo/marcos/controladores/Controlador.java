package com.codingdojo.marcos.controladores;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.marcos.modelos.Licencia;
import com.codingdojo.marcos.modelos.Persona;
import com.codingdojo.marcos.servicios.Servicios;

@Controller
public class Controlador {

    @Autowired
    private Servicios servicio;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensaje", "Bienvenido a Driver License");
        return "index.jsp";
    }

    // Método para mostrar el formulario de creación de persona
    @GetMapping("/crear/persona")
    public String mostrarFormularioPersona(Model model) {
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "formularioCrearPersona.jsp"; // Nombre del JSP para el formulario de creación de persona
    }

    // Método para crear y guardar una persona
    @PostMapping("/crear/persona")
    public String crearPersona(@ModelAttribute("persona") Persona persona) {
        // Procesar y guardar los datos de persona
        servicio.guardarPersona(persona);
        return "redirect:/crear/licencia";
    }

    // Método para mostrar el formulario de creación de licencia
    @GetMapping("/crear/licencia")
    public String mostrarFormularioLicencia(Model model) {
        Licencia licencia = new Licencia();
        model.addAttribute("licencia", licencia);
        List<Persona> personas = servicio.encontrarTodasLasPersonas();
        model.addAttribute("personas", personas);
        List<String> estados = Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California");
        model.addAttribute("estados", estados);
        return "formularioCrearLicencia.jsp";
    }

    @PostMapping("/crear/licencia")
    public String crearLicencia(@ModelAttribute("licencia") Licencia licencia) {
        // Obtén la persona asociada a la licencia
        Persona persona = licencia.getPersona();
        // Crea y guarda la licencia para la persona
        Licencia nuevaLicencia = servicio.crearLicenciaParaPersona(persona);
        // Redirigir a la página de información del usuario
        return "redirect:/usuario/" + persona.getId();
    }


    public String generarNumeroLicenciaUnico() {
        // Generar un número de licencia único basado en algún algoritmo o lógica
        // Asegurarse de que este número no exista en la base de datos
        String numeroDeLicencia = servicio.generarNumeroLicencia();
        while (servicio.existeNumeroDeLicencia(numeroDeLicencia)) {
            // Si el número ya existe, genera uno nuevo hasta que sea único
            numeroDeLicencia = servicio.generarNumeroLicencia();
        }
        return numeroDeLicencia;
    }

    @GetMapping("/usuario/{id}")
    public String verInformacionUsuario(@PathVariable Long id, Model model) {
        Optional<Persona> personaOptional = servicio.encontrarPersonaPorId(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            List<Licencia> licencias = servicio.obtenerLicenciasDePersona(persona);
            model.addAttribute("persona", persona);
            model.addAttribute("licencias", licencias);
            return "informacionUsuario.jsp"; // Nombre del JSP para mostrar la información del usuario
        } else {
            return "redirect:/";
        }
    }
}

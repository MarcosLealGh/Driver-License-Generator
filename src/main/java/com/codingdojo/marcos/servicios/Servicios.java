package com.codingdojo.marcos.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.marcos.modelos.Licencia;
import com.codingdojo.marcos.modelos.Persona;
import com.codingdojo.marcos.repositorios.RepositorioLicencia;
import com.codingdojo.marcos.repositorios.RepositorioPersona;

@Service
public class Servicios {

    @Autowired
    private RepositorioPersona rp;

    @Autowired
    private RepositorioLicencia rl;

    public Persona guardarPersona(Persona persona) {
        // Guardar la persona en la base de datos
        Persona personaGuardada = rp.save(persona);
        return personaGuardada;
    }

    public Licencia guardarLicencia(Licencia licencia) {
        // Guardar la licencia en la base de datos
        return rl.save(licencia);
    }
    
    public Licencia crearLicenciaParaPersona(Persona persona) {
        // Generar el número de licencia y crear una nueva licencia asociada a la persona
        String numeroDeLicencia = generarNumeroLicencia();
        Licencia licencia = new Licencia();
        licencia.setNumeroDeLicencia(numeroDeLicencia);
        licencia.setEstado("Activa");
        licencia.setFechaCaducidad(LocalDate.now().plusYears(1));
        licencia.setPersona(persona);

        // Guardar la licencia en la base de datos
        return rl.save(licencia);
    }


    public Optional<Persona> encontrarPersonaPorId(Long id) {
        return rp.findById(id);
    }

    public List<Persona> encontrarTodasLasPersonas() {
        return rp.findAll();
    }

    public void eliminarPersonaPorId(Long id) {
        rp.deleteById(id);
    }

    public String generarNumeroLicencia() {
        // Obtener la cantidad actual de licencias asociadas a personas
        long cantidadDeLicencias = rl.count();

        // Generar un número de licencia único basado en la cantidad de licencias
        return String.format("%06d", cantidadDeLicencias + 1);
    }

    public List<Licencia> obtenerLicenciasDePersona(Persona persona) {
        // Lógica para obtener las licencias de la persona
        return rl.findByPersona(persona);
    }

    public boolean existeNumeroDeLicencia(String numeroDeLicencia) {
        // Lógica para verificar si un número de licencia ya existe
        // Implementa esta lógica según tus necesidades
        return false;
    }
}

package com.codingdojo.marcos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.marcos.modelos.Persona;

@Repository
public interface RepositorioPersona extends CrudRepository<Persona, Long> {
	//Lista de todas las personas
	List<Persona> findAll();
	
	//Crear Nueva Persona
	Persona save(Persona persona);

	//Buscar Por ID
	Optional<Persona> findById(Long id);

	//Eliminar por id 
	void deleteById(Long id);

	
}

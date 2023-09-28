	package com.codingdojo.marcos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.marcos.modelos.Licencia;
import com.codingdojo.marcos.modelos.Persona;

@Repository
public interface RepositorioLicencia extends CrudRepository<Licencia, Long> {
	
	//Crear Licencia
	Licencia save(Licencia licencia);

	//Buscar por id
	Optional<Licencia> findById(Long id);
	
	//Lista de todas las licencias
	List<Licencia> findAll();
	
	//Buscar licencias asociadas a una persona
	List<Licencia> findByPersona(Persona persona);
	
	


	
}

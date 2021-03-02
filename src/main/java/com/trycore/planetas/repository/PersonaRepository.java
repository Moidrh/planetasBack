package com.trycore.planetas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trycore.planetas.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	Optional<Persona> findByName(String fullname);
	
	boolean existsByName(String name);

}

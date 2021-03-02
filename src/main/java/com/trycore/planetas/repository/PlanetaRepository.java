package com.trycore.planetas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trycore.planetas.entity.Planeta;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer>{

	Optional<Planeta> findByName(String name);

}

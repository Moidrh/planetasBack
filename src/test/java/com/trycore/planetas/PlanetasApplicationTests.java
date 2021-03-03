package com.trycore.planetas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trycore.planetas.entity.Persona;
import com.trycore.planetas.entity.Planeta;
import com.trycore.planetas.repository.PersonaRepository;
import com.trycore.planetas.repository.PlanetaRepository;

@SpringBootTest
class PlanetasApplicationTests {
	
	@Autowired
	PlanetaRepository plaRepo;
	
	@Autowired
	PersonaRepository perRepo;
	
	@Test
	public void createPlanet() {
		Planeta pla = new Planeta("Reach", 0, 32, 5896, "Frio", "Cristalizado");
		
		Planeta plaAux = plaRepo.save(pla);
		
		assertTrue(plaAux.getName().equals("Reach"));
	}
	
	@Test
	public void createPerson() {
		
		Optional<Planeta> p = plaRepo.findById(1);
		
		Persona per = new Persona("Jhon 117", 47, 0, p.get(), 225, 135, 'M',
				LocalDateTime.of(2075, 05, 04, 0, 0));
		
		Persona plaAux = perRepo.save(per);
		
		assertTrue(plaAux.getName().equals("Jhon 117"));
	}

	@Test
	void contextLoads() {
	}

}

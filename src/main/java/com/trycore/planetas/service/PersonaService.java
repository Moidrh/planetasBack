package com.trycore.planetas.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycore.planetas.entity.Persona;
import com.trycore.planetas.entity.Planeta;
import com.trycore.planetas.repository.PersonaRepository;
import com.trycore.planetas.repository.PlanetaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository repo;
	
	@Autowired
	PlanetaRepository pRepo;
	
	public List<Persona> getAllPersonas() {
		
		List<Persona> persons = repo.findAll();
		
		
		return persons;
	}

	public Persona getAPerson(String name) {
		
		Optional<Persona> person = repo.findByName(name);
		
		Persona p = person.get();
		
		sumCountPerson(name);
		
		repo.save(p);
		
		return p;
	}

	public void sumCountPerson(String fullname) {
		
		int contadorAux;
		
		Optional<Persona> person = repo.findByName(fullname);
		
		if(person.isPresent()) {
			contadorAux = person.get().getContador();
			contadorAux = contadorAux + 1;
			person.get().setContador(contadorAux);
		}
		
	}

	public int createPersona(String name, String edad, String planeta_name, String estatura, String peso, String sexo,
			String fecha_nacimiento) {
		
		Optional<Planeta> pla = pRepo.findByName(planeta_name);
		int edadP = Integer.parseInt(edad);
		int estaturaP = Integer.parseInt(estatura);
		int pesoP = Integer.parseInt(peso);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
		LocalDateTime fecha_nacimientoP = LocalDate.parse(fecha_nacimiento, f).atStartOfDay();
		
		boolean userExist = repo.existsByName(name);
		
		if(pla.isPresent() && !userExist) {
			Planeta plaAux = pla.get();
			
			char sexoAux = sexo.charAt(0);
			
			Persona p = new Persona(name, edadP, 0, plaAux, estaturaP, pesoP, sexoAux, fecha_nacimientoP);
			
			int personaP = repo.save(p).getId();
			
			return personaP;
		} else if(pla.isPresent() && userExist) {
			Optional<Persona> pUpdate = repo.findByName(name);
			
			Persona p = pUpdate.get();
			
			p.setEdad(edadP);
			p.setPlaneta(pla.get());
			p.setEstatura(estaturaP);
			p.setPeso(pesoP);
			p.setContador(0);
			p.setSexo(sexo.charAt(0));
			p.setFecha_nacimiento(fecha_nacimientoP);
			
			repo.save(p);
			
			return p.getId();
		}
		return 0;
	}

	public Persona getAPersonById(String id) {
		
		int idI = Integer.parseInt(id);
		
		Optional<Persona> p = repo.findById(idI);
		
		if(p.isPresent()) {
			Persona pe = p.get();
			sumCountPerson(pe.getName());
			repo.save(pe);
			return pe;
		}
		
		return null;
	}
	
	
}

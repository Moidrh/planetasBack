package com.trycore.planetas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycore.planetas.entity.Planeta;
import com.trycore.planetas.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	PlanetaRepository repo;
	
	public List<Planeta> getAllPlanetas() {
		
		List<Planeta> planeta = repo.findAll();
		
		return planeta;
	}

	public Planeta getAPlanet(String name) {
		
		Optional<Planeta> planeta = repo.findByName(name);
		
		Planeta p = planeta.get();
		
		repo.save(p);
		
		return p;
	}

	public void sumCountPlanet(String fullname) {
		
		int contadorAux;
		
		Optional<Planeta> planeta = repo.findByName(fullname);
		
		if(planeta.isPresent()) {
			System.out.println("******************>" + planeta.get().getContador());
			contadorAux = planeta.get().getContador();
			contadorAux = contadorAux + 1;
			planeta.get().setContador(contadorAux);
		}
		
	}

	public int createPlanet(String name, String rotation, String diametro, String clima, String terreno) {
		
		int diametroI = Integer.parseInt(diametro);
		int rotationI = Integer.parseInt(rotation);
		
		Planeta p = new Planeta(name, 0, rotationI, diametroI, clima, terreno);
		
		System.out.println("------------> Create planet: "+p.getContador());
		
		return repo.save(p).getId();
	}

	public Planeta getAPlanetById(String id) {
		
		int idI = Integer.parseInt(id);
		
		Optional<Planeta> p = repo.findById(idI);
		
		if(p.isPresent()) {
			Planeta pl = p.get();
			sumCountPlanet(pl.getName());
			repo.save(pl);
			return pl;
		}
		
		
		return null;
	}
	
	
}

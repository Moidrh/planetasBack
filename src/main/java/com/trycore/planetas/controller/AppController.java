package com.trycore.planetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trycore.planetas.entity.Persona;
import com.trycore.planetas.entity.Planeta;
import com.trycore.planetas.service.PersonaService;
import com.trycore.planetas.service.PlanetaService;

@RestController
public class AppController {
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	PlanetaService planetaService;
		
	@RequestMapping(value = "createPerson", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public int createPerson(@RequestParam(name = "fullname") String name, @RequestParam(name="edad") String edad, 
			@RequestParam(name = "planeta_name") String planeta_name, @RequestParam(name = "estatura") String estatura, 
			@RequestParam(name = "peso") String peso, @RequestParam(name = "sexo") String sexo, 
			@RequestParam(name = "fecha_nacimiento") String fecha_nacimiento) {
		
		return personaService.createPersona(name, edad, planeta_name, estatura, peso, sexo, fecha_nacimiento);
	}

	
	@RequestMapping(value="getAllPersons", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<Persona> getAllPersonas() {
		
		List<Persona> pers = personaService.getAllPersonas();
		
		return pers;
	}
	
	@RequestMapping(value="getAPerson", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public Persona getAPersonaDetail(@RequestParam(name="fullname") String fullname) {
		
		Persona pers = personaService.getAPerson(fullname);
		
		return pers;
	}
	
	@RequestMapping(value = "sumCountPerson", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody	
	public void sumCountPerson(@RequestParam(name = "fullname") String fullname) {
		personaService.sumCountPerson(fullname);
		
	}
	
	@RequestMapping(value = "createPlanet", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public int createPerson(@RequestParam(name = "name") String name, @RequestParam(name = "rotation") String rotation,
			@RequestParam(name="diametro") String diametro, @RequestParam(name = "clima") String clima,
			@RequestParam(name="terreno") String terreno) {
		
		return planetaService.createPlanet(name, rotation, diametro, clima, terreno);
	}

	@RequestMapping(value = "getAllPlanets", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<Planeta> getAllPlanets() {
		
		return planetaService.getAllPlanetas();
	}
	
	@RequestMapping(value = "getAPlanet", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public Planeta getAPlanet(@RequestParam(name = "name") String name) {
		
		return planetaService.getAPlanet(name);
	}
	
	@RequestMapping(value = "getAPlanetById", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public Planeta getAPlanetById(@RequestParam(name = "id") String id) {
		
		return planetaService.getAPlanetById(id);
	}
	
	@RequestMapping(value = "getAPersonById", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public Persona getAPersonById(@RequestParam(name = "id") String id) {
		
		return personaService.getAPersonById(id);
	}
	
	
}

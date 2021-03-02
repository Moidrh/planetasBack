package com.trycore.planetas.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Planeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planeta_id;
	
	private String name;
	
	private int contador;
	
	private int rotation;
	
	private int diametro;
	
	private String clima;
	
	private String terreno;
	
	@OneToMany(mappedBy = "planeta")
	@JsonIgnoreProperties("planeta")
	private Set<Persona> personas;
	
	public Planeta() {}

	public Planeta(String name, int contador, int rotation, int diametro, String clima, String terreno) {
		this.name = name;
		this.contador = contador;
		this.rotation = rotation;
		this.diametro = diametro;
		this.clima = clima;
		this.terreno = terreno;
	}

	public int getId() {
		return planeta_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Persona p) {
		this.personas.add(p);
	}
	
	public void removePerson( Persona p) {
		this.personas.remove(p);
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
	
}

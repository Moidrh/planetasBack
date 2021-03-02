package com.trycore.planetas.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int edad;
	
	private int contador;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("personas")
	private Planeta planeta;
	
	private int estatura;
	
	private double peso;
	
	private char sexo;
	
	private LocalDateTime fecha_nacimiento;

	public Persona() {}

	public Persona(String name, int edad, Planeta planeta, int estatura, double peso, char sexo,
			LocalDateTime fecha_nacimiento) {
		this.name = name;
		this.edad = edad;
		this.planeta = planeta;
		this.estatura = estatura;
		this.peso = peso;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
}

package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParejaDTO {
	private String nombre, carrera;
	private int edad;
	private LocalDateTime fechaAniv;
	
	public ParejaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ParejaDTO(String nombre, String carrera, int edad, LocalDateTime fechaAniv) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
		this.edad = edad;
		this.fechaAniv = fechaAniv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaAniv() {
		return fechaAniv;
	}

	public void setFechaAniv(LocalDateTime fechaAniv) {
		this.fechaAniv = fechaAniv;
	}

	@Override
	public String toString() {
		return "ParejaDTO [nombre=" + nombre + ", carrera=" + carrera + ", edad=" + edad + ", fechaAniv=" + fechaAniv
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrera, edad, fechaAniv, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParejaDTO other = (ParejaDTO) obj;
		return Objects.equals(carrera, other.carrera) && edad == other.edad
				&& Objects.equals(fechaAniv, other.fechaAniv) && Objects.equals(nombre, other.nombre);
	}
	
	
}

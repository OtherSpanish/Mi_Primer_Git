package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import co.edu.unbosque.miprimerspring.entity.ExPareja;

public class ExParejaDTO {
	private String nombre;
	private int edad;
	private LocalDateTime fechaNacimiento;
	private LocalDateTime fechaRuptura;
	private String motivoRuptura;

	public ExParejaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ExParejaDTO(String nombre, int edad, LocalDateTime fechaNacimiento, LocalDateTime fechaRuptura,
			String motivoRuptura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRuptura = fechaRuptura;
		this.motivoRuptura = motivoRuptura;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaRuptura() {
		return fechaRuptura;
	}

	public void setFechaRuptura(LocalDateTime fechaRuptura) {
		this.fechaRuptura = fechaRuptura;
	}

	public String getMotivoRuptura() {
		return motivoRuptura;
	}

	public void setMotivoRuptura(String motivoRuptura) {
		this.motivoRuptura = motivoRuptura;
	}

	@Override
	public String toString() {
		return "ExParejaDTO [nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaRuptura=" + fechaRuptura + ", motivoRuptura=" + motivoRuptura + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, fechaNacimiento, fechaRuptura, motivoRuptura, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExParejaDTO other = (ExParejaDTO) obj;
		return edad == other.edad && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(fechaRuptura, other.fechaRuptura)
				&& Objects.equals(motivoRuptura, other.motivoRuptura) && Objects.equals(nombre, other.nombre);
	}

	

	
}

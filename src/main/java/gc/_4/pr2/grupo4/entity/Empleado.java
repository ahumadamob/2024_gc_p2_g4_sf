package gc._4.pr2.grupo4.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity	

public class Empleado {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String nombre;
	private String cargo;
	private Long numeroIdentificacion;
	private Long salario;
	private LocalDateTime fechaContratacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public Long getSalario() {
		return salario;
	}
	public void setSalario(Long salario) {
		this.salario = salario;
	}
	public LocalDateTime getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(LocalDateTime fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	

}

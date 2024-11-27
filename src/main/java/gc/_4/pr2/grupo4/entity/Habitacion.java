package gc._4.pr2.grupo4.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;








@Entity
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private String tipo;
	private double precioPorNoche;
	private String estado;
	@OneToMany(mappedBy="habitacion") 
	private Set<Reserva> reserva;
	private double disponible;
	
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	
	public Set<Reserva> getReserva() {
		return this.reserva;
	}
	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}
	public double getDisponible() {
		return disponible;
	}
	public void setDisponible(double disponible) {
		this.disponible = disponible;
	}
	

}

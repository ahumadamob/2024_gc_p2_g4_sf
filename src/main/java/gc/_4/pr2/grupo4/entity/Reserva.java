package gc._4.pr2.grupo4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fechaInicio;
	private String fechaFin;
	// variable de tipo habitacion
	private String habitacionId;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private EstadoReserva estado;

	// Enumeración
	public enum EstadoReserva {
		CONFIRMADA, PENDIENTE, CANCELADA;
	}

	public long getId() {
		return id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	// Variable tipo habitacion
	public String getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(String habitacionId) {
		this.habitacionId = habitacionId;
	}

	
	public Cliente getClienteId() {
		return cliente;
	}

	public void setClienteId(Cliente cliente) {
		this.cliente = cliente;
	}

	// Enumeracion
	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

}

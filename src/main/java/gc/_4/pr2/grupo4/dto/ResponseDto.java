package gc._4.pr2.grupo4.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto<T> {

	private boolean estado;
	private List<String> message;
	private T data;
	private boolean disponible;

	public ResponseDto() {
		
	}
	
	
	public ResponseDto(boolean estado, List<String> message, T data, boolean disponible) {
		super();
		this.estado = estado;
		this.message = message;
		this.data = data;
		this.setDisponible(disponible);
	}

	public ResponseDto(boolean estado, String message, T data, boolean disponible) {
		super();
		this.estado = estado;
		this.message = new ArrayList<>();
		this.message.add(message);
		this.data = data;
		this.setDisponible(disponible);
	}

	public ResponseDto(boolean estado, String message, boolean disponible) {
		super();
		this.estado = estado;
		this.message = new ArrayList<>();
		this.message.add(message);
		this.setDisponible(disponible);
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}

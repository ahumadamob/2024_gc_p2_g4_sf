package gc._4.pr2.grupo4.dto;

public class ResponseDto<T> {
	
	
	//Este atributo esta encapsulado, ya que solo podremos acceder a el a travez de sus getters and Setters
	private boolean estado;
	private String message;
	private T data;
	
	
	
	//Este es el metodo get del encapsulamiento de estado
	public boolean isEstado() {
		return estado;
	}
	
	//Este es el metodo set de encapsulamiento de estado
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	

}
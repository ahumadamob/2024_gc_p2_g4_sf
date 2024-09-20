package gc._4.pr2.grupo4.service;

import java.util.List;

import gc._4.pr2.grupo4.entity.Empleado;

public interface IEmpleadoService {

	public List <Empleado> mostrarTodos();
	public Empleado mostrarPorId (Long id);
	public Empleado guardar(Empleado empleado);
	public void eliminarPorId(Long id);
}

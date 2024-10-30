package gc._4.pr2.grupo4.service;

import java.util.List;

import gc._4.pr2.grupo4.entity.Empleado;

public interface IEmpleadoService {

	public abstract List <Empleado> getAll();
	public abstract Empleado getById (Long id);
	public abstract Empleado save (Empleado empleado);
	public abstract void delete (Long id);
	public abstract boolean exists(Long id);
}

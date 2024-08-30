package gc._4.pr2.grupo4.service;

import java.util.List;
import java.util.Optional;

import gc._4.pr2.grupo4.entity.Empleado;

public interface IEmpleadoService {

		Empleado guardarEmpleado (Empleado empleado);
		List <Empleado> obtenerTodosLosEmpleados();
		Optional<Empleado> obtenerEmpleadoPorId(Long id);
		void eliminarEmpleado(Long id);
}

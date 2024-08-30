package gc._4.pr2.grupo4.service.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Empleado;
import gc._4.pr2.grupo4.repository.EmpleadoRepository;
import gc._4.pr2.grupo4.service.IEmpleadoService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Empleado guardarEmpleado (Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Override
	public List<Empleado> obtenerTodosLosEmpleados () {
		return empleadoRepository.findAll();
	}
	
	@Override
	public Optional<Empleado> obtenerEmpleadoPorId (Long id) {
		return empleadoRepository.findById(id);
	}
	
	@Override
	public void eliminarEmpleado (Long id) {
		empleadoRepository.deleteById(id);
	}
	
	
	


}
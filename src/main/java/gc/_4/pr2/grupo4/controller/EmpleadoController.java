package gc._4.pr2.grupo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo4.entity.Empleado;
import gc._4.pr2.grupo4.service.IEmpleadoService;

@RestController
@RequestMapping ("/empleados")
public class EmpleadoController {
	@Autowired
	private IEmpleadoService empleadoService;
	
	@PostMapping
	public Empleado crearEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.guardarEmpleado(empleado);
	}
	
	@GetMapping 
	public List<Empleado> listarEmpleados(){
		return empleadoService.obtenerTodosLosEmpleados();
	}
	
	@GetMapping("/{id}")
	public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
		return empleadoService.obtenerEmpleadoPorId(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Empleado actualizarEmpelado(@PathVariable Long id, @RequestBody Empleado empleado) {
		Empleado empleadoExiste = empleadoService.obtenerEmpleadoPorId(id).orElse(null);
		if (empleadoExiste !=null) {
			empleadoExiste.setNombre(empleado.getNombre());
			empleadoExiste.setCargo(empleado.getCargo());
			empleadoExiste.setNumeroIdentificacion(empleado.getNumeroIdentificacion());
			empleadoExiste.setSalario(empleado.getSalario());
			empleadoExiste.setFechaContratacion(empleado.getFechaContratacion());
			return empleadoService.guardarEmpleado(empleadoExiste);
		}else {
		return null;
		
	}
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEmpleado(@PathVariable Long id) {
		empleadoService.eliminarEmpleado(id);
		
	}
	
}

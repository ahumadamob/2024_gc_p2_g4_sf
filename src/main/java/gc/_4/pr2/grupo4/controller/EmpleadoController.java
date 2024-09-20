package gc._4.pr2.grupo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo4.entity.Empleado;
import gc._4.pr2.grupo4.service.jpa.EmpleadoServiceImpl;

@RestController
public class EmpleadoController {
	@Autowired
	private EmpleadoServiceImpl empleadoService;
	
	@GetMapping ("/empleado")
	public List<Empleado> mostrarTodosLosEmpleados(){
		return empleadoService.mostrarTodos();
	}
	
	@GetMapping("/mesa/{id}")
	Empleado mostrarEmpleadoPorId(@PathVariable("id") Long id) {
		return empleadoService.mostrarPorId(id);
	}
	
	@PostMapping("/empleado")
	public Empleado crearNuevoEmpleado(@RequestBody Empleado empleadoDesdeElServicio) {
		return empleadoService.guardar(empleadoDesdeElServicio);
	}
	
	@PutMapping("/empleado")
	Empleado actualizarNuevoEmpleado(@RequestBody Empleado empleadoDesdeElServicio) {
		return empleadoService.guardar(empleadoDesdeElServicio);
	}
	
	@DeleteMapping("/empleado/{id}")
	public void eliminarEmpleado(@PathVariable("id") Long id) {
		empleadoService.eliminarPorId(id);
		
	}
	
}

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

import gc._4.pr2.grupo4.entity.Habitacion;
import gc._4.pr2.grupo4.service.IHabitacionService;

@RestController
public class HabitacionController {

	@Autowired
	private IHabitacionService service;
	
	
	@GetMapping("/todasHabitaciones")
	public List<Habitacion> mostrarTodo(){
		return service.getAll();
	}
	
	
	@GetMapping("/habitacion/{id}")
	public Habitacion mostrarById(@PathVariable("id") Long id ) {
		return service.getById(id);
	}
	
	@PostMapping("/nuevaHabitacion")
	public Habitacion guardarHabitacion(@RequestBody Habitacion habitacion) {
		return service.save(habitacion);
	}
	
	@DeleteMapping("/borrarHabitacion/{id}")
	public String borrarById(@PathVariable("id") Long id) {
		service.delete(id);
		return  "Se borro correctamente el id: " + id.toString();
		 
	}
	
	@PutMapping("/actualizaHabitacion")
	public Habitacion actualiza(@RequestBody Habitacion habitacion) {
	   return service.save(habitacion);
	}
}

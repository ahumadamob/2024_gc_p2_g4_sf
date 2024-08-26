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
	
	/*
		
		public abstract Habitacion update(Habitacion habitacion, Long id);*/
	
	@GetMapping("/todasHabitaciones")
	public List<Habitacion> mostrarTodo(){
		return service.getAll();
	}
	
	
	@GetMapping("habitacion/{id}")
	public Habitacion mostrarById(@PathVariable("id") Long id ) {
		return service.getById(id);
	}
	
	// NOTA: necesito la anotacion @RequestBody para efectivamente pasarle el objeto creado por el cliente
	@PostMapping("/nuevaHabitacion")
	public Habitacion guardarHabitacion(@RequestBody Habitacion habitacion) {
			return service.save(habitacion);
	}
	
	@DeleteMapping("borrarHabitacion/{id}")
	public String borrarById(@PathVariable("id") Long id) {
		service.delete(id);
		String respuesta = "Se borro correctamente el id: " + id.toString();
		return respuesta;
	}
	
	@PutMapping("/actualizaHabitacion/{id}")
	public Habitacion actualiza(@RequestBody Habitacion habitacion, @PathVariable("id") Long id) {
		return service.update(habitacion, id);
	}
}

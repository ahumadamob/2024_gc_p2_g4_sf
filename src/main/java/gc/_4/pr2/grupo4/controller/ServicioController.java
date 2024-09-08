package gc._4.pr2.grupo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo4.entity.Servicio;
import gc._4.pr2.grupo4.service.IServicioService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ServicioController {
	
	//Primer paso, inyeccion de servicio
	@Autowired
	private IServicioService service;
	
	@GetMapping("/servicios")
	public List <Servicio> obtenerServicios(){
		return service.getAll();
	}
	
	@GetMapping("/servicios/{id}")
	public Servicio obtenerServiciosPorId(@PathVariable ("id") Long id) {
		return service.getById(id);
		}
	
	@PostMapping("/servicios")
	public Servicio crearNuevoServicio(@RequestBody Servicio servicioDesdeService ) {
		return service.save(servicioDesdeService);
	}
	
	@DeleteMapping ("/servicios/{id}")
	void borrarServicio (@PathVariable("id")  Long id) {
		service.deleteById(id);
		
	}
	
	
	
	

}

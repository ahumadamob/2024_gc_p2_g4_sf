package gc._4.pr2.grupo4.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gc._4.pr2.grupo4.dto.ResponseDto;
import gc._4.pr2.grupo4.entity.Servicio;
import gc._4.pr2.grupo4.service.IServicioService;



@RestController
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService service;
	
	
	@GetMapping
	public ResponseEntity<ResponseDto<List<Servicio>>> obtenerServicios(){
		
		return !service.getAll().isEmpty() ? new ResponseEntity<>(new ResponseDto<>(true,"Listado completo de Servicios", service.getAll()),HttpStatus.OK) :
			new ResponseEntity<>(new ResponseDto<>(false,"No existe listado de Servicio", service.getAll()),HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto<Servicio>> obtenerServiciosPorId(@PathVariable ("id") Long id) {

		
		return service.exists(id) ? new ResponseEntity<>(new ResponseDto<>(true,"El servicio con id: " + id.toString() + " ha sido encontrado", service.getById(id)),HttpStatus.OK) :
			new ResponseEntity<>(new ResponseDto<>(false,"El servicio con id: "+ id.toString() + " no existe"),HttpStatus.NOT_FOUND);
		
		}
	
	
	@PostMapping
	public ResponseEntity<ResponseDto<Servicio>> crearNuevoServicio(@RequestBody Servicio servicio ) {
		
		
		if(servicio.getId() == null ) {
			
			ResponseDto<Servicio> response = new ResponseDto<>(true,"Servicio nuevo creado",service.save(servicio));
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}else {
			
			if (service.exists(servicio.getId())) {
			
			ResponseDto<Servicio> response = new ResponseDto<>(false,"El servicio con id: " + servicio.getId().toString() + " ya existe",service.getById(servicio.getId()));
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
			}else {
				
			ResponseDto<Servicio> response = new ResponseDto<>(false,"Peticion erronea, enviar nuevamente sin ID");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
			}
		}
	}
	
	
	
	@PutMapping
	public ResponseEntity<ResponseDto<Servicio>> modificaServicio(@RequestBody Servicio servicio) {
		
		if(servicio.getId()!= null) {
	
			if(service.exists(servicio.getId())) {
				
				ResponseDto<Servicio> response = new ResponseDto<>(true,"Servicio con id: " + servicio.getId().toString() + " actualizado",service.save(servicio));
				return new ResponseEntity<>(response,HttpStatus.OK);
		
			}else {
				
				ResponseDto<Servicio> response = new ResponseDto<>(false,"El id: " + servicio.getId().toString() +" para actualizar es invalido");
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

		       } 
			
		}else {
			
			ResponseDto<Servicio> response = new ResponseDto<>(false,"Para actualizar un Servicio ingrese un ID valido");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	  }
	}
	
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<ResponseDto<Servicio>>  borrarServicio (@PathVariable("id")  Long id) {
	
		if(service.exists(id)) {
			service.deleteById(id);
			return new ResponseEntity<>(new ResponseDto<>(true,"Servicio con id: " + id.toString() + " ha sido eliminado"),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new ResponseDto<>(false,"Servicio con id: " + id.toString() + " No existe"),HttpStatus.BAD_REQUEST);
		}
    } 
}

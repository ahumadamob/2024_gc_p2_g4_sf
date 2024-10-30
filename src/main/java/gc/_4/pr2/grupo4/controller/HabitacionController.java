package gc._4.pr2.grupo4.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo4.dto.ResponseDto;
import gc._4.pr2.grupo4.entity.Habitacion;
import gc._4.pr2.grupo4.service.IHabitacionService;
import gc._4.pr2.grupo4.service.jpa.HabitacionServiceImpl;




@RestController
public class HabitacionController {

	@Autowired
	private IHabitacionService service;
	
	
	@GetMapping("/habitaciones")
	
	public  ResponseEntity<ResponseDto> obtenerHabitaciones(){
		//Instanciamos un objeto del tipo ResponseDto
		ResponseDto<List<Habitacion>> response= new ResponseDto<>();
		
		//Instanciamos una Lista del tipo Habitacion
		List<Habitacion> list= new ArrayList<>();
		
		//Vamos a obtener todo lo que este persistido
		list = service.getAll();
		
			if(!list.isEmpty()) {
			
			//Como la lista contiene datos entonces los retornamos con mensaje exitoso
			//Primero preparamos DTO 
			response.setEstado(true);
			response.setMessage("Listado completo de Habitaciones");
			response.setData(list);
			
			//Instanciamos el ResponseEntity que vamos a retornar, con los parametros ResponseDto y el codigo correspondiente
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			//Finalmente retornamos
			
			return finalResponse;
			
		}else {
			//Como la lista esta vacia, retornamos con mensaje de error
			//Primero preparamos DTO
			response.setEstado(false);
			response.setMessage("No existe listado de Habitaciones");
			response.setData(null); //esta linea es innecesaria ya que al instanciarlo ya esta en null
			
			//Instanciamos el ResponseEntity que vamos a retornar, con los parametros ResponseDto y el codigo correspondiente
			//Utilizamos estado OK, ya que NO_CONTENT no permite un body en la respuesta
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
		}

	}
	
	
	@GetMapping("/habitaciones/{id}")
		public ResponseEntity<ResponseDto> obtenerHabitacionPorId(@PathVariable ("id") Long id) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Habitacion> response = new ResponseDto<>();
		
		if(service.exists(id)) {
			
			//si la habitacion existe recibimos un objeto servicio
			Habitacion habitacion = service.getById(id);
			
			//Preparamos nuestro DTO
			response.setEstado(true);
			response.setMessage("La habitacion con id: " + id.toString() + " ha sido encontrada");
			response.setData(habitacion);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
			
		}else {
			//Preparamos nuestro DTO
			response.setEstado(false);
			response.setMessage("La habitacion con id: " + id.toString() + " no existe");
			response.setData(null);//linea innecesaria, el object ya esta en null
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			
			//Finalmente retornamos
			return finalResponse;
		  }
		}
	
	
	@PostMapping("/habitaciones")
		public ResponseEntity<ResponseDto> crearHabitacion(@RequestBody Habitacion habitacion) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Habitacion> response = new ResponseDto<>();
		
		if(habitacion.getId()==null ) {
			
			Habitacion habitacionPersistida = service.save(habitacion);
			
			//Preparamos nuestro DTO
			response.setEstado(true);
			response.setMessage("Nueva habitacion creada");
			response.setData(habitacionPersistida);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
			
		}else {
			
			//  En caso de que envien con ID, analizamos si existe o no existe
			
			if (service.exists(habitacion.getId())) {
			
			// Preparamos nuestro DTO
			response.setEstado(false);
			response.setMessage("La habitacion con id: " + habitacion.getId()  + " ya existe");
			response.setData(service.getById(habitacion.getId()));
			
			
			
			// Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
			// Finalmente retornamos
			return finalResponse;
			
			} else {
				
				// Preparamos nuestro DTO
				response.setEstado(false);
				response.setMessage("Peticion erronea, enviar nuevamente sin ID");
				response.setData(null);
				
				// Instanciamos Nuestro ResponseEntity
				ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
				
				// Finalmente retornamos
				return finalResponse;
			}			
		}

	}
	
	
	@PutMapping("/habitaciones")
	public ResponseEntity<ResponseDto> modificaHabitacion(@RequestBody Habitacion habitacion) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Habitacion> response = new ResponseDto<>();
		
		if(service.exists(habitacion.getId())) {
			
			// El objeto viene con ID, pero vamos a corroborar que dicho id exista
			
				Habitacion habitacionPersistida = service.save(habitacion);
					
				// Preparamos nuestro DTO
				response.setEstado(true);
				response.setMessage("Servicio con id: " + habitacion.getId() + " actualizado");
				response.setData(habitacionPersistida);
				
				//Instanciamos Nuestro ResponseEntity
				ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
				
				//Finalmente retornamos
				return finalResponse;
						
		}else {
			
			// Preparamos nuestro DTO
			response.setEstado(false);
			response.setMessage("Para actualizar un Servicio ingrese un ID valido");
			response.setData(null);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
			//Finalmente retornamos
			return finalResponse;
		}
		
	}
	

	@DeleteMapping("/habitaciones/{id}")
		public ResponseEntity<ResponseDto>  borrarHabitacion (@PathVariable("id")  Long id) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Habitacion> response = new ResponseDto<>();
		
		//comprobamos que dicho id exista
		
		if(service.exists(id)) {
			
			//Eliminamos
			service.delete(id);
			
			//Preparamos el DTO
			response.setEstado(true);
			response.setMessage("Servicio con id: " + id.toString() + " Eliminado");
			response.setData(null);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
			
		}else {
			
			//Preparamos el DTO
			response.setEstado(false);
			response.setMessage("Servicio con id: " + id.toString() + " No existe");
			response.setData(null);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
			//Finalmente retornamos
			return finalResponse;
		}
	}
	
	
	
	
	
	
	
	
	}
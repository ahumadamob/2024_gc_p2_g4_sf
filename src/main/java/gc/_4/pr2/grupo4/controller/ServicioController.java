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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gc._4.pr2.grupo4.dto.ResponseDto;
import gc._4.pr2.grupo4.entity.Servicio;
import gc._4.pr2.grupo4.service.IServicioService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService service;
	
	
	
	
	@GetMapping
	public ResponseEntity<ResponseDto> obtenerServicios(){
		
		//Instanciamos un objeto del tipo ResponseDto (ESTE ES MI EJEMPLO DE INSTANCIACION DE UN OBJETO)
		ResponseDto<List<Servicio>> response = new ResponseDto<>();
		
		//Instanciamos una Lista del tipo Servicio
		List<Servicio> list = new ArrayList<>();
		
		//Vamos a obtener todo lo que este persistido
		list = service.getAll();
		
		//Separamos los dos casos, que tenga datos o que no tenga datos
		
		if(!list.isEmpty()) {
			
			//Como la lista contiene datos entonces los retornamos con mensaje exitoso
			//Primero preparamos DTO (Este es mi ejemplo de inicializacion de un objeto)
			response.setEstado(true);
			response.setMessage("Listado completo de Servicios");
			response.setData(list);
			
			//Instanciamos el ResponseEntity que vamos a retornar, con los parametros ResponseDto y el codigo correspondiente
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			//Finalmente retornamos
			
			return finalResponse;
			
		}else {
			//Como la lista esta vacia, retornamos con mensaje de error
			//Primero preparamos DTO
			response.setEstado(false);
			response.setMessage("No existe listado de Servicio");
			response.setData(null); //esta linea es innecesaria ya que al instanciarlo ya esta en null
			
			//Instanciamos el ResponseEntity que vamos a retornar, con los parametros ResponseDto y el codigo correspondiente
			//Utilizamos estado OK, ya que NO_CONTENT no permite un body en la respuesta
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
		}
		
		
	}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> obtenerServiciosPorId(@PathVariable ("id") Long id) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Servicio> response = new ResponseDto<>();
		
		if(service.exists(id)) {
			
			//si el servicio existe recibimos un objeto servicio
			Servicio servicio = service.getById(id);
			
			//Preparamos nuestro DTO
			response.setEstado(true);
			response.setMessage("El servicio con id: " + id.toString() + " ha sido encontrado");
			response.setData(servicio);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
			
		}else {
			//Preparamos nuestro DTO
			response.setEstado(false);
			response.setMessage("El servicio con id: " + id.toString() + " no existe");
			response.setData(null);//linea innecesaria, el object ya esta en null
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			
			//Finalmente retornamos
			return finalResponse;
		  }
		}
	
	@PostMapping
	public ResponseEntity<ResponseDto> crearNuevoServicio(@RequestBody Servicio servicio ) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Servicio> response = new ResponseDto<>();
		
		if(servicio.getId() == null ) {
			
			Servicio servicioPersistido = service.save(servicio);
			
			//Preparamos nuestro DTO
			response.setEstado(true);
			response.setMessage("Servicio nuevo creado");
			response.setData(servicioPersistido);
			
			//Instanciamos Nuestro ResponseEntity
			ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
			
			//Finalmente retornamos
			return finalResponse;
			
		}else {
			
			//  En caso de que envien con ID, analizamos si existe o no existe
			
			if (service.exists(servicio.getId())) {
			
			// Preparamos nuestro DTO
			response.setEstado(false);
			response.setMessage("El servicio con id: " + servicio.getId().toString() + " ya existe");
			response.setData(service.getById(servicio.getId()));
			
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
	
	
	@PutMapping
	public ResponseEntity<ResponseDto> modificaServicio(@RequestBody Servicio servicio) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Servicio> response = new ResponseDto<>();
		
		if(servicio.getId()!= null) {
			
			// El objeto viene con ID, pero vamos a corroborar que dicho id exista
			
			if(service.exists(servicio.getId())) {
				
				Servicio servicioPersistido = service.save(servicio);
				
				// Preparamos nuestro DTO
				response.setEstado(true);
				response.setMessage("Servicio con id: " + servicio.getId().toString() + " actualizado");
				response.setData(servicioPersistido);
				
				//Instanciamos Nuestro ResponseEntity
				ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.OK);
				
				//Finalmente retornamos
				return finalResponse;
				
			}else {
				
				// Preparamos nuestro DTO
				response.setEstado(false);
				response.setMessage("El id: " + servicio.getId().toString() +" ingresado es invalido");
				response.setData(null);
				
				//Instanciamos Nuestro ResponseEntity
				ResponseEntity<ResponseDto> finalResponse = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
				
				//Finalmente retornamos
				return finalResponse;
			}
			
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
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<ResponseDto>  borrarServicio (@PathVariable("id")  Long id) {
		
		//Primero Instanciamos nuesto ResponseDto
		ResponseDto<Servicio> response = new ResponseDto<>();
		
		//comprobamos que dicho id exista
		
		if(service.exists(id)) {
			
			//Eliminamos
			service.deleteById(id);
			
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

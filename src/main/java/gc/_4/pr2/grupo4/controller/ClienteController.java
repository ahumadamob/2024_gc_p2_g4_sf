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

import gc._4.pr2.grupo4.service.IClienteService;
import gc._4.pr2.grupo4.entity.Cliente;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping("/cliente")

	public List<Cliente> mostrarTodo(){

		return service.getAll();

	}

	@GetMapping("/cliente/{id}")

	public Cliente mostrarById(@PathVariable("id") Long id ) {

		return service.getById(id);

	}

	@PostMapping("/cliente")

	public Cliente guardarCliente(@RequestBody Cliente cliente) {

		return service.save(cliente);

	}

	@DeleteMapping("/cliente{id}")

	public String borrarById(@PathVariable("id") Long id) {

		service.delete(id);

		String respuesta = "Se borro correctamente el Cliente por id: " + id.toString();

		return respuesta;

	}

	@PutMapping("/cliente")

	public Cliente actualiza(@RequestBody Cliente cliente) {

	   return service.save(cliente);

	}

}

package gc._4.pr2.grupo4.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Cliente;

@Service

public interface IClienteService {
	
	public abstract List <Cliente> getAll(); 
	public abstract Cliente getById(Long id);
	public abstract Cliente save(Cliente cliente);
	public abstract void delete(Long id);

}

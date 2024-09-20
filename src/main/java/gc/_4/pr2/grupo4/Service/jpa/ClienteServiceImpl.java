package gc._4.pr2.grupo4.Service.jpa;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.Service.IClienteService;
import gc._4.pr2.grupo4.entity.Cliente;
import gc._4.pr2.grupo4.repository.ClienteRepository;

@Service

public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Override
	public List<Cliente> getAll()  {
		
		return repositoryCliente.findAll();
	}

	@Override
	
	public Cliente getById(Long id) {
		
		return repositoryCliente.findById(id).orElse(null);	
	}
	
	@Override
	public Cliente save(Cliente cliente) {
		
		return repositoryCliente.save(cliente);
	}

	@Override
	public void delete(Long id) {
		
		repositoryCliente.deleteById(id);
	}

	
}
		
	

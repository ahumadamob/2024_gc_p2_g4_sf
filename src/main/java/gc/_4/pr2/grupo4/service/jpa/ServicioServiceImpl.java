package gc._4.pr2.grupo4.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Servicio;
import gc._4.pr2.grupo4.repository.ServicioRepository;
import gc._4.pr2.grupo4.service.IServicioService;

@Service

public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private ServicioRepository repositoryServicio;

	@Override
	public List<Servicio> getAll() {
		return repositoryServicio.findAll();
	}

	@Override
	public Servicio getById(Long id) {
		return repositoryServicio.findById(id).orElse(null);
	}

	@Override
	public Servicio save(Servicio servicio) {
		return repositoryServicio.save(servicio);
	}

	@Override
	public void deleteById(Long id) {
		repositoryServicio.deleteById(id);
	}

	@Override
	public boolean exists(Long id) {
		return id != null ? repositoryServicio.existsById(id) : false;
	}

}

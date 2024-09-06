package gc._4.pr2.grupo4.service.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Habitacion;
import gc._4.pr2.grupo4.entity.Reserva;
import gc._4.pr2.grupo4.repository.HabitacionRepository;
import gc._4.pr2.grupo4.service.IHabitacionService;
import jakarta.persistence.OneToMany;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private HabitacionRepository repositoryHabitacion;
	
	@Override
	public List<Habitacion> getAll() {
		return repositoryHabitacion.findAll();
	}

	@Override
	public Habitacion getById(Long id) {
	return repositoryHabitacion.findById(id).orElse(null);
	}

	@Override
	public Habitacion save(Habitacion habitacion) {
		return repositoryHabitacion.save(habitacion);
	}

	@Override
	public void delete(Long id) {
		repositoryHabitacion.deleteById(id);
		
	}

}

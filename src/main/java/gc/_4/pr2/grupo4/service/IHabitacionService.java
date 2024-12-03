package gc._4.pr2.grupo4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Habitacion;

@Service
public interface IHabitacionService {
	
	public abstract List <Habitacion> getAll();
	public abstract Habitacion getById(Long id);
	public abstract Habitacion save(Habitacion habitacion);
	public abstract void delete(Long id);
	public abstract boolean exists(Long id);
    public List<Habitacion> findByDisponible(boolean disponible);
	
	// Se agrega nuevo metodo para retornar la lista
	
	List<Habitacion> findByDisponible(boolean disponible);
	
}

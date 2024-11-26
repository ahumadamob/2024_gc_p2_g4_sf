package gc._4.pr2.grupo4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo4.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository <Habitacion, Long> {

	List<Habitacion> findByDisponible(boolean disponible);
}

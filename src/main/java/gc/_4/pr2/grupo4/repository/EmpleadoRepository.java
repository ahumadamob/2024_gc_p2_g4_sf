package gc._4.pr2.grupo4.repository;
//creacion de repositorios para las entidades
import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo4.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado,Long>{

}

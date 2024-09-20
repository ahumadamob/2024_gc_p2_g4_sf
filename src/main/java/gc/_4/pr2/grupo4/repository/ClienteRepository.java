package gc._4.pr2.grupo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo4.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	

}

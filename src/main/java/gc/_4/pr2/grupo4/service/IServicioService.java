package gc._4.pr2.grupo4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gc._4.pr2.grupo4.entity.Servicio;

@Service
public interface IServicioService {
	
	public List <Servicio> getAll();
	public Servicio getById (Long id);
	public Servicio save (Servicio servicio);
	public void deleteById (Long id);
	

}

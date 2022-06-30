package com.irfeyal.modelo.dao.rolseguridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Canton;
import com.irfeyal.modelo.rolseguridad.Provincia;

public interface CantonDAO extends CrudRepository<Canton, Long> {
	Page<Canton> findAll(Pageable pageable);
	
	
	@Query(value = "select c from Canton c where c.provincia.idProvincia = ?1")
	public List<Canton>  findByProvincia(Long id);

}
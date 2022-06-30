package com.irfeyal.modelo.dao.rolseguridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Canton;
import com.irfeyal.modelo.rolseguridad.Parroquia;


public interface ParroquiaDAO extends CrudRepository<Parroquia,Long>{
	Page<Parroquia> findAll(Pageable pageable);
	
	@Query(value = "select p from Parroquia p where p.id_canton.idCanton = ?1")
	public List<Parroquia>  findByCanton(Long id);
}

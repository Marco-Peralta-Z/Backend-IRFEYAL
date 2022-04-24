package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.RecepcionArticulo;

@Repository
public interface RecepcionArticuloDao extends CrudRepository<RecepcionArticulo, Long>{

}

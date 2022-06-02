package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.ControlArticulo;

@Repository
public interface ControlArticuloDao extends CrudRepository<ControlArticulo, Long> {

}

package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Salidaarticulo;

@Repository
public interface SalidaArticuloDao extends CrudRepository<Salidaarticulo, Long>{

}

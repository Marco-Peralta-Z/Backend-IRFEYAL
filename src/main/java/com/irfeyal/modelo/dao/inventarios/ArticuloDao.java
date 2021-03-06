package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Articulo;

@Repository
public interface ArticuloDao extends CrudRepository<Articulo, Long> {

}

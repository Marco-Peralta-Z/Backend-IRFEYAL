package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.ModuloLibro;

@Repository
public interface ModuloLibroDao extends CrudRepository<ModuloLibro, Long>{

}

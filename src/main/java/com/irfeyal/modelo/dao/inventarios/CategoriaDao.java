package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Categoria;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Long> {

}

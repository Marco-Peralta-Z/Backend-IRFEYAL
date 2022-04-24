package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Inventario;

@Repository
public interface InventarioDao extends CrudRepository<Inventario, Long> {

}

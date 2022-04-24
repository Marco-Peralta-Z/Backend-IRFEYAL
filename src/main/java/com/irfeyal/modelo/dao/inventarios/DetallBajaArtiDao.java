package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.DetallebajaArti;

@Repository
public interface DetallBajaArtiDao extends CrudRepository<DetallebajaArti, Long> {

}

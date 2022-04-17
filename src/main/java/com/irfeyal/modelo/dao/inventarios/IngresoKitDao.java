package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.IngresoKit;

@Repository//("IngresoKitRepo")
public interface IngresoKitDao extends CrudRepository<IngresoKit, Long> {

}

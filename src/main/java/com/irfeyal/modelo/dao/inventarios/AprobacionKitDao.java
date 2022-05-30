package com.irfeyal.modelo.dao.inventarios;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Repository
public interface AprobacionKitDao extends CrudRepository<AprobacionKit, Long> {

}

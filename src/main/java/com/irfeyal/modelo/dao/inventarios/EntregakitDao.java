package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.irfeyal.modelo.inventarios.EntregaKit;

@Repository
public interface EntregakitDao extends CrudRepository<EntregaKit, Long> {

}

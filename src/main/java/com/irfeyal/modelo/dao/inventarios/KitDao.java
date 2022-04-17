package com.irfeyal.modelo.dao.inventarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Kit;



@Repository//("kitRepo")
public interface KitDao extends CrudRepository<Kit, Long> {

}

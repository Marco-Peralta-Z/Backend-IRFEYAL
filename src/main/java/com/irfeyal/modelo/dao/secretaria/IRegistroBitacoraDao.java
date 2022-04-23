package com.irfeyal.modelo.dao.secretaria;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.RegistroBitacora;

public interface IRegistroBitacoraDao extends CrudRepository<RegistroBitacora, Long>{

	Page<RegistroBitacora> findAll(Pageable pageable);
	
}

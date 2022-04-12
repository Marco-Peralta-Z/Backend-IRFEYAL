package com.irfeyal.modelo.dao.rolseguridad;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.CorreoElectronico;






public interface CorreoElectronicoDAO extends CrudRepository<CorreoElectronico, Long> {
	Page<CorreoElectronico> findAll(Pageable pageable);
}

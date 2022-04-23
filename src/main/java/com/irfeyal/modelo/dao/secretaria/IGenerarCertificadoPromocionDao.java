package com.irfeyal.modelo.dao.secretaria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.GenerarCertificadoPromocion;

public interface IGenerarCertificadoPromocionDao extends CrudRepository<GenerarCertificadoPromocion, Long>{
	
	Page<GenerarCertificadoPromocion> findAll(Pageable pageable);
}

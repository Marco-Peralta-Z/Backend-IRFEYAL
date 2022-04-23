package com.irfeyal.modelo.dao.pagos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.pagos.Comprobante;

public interface IComprobanteDao extends CrudRepository<Comprobante, Long>{
	
	Page<Comprobante> findAll(Pageable pageable);
}

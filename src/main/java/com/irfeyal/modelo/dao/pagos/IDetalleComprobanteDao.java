package com.irfeyal.modelo.dao.pagos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.pagos.DetalleComprobante;

public interface IDetalleComprobanteDao extends CrudRepository<DetalleComprobante, Long>{
	
	Page<DetalleComprobante> findAll(Pageable pageable);
}

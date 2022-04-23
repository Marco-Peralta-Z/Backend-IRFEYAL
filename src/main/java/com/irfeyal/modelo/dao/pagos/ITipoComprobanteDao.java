package com.irfeyal.modelo.dao.pagos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.pagos.TipoComprobante;

public interface ITipoComprobanteDao extends CrudRepository<TipoComprobante,Long>{

	Page<TipoComprobante> findAll(Pageable pageable);
}

package com.irfeyal.interfaces.pagos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.pagos.TipoComprobante;

public interface ITipoComprobanteService {


	public List<TipoComprobante> findAll();
	
	public Page<TipoComprobante> findAll(Pageable pageable);
	
	public TipoComprobante findById(Long id);
	
	public TipoComprobante save(TipoComprobante tipoComprobante);
	
	public void delete (Long id);
	
}

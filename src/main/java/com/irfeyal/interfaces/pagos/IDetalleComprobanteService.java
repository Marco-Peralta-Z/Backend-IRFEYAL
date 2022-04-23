package com.irfeyal.interfaces.pagos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.pagos.DetalleComprobante;

public interface IDetalleComprobanteService {
	
public List<DetalleComprobante> findAll();
	
	public Page<DetalleComprobante> findAll(Pageable pageable);
	
	public DetalleComprobante findById(Long id);
	
	public DetalleComprobante save(DetalleComprobante detalleComprobante);
	
	public void delete (Long id);
	
}

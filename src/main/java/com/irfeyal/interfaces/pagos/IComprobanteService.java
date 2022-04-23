package com.irfeyal.interfaces.pagos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.pagos.Comprobante;

public interface IComprobanteService {
	
public List<Comprobante> findAll();
	
	public Page<Comprobante> findAll(Pageable pageable);
	
	public Comprobante findById(Long id);
	
	public Comprobante save(Comprobante comprobante);
	
	public void delete (Long id);
	
}

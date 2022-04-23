package com.irfeyal.interfaces.pagos;

import java.util.List;

import com.irfeyal.modelo.pagos.TipoPago;

public interface ITipoPagoService {
	
	public List<TipoPago> findAll();
	
    public TipoPago save(TipoPago tipoPago);
	
	public TipoPago findById(Long id);
	
	public void delete(Long id);

}

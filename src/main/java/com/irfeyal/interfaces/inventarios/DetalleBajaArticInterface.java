package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.DetallebajaArti;


public interface DetalleBajaArticInterface {
	public abstract DetallebajaArti save(DetallebajaArti detallebajaArti);

	public abstract List<DetallebajaArti> listAllDetallebajaArti();
	
	public abstract Optional<DetallebajaArti> getById(Long id_detallebajaArti);

	public abstract DetallebajaArti update(Long id_detallebajaArti, double nuevaDetallebajaArti);

	public abstract boolean delete(Long id_DetallebajaArti);
}

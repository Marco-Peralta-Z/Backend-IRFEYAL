package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.ControlArticulo;


public interface ControlArticuloInterface {
	public abstract ControlArticulo save(ControlArticulo detalIngreArti);

	public abstract List<ControlArticulo> listAllDetalIngreArti();
	
	public abstract Optional<ControlArticulo> getById(Long id_detalIngreArti);

	public abstract ControlArticulo update(Long id_detalIngreArti, double nuevaDetalIngreArti);

	public abstract boolean delete(Long id_DetalIngreArti);
}

package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.DetalIngreArti;


public interface DetallingreArticuloInterface {
	public abstract DetalIngreArti save(DetalIngreArti detalIngreArti);

	public abstract List<DetalIngreArti> listAllDetalIngreArti();
	
	public abstract Optional<DetalIngreArti> getById(Long id_detalIngreArti);

	public abstract DetalIngreArti update(Long id_detalIngreArti, double nuevaDetalIngreArti);

	public abstract boolean delete(Long id_DetalIngreArti);
}

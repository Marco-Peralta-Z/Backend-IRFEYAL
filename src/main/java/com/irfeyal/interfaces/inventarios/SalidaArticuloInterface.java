package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.Salidaarticulo;


public interface SalidaArticuloInterface {
	public abstract Salidaarticulo save(Salidaarticulo salidaarticulo);

	public abstract List<Salidaarticulo> listAllSalidaarticulo();
	
	public abstract Optional<Salidaarticulo> getById(Long id_Salidaarticulo);

	public abstract Salidaarticulo update(Long id_Salidaarticulo, double nuevoSalidaarticulo);

	public abstract Salidaarticulo delete(Long id_Salidaarticulo);
}

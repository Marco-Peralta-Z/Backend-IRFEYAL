package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.RecepcionArticulo;


public interface RecepcionArticuloInterface {
	public abstract RecepcionArticulo save(RecepcionArticulo recepcionArticulo);

	public abstract List<RecepcionArticulo> listAllRecepcionArticulo();
	
	public abstract Optional<RecepcionArticulo> getById(Long id_RecepcionArticulo);

	public abstract RecepcionArticulo update(Long id_RecepcionArticulo, double nuevoRecepcionArticulo);

	public abstract boolean delete(Long id_RecepcionArticulo);
}

package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.Inventario;


public interface InventarioInterface {
	public abstract Inventario save(Inventario inventario);

	public abstract List<Inventario> listAllInventario();
	
	public abstract Optional<Inventario> getById(Long id_Inventario);

	public abstract Inventario update(Long id_Inventario, double nuevoInventario);

	public abstract boolean delete(Long id_inventario);
}

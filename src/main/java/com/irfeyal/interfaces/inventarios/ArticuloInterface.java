package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.Articulo;


public interface ArticuloInterface {
	public abstract Articulo save(Articulo articulo);

	public abstract List<Articulo> listAllArticulo();
	
	public abstract Optional<Articulo> getById(Long id_articulo);

	public abstract Articulo update(Long id_articulo, double nuevoArticulo);

	public abstract boolean delete(Long id_articulo);
}

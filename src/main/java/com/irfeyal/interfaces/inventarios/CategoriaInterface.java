package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.inventarios.Categoria;


public interface CategoriaInterface {
	public abstract Categoria save(Categoria categoria);

	public abstract List<Categoria> listAllCategoria();
	
	public abstract Optional<Categoria> getById(Long id_categoria);

	public abstract Categoria update(Long id_categoria, double nuevaCategoria);

	public abstract Categoria delete(Long id_categoria);
}

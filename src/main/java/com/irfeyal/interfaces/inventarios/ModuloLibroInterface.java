package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.ModuloLibro;

public interface ModuloLibroInterface {
	
	public abstract ModuloLibro save(ModuloLibro modulolibro);

	public abstract List<ModuloLibro> listAllModuloLibro();
	
	public abstract Optional<ModuloLibro> getById(Long moduloLibroId);

	public abstract ModuloLibro update(Long moduloLibroId, double nuevoModuloLibro);

	public abstract boolean delete(Long moduloLibroId);
}

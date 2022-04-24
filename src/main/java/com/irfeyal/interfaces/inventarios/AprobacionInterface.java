package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.rolseguridad.Empleado;


public interface AprobacionInterface  {
	
	public abstract Aprobacion save(Aprobacion id_aprobacion,Empleado empleado);

	public abstract List<Aprobacion> listAllAprobacion();
	
	public abstract Optional<Aprobacion > getById(Long id_aprobacion);

	public abstract Aprobacion update(Long id_aprobacion, double nuevaAprobacion);

	public abstract boolean delete(Long id_aprobacion);
}

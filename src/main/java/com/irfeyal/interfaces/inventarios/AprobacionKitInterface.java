package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.AprobacionKit;


public interface AprobacionKitInterface  {
	
	public abstract AprobacionKit save(AprobacionKit id_aprobacion);

	public abstract List<AprobacionKit> listAllAprobacion();
	
	public abstract Optional<AprobacionKit > getById(Long id_aprobacion);

	public abstract AprobacionKit update(Long id_aprobacion, double nuevaAprobacion);

	public abstract boolean delete(Long id_aprobacion);
}

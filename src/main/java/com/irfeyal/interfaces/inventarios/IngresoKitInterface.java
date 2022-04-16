package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.IngresoKit;


public interface IngresoKitInterface {
	public abstract IngresoKit save(IngresoKit ingresoKit);

	public abstract List<IngresoKit> listAllIngresoKit();
	
	public abstract Optional<IngresoKit> getById(Long ingresoKitId);

	public abstract IngresoKit update(Long ingresoKitId, double nuevoIngresoKit);

	public abstract boolean delete(Long ingresoKitId);
	
}

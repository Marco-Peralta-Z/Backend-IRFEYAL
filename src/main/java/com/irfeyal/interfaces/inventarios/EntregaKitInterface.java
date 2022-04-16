package com.irfeyal.interfaces.inventarios;

import java.util.List;
import java.util.Optional;
import com.irfeyal.modelo.inventarios.EntregaKit;


public interface EntregaKitInterface {

	
	public abstract EntregaKit save(EntregaKit entregaKit);

	public abstract List<EntregaKit> listAllEntregaKit();
	
	public abstract Optional<EntregaKit> getById(Long entregaKitId);

	public abstract EntregaKit update(Long entregaKitId, double nuevaEntregaKit);

	public abstract boolean delete(Long entregaKitId);
	
}

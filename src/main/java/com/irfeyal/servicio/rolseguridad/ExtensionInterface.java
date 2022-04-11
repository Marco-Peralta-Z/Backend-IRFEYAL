package com.irfeyal.servicio.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Extension;



public interface ExtensionInterface {
	
public List<Extension> findAll();
	
	public Page<Extension> findAll(Pageable pageable);
	
	public Extension findById(Long id);
	
	public Extension saveExtension(Extension extension);
	
	public List<Extension> deleteExtension (Long id);
}

package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.rolseguridad.ExtensionInterface;
import com.irfeyal.modelo.dao.rolseguridad.ExtensionDAO;
import com.irfeyal.modelo.rolseguridad.Extension;


@Service
public class ExtensionServices implements ExtensionInterface {

	@Autowired
	  private ExtensionDAO extension;

	@Override
	public List<Extension> findAll() {
		// TODO Auto-generated method stub
		return (List<Extension>) extension.findAll();
	}

	@Override
	public Page<Extension> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return extension.findAll(pageable);
	}

	@Override
	public Extension findById(Long id) {
		// TODO Auto-generated method stub
		return extension.findById(id).orElse(null);
	}

	@Override
	public Extension saveExtension(Extension extension) {
		// TODO Auto-generated method stub
		return this.extension.save(null);
	}

	@Override
	public void deleteExtension(Long id) {
		// TODO Auto-generated method stub
		extension.deleteById(id);
	}
	  
	


}

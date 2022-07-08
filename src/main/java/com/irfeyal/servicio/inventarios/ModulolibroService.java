package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.ModuloLibroInterface;
import com.irfeyal.modelo.dao.inventarios.ModuloLibroDao;
import com.irfeyal.modelo.inventarios.ModuloLibro;



@Service
@Transactional
public class ModulolibroService implements ModuloLibroInterface {

	@Autowired
	private ModuloLibroDao moduloLibroRepo;

	@Override
	public ModuloLibro save(ModuloLibro modulolibro) {
		
		ModuloLibro newModuloLibro = moduloLibroRepo.save(modulolibro);
		
		return newModuloLibro;
		
	}

	@Override
	public List<ModuloLibro> listAllModuloLibro() {
		// TODO Auto-generated method stub
		return (List<ModuloLibro>) moduloLibroRepo.findAll();
	}

	@Override
	public Optional<ModuloLibro> getById(Long moduloLibroId) {
		// TODO Auto-generated method stub
		return moduloLibroRepo.findById(moduloLibroId);
	}



	
	  public boolean ValidarModuloLibro(ModuloLibro moduloLibro){
			//String id_modulo_libro= ""+moduloLibro.;
		    String codModulo= moduloLibro.getCodModulo();
		    String nombreModulo=moduloLibro.getNombreModulo();
		    int cantidad=moduloLibro.getCantidad();
		    String numeroModulo=moduloLibro.getNumeroModulo();
		    if(codModulo.length() > 0
		       && nombreModulo != null
		       && cantidad>0
		       && numeroModulo != null) {
		    	return true;
		    }else {
		    	return false;
		    }
			
		}

	@Override
	public ModuloLibro delete(Long moduloLibroId) {
		ModuloLibro moduloL = getById(moduloLibroId).get();
		if(moduloL == null) {
			return null;
		}else {
			moduloLibroRepo.deleteById(moduloLibroId);
			return moduloL;
			
		}
	}

	@Override
	public ModuloLibro update(ModuloLibro moduloLibroUpdate) {
		
		ModuloLibro moduloLib = moduloLibroRepo.save(moduloLibroUpdate);
		
		return moduloLib;
	}

	
	
	
}

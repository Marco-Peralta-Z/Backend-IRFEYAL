package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.ModuloLibroInterface;
import com.irfeyal.modelo.dao.inventarios.ModuloLibroDao;
import com.irfeyal.modelo.inventarios.ModuloLibro;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;


@Service
@Transactional
public class ModulolibroService implements ModuloLibroInterface {

	@Autowired
	private ModuloLibroDao moduloLibroRepo;

	@Override
	public ModuloLibro save(ModuloLibro modulolibro) {
		
		if(ValidarModuloLibro(modulolibro)) {
			return moduloLibroRepo.save(modulolibro);
		}else {
			return null;
		}
		
	}

	@Override
	public List<ModuloLibro> listAllModuloLibro() {
		// TODO Auto-generated method stub
		return (List<ModuloLibro>) moduloLibroRepo.findAll();
	}

	@Override
	public Optional<ModuloLibro> getById(Long moduloLibroId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModuloLibro update(Long moduloLibroId, double nuevoModuloLibro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long moduloLibroId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	  public boolean ValidarModuloLibro(ModuloLibro moduloLibro){
			//String id_modulo_libro= ""+moduloLibro.;
		    int codModulo= moduloLibro.getCodModulo();
		    String nombreModulo=moduloLibro.getNombreModulo();
		    String curso=moduloLibro.getCurso();
		    int cantidad=moduloLibro.getCantidad();
		    int numero=moduloLibro.getNumero();
		    String numeroModulo=moduloLibro.getNumeroModulo();
		    if(codModulo>0 
		       && nombreModulo != null
		       && curso != null
		       && cantidad>0
		       && numero > 0
		       && numeroModulo != null) {
		    	return true;
		    }else {
		    	return false;
		    }
			
		}

	
	
	
}

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
public class ImodulolibroService implements ModuloLibroInterface {

	

	@Autowired
	private ModuloLibroDao moduloLibroRepo;

	@Override
	public ModuloLibro save(ModuloLibro modulolibro) {
		return moduloLibroRepo.save(modulolibro);
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

}

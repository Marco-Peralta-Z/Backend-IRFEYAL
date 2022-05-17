package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.RecepcionArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.RecepcionArticuloDao;
import com.irfeyal.modelo.inventarios.RecepcionArticulo;

@Service // ("IAutoServiceImplement")
@Transactional
public class RecepcionArtiService implements RecepcionArticuloInterface{

	@Autowired
	RecepcionArticuloDao recepcionArticuloDao;
	
	@Override
	public RecepcionArticulo save(RecepcionArticulo recepcionArticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecepcionArticulo> listAllRecepcionArticulo() {
		// TODO Auto-generated method stub
		return (List<RecepcionArticulo>) recepcionArticuloDao.findAll();
	}

	@Override
	public Optional<RecepcionArticulo> getById(Long id_RecepcionArticulo) {
		// TODO Auto-generated method stub
		return recepcionArticuloDao.findById(id_RecepcionArticulo);
	}

	@Override
	public RecepcionArticulo update(Long id_RecepcionArticulo, double nuevoRecepcionArticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_RecepcionArticulo) {
		// TODO Auto-generated method stub
		return false;
	}

}

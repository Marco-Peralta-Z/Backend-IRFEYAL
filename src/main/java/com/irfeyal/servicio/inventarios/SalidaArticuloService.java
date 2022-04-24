package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.SalidaArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.SalidaArticuloDao;
import com.irfeyal.modelo.inventarios.Salidaarticulo;

@Service // ("IAutoServiceImplement")
@Transactional
public class SalidaArticuloService implements SalidaArticuloInterface {

	@Autowired
	SalidaArticuloDao salidaArticuloDao;
	
	@Override
	public Salidaarticulo save(Salidaarticulo salidaarticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salidaarticulo> listAllSalidaarticulo() {
		// TODO Auto-generated method stub
		return (List<Salidaarticulo>) salidaArticuloDao.findAll();
	}

	@Override
	public Optional<Salidaarticulo> getById(Long id_Salidaarticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salidaarticulo update(Long id_Salidaarticulo, double nuevoSalidaarticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_Salidaarticulo) {
		// TODO Auto-generated method stub
		return false;
	}

}

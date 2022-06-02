package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.DetalleBajaArticInterface;
import com.irfeyal.interfaces.inventarios.ControlArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.ControlArticuloDao;
import com.irfeyal.modelo.inventarios.ControlArticulo;


@Service // ("IAutoServiceImplement")
@Transactional
public class ControlArticuloService implements ControlArticuloInterface{

	@Autowired
	ControlArticuloDao detallIngreArtiDao;
	
	@Override
	public ControlArticulo save(ControlArticulo detalIngreArti) {
		// TODO Auto-generated method stub
		return detallIngreArtiDao.save(detalIngreArti);
	}

	@Override
	public List<ControlArticulo> listAllDetalIngreArti() {
		// TODO Auto-generated method stub
		return (List<ControlArticulo>) detallIngreArtiDao.findAll();
	}

	@Override
	public Optional<ControlArticulo> getById(Long id_detalIngreArti) {
		// TODO Auto-generated method stub
		return detallIngreArtiDao.findById(id_detalIngreArti);
	}

	@Override
	public ControlArticulo update(Long id_detalIngreArti, double nuevaDetalIngreArti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_DetalIngreArti) {
		// TODO Auto-generated method stub
		return false;
	}

}

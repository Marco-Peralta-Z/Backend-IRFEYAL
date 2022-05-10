package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.DetalleBajaArticInterface;
import com.irfeyal.interfaces.inventarios.DetallingreArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.DetallIngreArtiDao;
import com.irfeyal.modelo.inventarios.DetalIngreArti;


@Service // ("IAutoServiceImplement")
@Transactional
public class DetalleIngreArtiService implements DetallingreArticuloInterface{

	@Autowired
	DetallIngreArtiDao detallIngreArtiDao;
	
	@Override
	public DetalIngreArti save(DetalIngreArti detalIngreArti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalIngreArti> listAllDetalIngreArti() {
		// TODO Auto-generated method stub
		return (List<DetalIngreArti>) detallIngreArtiDao.findAll();
	}

	@Override
	public Optional<DetalIngreArti> getById(Long id_detalIngreArti) {
		// TODO Auto-generated method stub
		return detallIngreArtiDao.findById(id_detalIngreArti);
	}

	@Override
	public DetalIngreArti update(Long id_detalIngreArti, double nuevaDetalIngreArti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_DetalIngreArti) {
		// TODO Auto-generated method stub
		return false;
	}

}

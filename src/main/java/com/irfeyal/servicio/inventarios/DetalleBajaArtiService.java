package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.controlador.inventarios.DetallBajaArtiControlador;
import com.irfeyal.interfaces.inventarios.DetalleBajaArticInterface;
import com.irfeyal.modelo.dao.inventarios.DetallBajaArtiDao;
import com.irfeyal.modelo.inventarios.DetallebajaArti;


@Service // ("IAutoServiceImplement")
@Transactional
public class DetalleBajaArtiService implements DetalleBajaArticInterface {

	@Autowired
	DetallBajaArtiDao detallBajaArtiDao;
	
	@Override
	public DetallebajaArti save(DetallebajaArti detallebajaArti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallebajaArti> listAllDetallebajaArti() {
		// TODO Auto-generated method stub
		return (List<DetallebajaArti>) detallBajaArtiDao.findAll();
	}

	@Override
	public Optional<DetallebajaArti> getById(Long id_detallebajaArti) {
		// TODO Auto-generated method stub
		return detallBajaArtiDao.findById(id_detallebajaArti);
	}

	@Override
	public DetallebajaArti update(Long id_detallebajaArti, double nuevaDetallebajaArti) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_DetallebajaArti) {
		// TODO Auto-generated method stub
		return false;
	}

}

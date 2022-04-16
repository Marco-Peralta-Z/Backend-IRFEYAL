package com.irfeyal.servicio.inventarios;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.AprobacionInterface;
import com.irfeyal.modelo.dao.inventarios.AprobacionDao;
import com.irfeyal.modelo.inventarios.Aprobacion;

@Service // ("IAutoServiceImplement")
@Transactional
public class AprobacionService implements AprobacionInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private AprobacionDao aprobacionDao;

	@Override
	public Aprobacion save(Aprobacion aprobacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aprobacion> listAllAprobacion() {
		// TODO Auto-generated method stub
		return (List<Aprobacion>) aprobacionDao.findAll();
	}

	@Override
	public Optional<Aprobacion> getById(Long aprobacionId) {
		
		return null;
	}

	@Override
	public Aprobacion update(Long aprobacionId, double nuevaAprobacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long aprobacionId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//-----------------------MIS METODOS -------------------------------------
	public Object getDetalleAprobacion(Integer id){
		Object detalleAprobacion = aprobacionDao.detalleApro(id);
		return detalleAprobacion;
	}

}

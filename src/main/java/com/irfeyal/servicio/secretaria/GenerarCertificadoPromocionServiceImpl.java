package com.irfeyal.servicio.secretaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.irfeyal.interfaces.secretaria.IGenerarCertificadoPromocionService;
import com.irfeyal.modelo.dao.secretaria.IGenerarCertificadoPromocionDao;
import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;
import com.irfeyal.modelo.secretaria.GenerarCertificadoPromocion;

@Service
public class GenerarCertificadoPromocionServiceImpl implements IGenerarCertificadoPromocionService{

	@Autowired
	private IGenerarCertificadoPromocionDao generarCertificadoPromocionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<GenerarCertificadoPromocion> findAll() {
		
		return (List<GenerarCertificadoPromocion>) generarCertificadoPromocionDao.findAll();
	}

	@Override
	public Page<GenerarCertificadoPromocion> findAll(Pageable pageable) {
		
		return generarCertificadoPromocionDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public GenerarCertificadoPromocion findById(Long id) {
		
		return generarCertificadoPromocionDao.findById(id).orElse(null);
	}

	@Override
	public GenerarCertificadoPromocion save(GenerarCertificadoPromocion generarCertificadoPromocion) {
		
		return generarCertificadoPromocionDao.save(generarCertificadoPromocion);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		generarCertificadoPromocionDao.deleteById(id);
	}

	@Override
	public List<GenerarCertificadoPromocion> findByCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		return generarCertificadoPromocionDao.findByCedulaEstudiante(cedula);
	}
	
	

}

package com.irfeyal.servicio.secretaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.secretaria.IGenerarCertificadoMatriculaService;
import com.irfeyal.modelo.dao.secretaria.IGenerarCertificadoMatriculaDao;
import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;

@Service
public class GenerarCertificadoMatriculaServiceImpl implements IGenerarCertificadoMatriculaService{

	@Autowired
	private IGenerarCertificadoMatriculaDao generarCertificadoMatriculaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<GenerarCertificadoMatricula> findAll() {
		
		return (List<GenerarCertificadoMatricula>) generarCertificadoMatriculaDao.findAll();
	}

	@Override
	public Page<GenerarCertificadoMatricula> findAll(Pageable pageable) {
		
		return generarCertificadoMatriculaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public GenerarCertificadoMatricula findById(Long id) {
		
		return generarCertificadoMatriculaDao.findById(id).orElse(null);
	}

	@Override
	public GenerarCertificadoMatricula save(GenerarCertificadoMatricula generarCertificadoMatricula) {
		
		return generarCertificadoMatriculaDao.save(generarCertificadoMatricula);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		generarCertificadoMatriculaDao.deleteById(id);
		
	}

}

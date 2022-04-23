package com.irfeyal.interfaces.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;

public interface IGenerarCertificadoMatriculaService {
	
	public List<GenerarCertificadoMatricula> findAll();
	
	public Page<GenerarCertificadoMatricula> findAll(Pageable pageable);
	
	public GenerarCertificadoMatricula findById(Long id);
	
	public GenerarCertificadoMatricula save(GenerarCertificadoMatricula generarCertificadoMatricula);
	
	public void delete(Long id);
}

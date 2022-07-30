package com.irfeyal.interfaces.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.secretaria.GenerarCertificadoPromocion;

public interface IGenerarCertificadoPromocionService {

	public List<GenerarCertificadoPromocion> findAll();
	
	public Page<GenerarCertificadoPromocion> findAll(Pageable pageable);
	
	public GenerarCertificadoPromocion findById(Long id);
	
	public GenerarCertificadoPromocion save(GenerarCertificadoPromocion generarCertificadoPromocion);
	
	public void delete(Long id);

	public List<GenerarCertificadoPromocion> findByCedulaEstudiante(String cedula);
	
	public List<String> cargarnotasgeneral(Long periodo, Long modalidad, Long curso, Long paralelo);
}

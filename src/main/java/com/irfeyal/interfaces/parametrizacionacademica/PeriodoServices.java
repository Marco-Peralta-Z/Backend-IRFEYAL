package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeriodoServices {

	public List<Periodo> getAllPeriodo();

	public Page<Periodo> getAllPeriodo(Pageable pageable);

	public Optional<Periodo> getPeriodoById(Long idPeriodo);

	public Periodo savePeriodo(Periodo periodo);

	public Periodo deletePeriodo(Long idPeriodo);
	
	public List<Periodo> findByMalla(Long id_malla);

}

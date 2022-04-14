package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModalidadServices {

	public List<Modalidad> getAllModalidad();

	public Page<Modalidad> getAllModalidad(Pageable pageable);

	public Optional<Modalidad> getModalidadById(Long idModalidad);

	public Modalidad saveModalidad(Modalidad modalidad);

	public Modalidad deleteModalidad(Long idModalidad);

}

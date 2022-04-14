package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.ModalidadServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

@Service
public class ModalidadServicesImp implements ModalidadServices {

	@Autowired
	private ModalidadRepository modalidadRepo;

	@Override
	public List<Modalidad> getAllModalidad() {
		return modalidadRepo.findAll();
	}

	@Override
	public Page<Modalidad> getAllModalidad(Pageable pageable) {
		return modalidadRepo.findAll(pageable);
	}

	@Override
	public Optional<Modalidad> getModalidadById(Long idModalidad) {
		return modalidadRepo.findById(idModalidad);
	}

	@Override
	public Modalidad saveModalidad(Modalidad Modalidad) {
		return modalidadRepo.save(Modalidad);
	}

	@Override
	public Modalidad deleteModalidad(Long idModalidad) {
		try {
			Modalidad modalidadRecu = modalidadRepo.findById(idModalidad).get();
			modalidadRepo.delete(modalidadRecu);
			return modalidadRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}

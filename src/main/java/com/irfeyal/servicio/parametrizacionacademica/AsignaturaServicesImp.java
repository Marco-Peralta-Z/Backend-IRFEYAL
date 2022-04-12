package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;

import com.irfeyal.interfaces.parametrizacionacademica.AsignaturaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsignaturaServicesImp implements AsignaturaServices {

	@Autowired
	private AsignaturaRepository asignaturaRepo;

	@Override
	public List<Asignatura> getAllAsignatura() {
		return asignaturaRepo.findAll();
	}

	@Override
	public Page<Asignatura> getAllAsignatura(Pageable pageable) {
		return asignaturaRepo.findAll(pageable);
	}

	@Override
	public Asignatura getAsignaturaById(Long idAsignatura) {
		return asignaturaRepo.getById(idAsignatura);
	}

	@Override
	public Asignatura saveAsignatura(Asignatura asignatura) {
		return asignaturaRepo.save(asignatura);
	}

	@Override
	public Asignatura deleteAsignatura(Long idAsignatura) {
		try {
			Asignatura asignaturaRecu = asignaturaRepo.findById(idAsignatura).get();
			asignaturaRepo.delete(asignaturaRecu);
			return asignaturaRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}

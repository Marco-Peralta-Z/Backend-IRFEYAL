package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.AsignaturaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

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
	public Optional<Asignatura> getAsignaturaById(Long idAsignatura) {
		return asignaturaRepo.findById(idAsignatura);
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
	
	
	/*MODULO TUTORIAS*/
		@Override
		public List<Asignatura> listarIdsAsignaturas(Long id_periodo) {
			return asignaturaRepo.ids_asignatura(id_periodo);
		}
		
	/*------------*/	

}

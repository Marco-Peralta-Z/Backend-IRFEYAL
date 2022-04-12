package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.AsignaturaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServicesImp implements AsignaturaServices{

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
		Asignatura asignatura = asignaturaRepo.getById(idAsignatura);
		if (asignatura != null) {
			return asignatura;
		}
		return null;
	}
    
}

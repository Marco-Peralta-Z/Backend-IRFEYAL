package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.MallaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Malla;

@Service
public class MallaServicesImp implements MallaServices {

	@Autowired
	private MallaRepository mallaRepo;

	@Override
	public List<Malla> getAllMalla() {
		return mallaRepo.findAll();
	}

	@Override
	public Page<Malla> getAllMalla(Pageable pageable) {
		return mallaRepo.findAll(pageable);
	}

	@Override
	public Optional<Malla> getMallaById(Long idMalla) {
		return mallaRepo.findById(idMalla);
	}

	@Override
	public Malla saveMalla(Malla Malla) {
		return mallaRepo.save(Malla);
	}

	@Override
	public Malla deleteMalla(Long idMalla) {
		try {
			Malla mallaRecu = mallaRepo.findById(idMalla).get();
			mallaRepo.delete(mallaRecu);
			return mallaRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}

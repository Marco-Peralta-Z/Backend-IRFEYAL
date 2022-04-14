package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.HorarioServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.HorarioRepository;
import com.irfeyal.modelo.parametrizacionacademica.Horario;

@Service
public class HorarioServicesImp implements HorarioServices {

	@Autowired
	private HorarioRepository horarioRepo;

	@Override
	public List<Horario> getAllHorario() {
		return horarioRepo.findAll();
	}

	@Override
	public Page<Horario> getAllHorario(Pageable pageable) {
		return horarioRepo.findAll(pageable);
	}

	@Override
	public Optional<Horario> getHorarioById(Long idHorario) {
		return horarioRepo.findById(idHorario);
	}

	@Override
	public Horario saveHorario(Horario horario) {
		return horarioRepo.save(horario);
	}

	@Override
	public Horario deleteHorario(Long idHorario) {
		try {
			Horario horarioRecu = horarioRepo.findById(idHorario).get();
			horarioRepo.delete(horarioRecu);
			return horarioRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}

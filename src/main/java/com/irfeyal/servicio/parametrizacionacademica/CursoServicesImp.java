package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.CursoServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.parametrizacionacademica.Curso;

@Service
public class CursoServicesImp implements CursoServices {

	@Autowired
	private CursoRepository cursoRepo;

	@Override
	public List<Curso> getAllCurso() {
		return cursoRepo.findAll();
	}

	@Override
	public Page<Curso> getAllCurso(Pageable pageable) {
		return cursoRepo.findAll(pageable);
	}

	@Override
	public Optional<Curso> getCursoById(Long idCurso) {
		return cursoRepo.findById(idCurso);
	}

	@Override
	public Curso saveCurso(Curso curso) {
		return cursoRepo.save(curso);
	}

	@Override
	public Curso deleteCurso(Long idCurso) {
		try {
			Curso cursoRecu = cursoRepo.findById(idCurso).get();
			cursoRepo.delete(cursoRecu);
			return cursoRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}

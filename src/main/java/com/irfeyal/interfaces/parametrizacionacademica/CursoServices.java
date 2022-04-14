package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoServices {

	public List<Curso> getAllCurso();

	public Page<Curso> getAllCurso(Pageable pageable);

	public Optional<Curso> getCursoById(Long idCurso);

	public Curso saveCurso(Curso curso);

	public Curso deleteCurso(Long idCurso);

}

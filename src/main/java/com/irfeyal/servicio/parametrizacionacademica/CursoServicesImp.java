package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.CursoServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.parametrizacionacademica.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Curso getCursoById(Long idCurso) {
        return cursoRepo.getById(idCurso);
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    @Override
    public Curso deleteCurso(Long idCurso) {
        Curso curso = cursoRepo.getById(idCurso);
        if (curso != null) {
            return curso;
        }
        return null;
    }

}

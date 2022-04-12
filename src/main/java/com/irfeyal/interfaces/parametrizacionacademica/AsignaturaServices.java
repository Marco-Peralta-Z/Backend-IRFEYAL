package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AsignaturaServices {

    public List<Asignatura> getAllAsignatura();

    public Page<Asignatura> getAllAsignatura(Pageable pageable);

    public Asignatura getAsignaturaById(Long idAsignatura);

    public Asignatura saveAsignatura(Asignatura asignatura);

    public Asignatura deleteAsignatura(Long idAsignatura);

}
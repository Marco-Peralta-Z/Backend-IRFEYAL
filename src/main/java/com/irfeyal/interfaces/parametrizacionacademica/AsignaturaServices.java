package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

public interface AsignaturaServices {

    public List<Asignatura> getAllAsignatura();

    public Page<Asignatura> getAllAsignatura(Pageable pageable);

    public Optional<Asignatura> getAsignaturaById(Long idAsignatura);

    public Asignatura saveAsignatura(Asignatura asignatura);

    public Asignatura deleteAsignatura(Long idAsignatura);

}

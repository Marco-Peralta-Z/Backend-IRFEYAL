package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Malla;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MallaServices {

    public List<Malla> getAllMalla();

    public Page<Malla> getAllMalla(Pageable pageable);

    public Optional<Malla> getMallaById(Long idMalla);

    public Malla saveMalla(Malla malla);

    public Malla deleteMalla(Long idMalla);

}

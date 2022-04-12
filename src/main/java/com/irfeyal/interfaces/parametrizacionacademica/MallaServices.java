package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Malla;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MallaServices {

    public List<Malla> getAllMalla();

    public Page<Malla> getAllMalla(Pageable pageable);

    public Malla getMallaById(Long idMalla);

    public Malla saveMalla(Malla malla);

    public Malla deleteMalla(Long idMalla);

}

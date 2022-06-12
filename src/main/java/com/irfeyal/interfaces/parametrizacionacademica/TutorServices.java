package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.parametrizacionacademica.Tutor;

public interface TutorServices {

    public List<Tutor> getAllTutor();

    public Page<Tutor> getAllTutor(Pageable  pageable);

    public Optional<Tutor> getTutorById(Long idTutor);

    public Tutor saveTutor(Tutor tutor);

    public Tutor deleteTutor(Long idTutor);
    
}

package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.TutorServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.TutorRepository;
import com.irfeyal.modelo.parametrizacionacademica.Tutor;

@Service
public class TutorServicesImp implements TutorServices {

    @Autowired
    private TutorRepository tutorRepo;

    @Override
    public List<Tutor> getAllTutor() {
        return tutorRepo.findAll();
    }

    @Override
    public Page<Tutor> getAllTutor(Pageable pageable) {
        return tutorRepo.findAll(pageable);
    }

    @Override
    public Optional<Tutor> getTutorById(Long idTutor) {
        return tutorRepo.findById(idTutor);
    }

    @Override
    public Tutor saveTutor(Tutor tutor) {
        return tutorRepo.save(tutor);
    }

    @Override
    public Tutor deleteTutor(Long idTutor) {
        try {
            Tutor tutorRecu = tutorRepo.findById(idTutor).get();
            tutorRepo.delete(tutorRecu);
            return tutorRecu;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}

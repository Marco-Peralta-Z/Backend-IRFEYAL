package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.MallaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Malla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MallaServicesImp implements MallaServices {

    @Autowired
    private MallaRepository mallaRepo;

    @Override
    public List<Malla> getAllMalla() {
        return mallaRepo.findAll();
    }

    @Override
    public Page<Malla> getAllMalla(Pageable pageable) {
        return mallaRepo.findAll(pageable);
    }

    @Override
    public Malla getMallaById(Long idMalla) {
        return mallaRepo.getById(idMalla);
    }

    @Override
    public Malla saveMalla(Malla Malla) {
        return mallaRepo.save(Malla);
    }

    @Override
    public Malla deleteMalla(Long idMalla) {
        Malla malla = mallaRepo.getById(idMalla);
        if (malla != null) {
            return malla;
        }
        return null;
    }

}

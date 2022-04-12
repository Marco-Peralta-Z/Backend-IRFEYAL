package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.ModalidadServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ModalidadServicesImp implements ModalidadServices {

    @Autowired
    private ModalidadRepository modalidadRepo;

    @Override
    public List<Modalidad> getAllModalidad() {
        return modalidadRepo.findAll();
    }

    @Override
    public Page<Modalidad> getAllModalidad(Pageable pageable) {
        return modalidadRepo.findAll(pageable);
    }

    @Override
    public Modalidad getModalidadById(Long idModalidad) {
        return modalidadRepo.getById(idModalidad);
    }

    @Override
    public Modalidad saveModalidad(Modalidad Modalidad) {
        return modalidadRepo.save(Modalidad);
    }

    @Override
    public Modalidad deleteModalidad(Long idModalidad) {
        Modalidad modalidad = modalidadRepo.getById(idModalidad);
        if (modalidad != null) {
            return modalidad;
        }
        return null;
    }
}

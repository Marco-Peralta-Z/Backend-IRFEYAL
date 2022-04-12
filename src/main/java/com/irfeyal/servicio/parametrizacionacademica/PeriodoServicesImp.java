package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.PeriodoServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeriodoServicesImp implements PeriodoServices {

    @Autowired
    private PeriodoRepository periodoRepo;

    @Override
    public List<Periodo> getAllPeriodo() {
        return periodoRepo.findAll();
    }

    @Override
    public Page<Periodo> getAllPeriodo(Pageable pageable) {
        return periodoRepo.findAll(pageable);
    }

    @Override
    public Periodo getPeriodoById(Long idPeriodo) {
        return periodoRepo.getById(idPeriodo);
    }

    @Override
    public Periodo savePeriodo(Periodo Periodo) {
        return periodoRepo.save(Periodo);
    }

    @Override
    public Periodo deletePeriodo(Long idPeriodo) {
        Periodo periodo = periodoRepo.getById(idPeriodo);
        if (periodo != null) {
            return periodo;
        }
        return null;
    }
}

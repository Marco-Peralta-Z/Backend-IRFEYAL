package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;

import com.irfeyal.interfaces.parametrizacionacademica.HorarioServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.HorarioRepository;
import com.irfeyal.modelo.parametrizacionacademica.Horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HorarioServicesImp implements HorarioServices {

    @Autowired
    private HorarioRepository horarioRepo;

    @Override
    public List<Horario> getAllHorario() {
        return horarioRepo.findAll();
    }

    @Override
    public Page<Horario> getAllHorario(Pageable pageable) {
        return horarioRepo.findAll(pageable);
    }

    @Override
    public Horario getHorarioById(Long idHorario) {
        return horarioRepo.getById(idHorario);
    }

    @Override
    public Horario saveHorario(Horario horario) {
        return horarioRepo.save(horario);
    }

    @Override
    public Horario deleteHorario(Long idHorario) {
        Horario horario = horarioRepo.getById(idHorario);
        if (horario != null) {
            return horario;
        }
        return null;
    }

}

package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.AreaServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.AreaRepository;
import com.irfeyal.modelo.parametrizacionacademica.Area;

@Service
public class AreaServicesImp implements AreaServices {

    @Autowired
    private AreaRepository areaRepo;

    @Override
    public List<Area> getAllArea() {
        return areaRepo.findAll();
    }

    @Override
    public Page<Area> getAllArea(Pageable pageable) {
        return areaRepo.findAll(pageable);
    }

    @Override
    public Optional<Area> getAreaById(Long idArea) {
        return areaRepo.findById(idArea);
    }

    @Override
    public Area saveArea(Area area) {
        return areaRepo.save(area);
    }

    @Override
    public Area deleteArea(Long idArea) {
        try {
            Area areaRecu = areaRepo.findById(idArea).get();
            areaRepo.delete(areaRecu);
            return areaRecu;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}

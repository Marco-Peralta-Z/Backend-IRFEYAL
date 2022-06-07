package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.parametrizacionacademica.Area;

public interface AreaServices {

    public List<Area> getAllArea();

    public Page<Area> getAllArea(Pageable  pageable);

    public Optional<Area> getAreaById(Long idArea);

    public Area saveArea(Area area);

    public Area deleteArea(Long idArea);
    
}

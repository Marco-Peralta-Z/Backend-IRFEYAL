package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

}

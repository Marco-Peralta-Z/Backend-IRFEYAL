package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

}

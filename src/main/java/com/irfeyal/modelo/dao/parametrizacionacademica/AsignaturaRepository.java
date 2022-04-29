package com.irfeyal.modelo.dao.parametrizacionacademica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	
}

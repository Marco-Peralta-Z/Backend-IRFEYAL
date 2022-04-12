package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Horario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}

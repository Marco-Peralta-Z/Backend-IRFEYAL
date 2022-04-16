package com.irfeyal.modelo.dao.asistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.asistencia.Asistencia;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long>{

}

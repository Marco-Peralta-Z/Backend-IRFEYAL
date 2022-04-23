package com.irfeyal.modelo.dao.secretaria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;

public interface IGenerarCertificadoMatriculaDao extends CrudRepository<GenerarCertificadoMatricula, Long>{

	Page<GenerarCertificadoMatricula> findAll(Pageable pageable);
}

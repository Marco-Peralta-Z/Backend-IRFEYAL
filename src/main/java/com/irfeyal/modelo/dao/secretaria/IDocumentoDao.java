package com.irfeyal.modelo.dao.secretaria;

import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.Documento;

public interface IDocumentoDao extends CrudRepository<Documento,Long> {
	
}

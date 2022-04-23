package com.irfeyal.servicio.documentosacademicos;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.documentosacademicos.UnidadInterface;
import com.irfeyal.modelo.dao.documentosacademicos.UnidadDAO;
import com.irfeyal.modelo.documentosacademicos.Unidad;

@Service
public class UnidadService implements UnidadInterface{
	@Autowired
	private UnidadDAO unidadDAO;

	//Listar Unidades
	@Override
	public List<Unidad> findAll() {
		return unidadDAO.findAll();
	}

}

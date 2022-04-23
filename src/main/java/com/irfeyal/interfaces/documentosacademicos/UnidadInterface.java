package com.irfeyal.interfaces.documentosacademicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.irfeyal.modelo.documentosacademicos.Unidad;

@Service
public interface UnidadInterface {
	public List<Unidad> findAll();
}

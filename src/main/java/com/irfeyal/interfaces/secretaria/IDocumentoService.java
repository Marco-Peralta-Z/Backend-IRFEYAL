package com.irfeyal.interfaces.secretaria;

import java.util.List;

import com.irfeyal.modelo.secretaria.Documento;

public interface IDocumentoService {

    public List<Documento> findAll();
	
    public Documento save(Documento documento);
	
	public Documento findById(Long id);
	
	public void delete(Long id);
	
}

package com.irfeyal.interfaces.tutorias;

import java.util.ArrayList;

import com.irfeyal.modelo.tutorias.Registro;

public interface IRegistroService {

	
	Registro save(Registro registro);
	
	ArrayList<Registro> findAll();

	
	void delete(Long id_registro);

	
	Registro findById(Long id_registro);

	




}

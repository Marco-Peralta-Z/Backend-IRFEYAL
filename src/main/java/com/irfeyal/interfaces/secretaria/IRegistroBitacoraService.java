package com.irfeyal.interfaces.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.secretaria.RegistroBitacora;

public interface IRegistroBitacoraService {

	public List<RegistroBitacora> findAll();
	
	public Page<RegistroBitacora> findAll(Pageable pageable);
	
	public RegistroBitacora findById(Long id);
	
	public RegistroBitacora save(RegistroBitacora registroBitacora);
	
	public void delete (Long id);
	
}

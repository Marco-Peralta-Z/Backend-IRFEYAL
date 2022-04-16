package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.CorreoElectronico;





public interface CorreoElectronicoInterface {


public List<CorreoElectronico> findAll();
	
	public Page<CorreoElectronico> findAll(Pageable pageable);
	
	public CorreoElectronico findById(Long id);
	
	public CorreoElectronico saveCorreo(CorreoElectronico correoelectronico);
	
	public void deleteCorreo (Long id);
}

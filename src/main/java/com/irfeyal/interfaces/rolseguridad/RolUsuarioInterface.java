package com.irfeyal.interfaces.rolseguridad;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.RolUsuario;

public interface RolUsuarioInterface {


public List<RolUsuario> findAll();
	
	public Page<RolUsuario> findAll(Pageable pageable);
	
	public RolUsuario findById(Long id);
	
	public RolUsuario saveRolUsuario(RolUsuario rolusuario);
	
	public void deleteRolUsuario (Long id);
}

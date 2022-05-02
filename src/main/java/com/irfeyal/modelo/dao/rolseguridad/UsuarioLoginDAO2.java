package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.UsuarioLogin;


public interface UsuarioLoginDAO2 extends CrudRepository<UsuarioLogin, Long>{
	Page<UsuarioLogin> findAll(Pageable pageable);

	
	@Query (value="select usuario.id_usuario,usuario.usuario,usuario.contrasenia,usuario.est_usuario, rol_usuario.id_rol_usuario,rol_usuario.id_rol, rol.descripcion  ,  modulo.id_modulo,"
			+ "modulo.modulo "
			+ "from rol_usuario inner join usuario on usuario.id_usuario=rol_usuario.id_usuario "
			+ "inner join modulo on rol_usuario.id_modulo= modulo.id_modulo "
			+ "inner join rol on rol_usuario.id_rol=rol.id_rol WHERE usuario.usuario=?1 AND usuario.contrasenia=?2", nativeQuery = true) 
	 UsuarioLogin loginUser (String usuario, String contrasenia);
	
}

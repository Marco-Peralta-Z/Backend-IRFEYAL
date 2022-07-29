package com.irfeyal.modelo.dao.rolseguridad;
import java.util.List;
import org.springframework.data.domain.Page;
import com.irfeyal.modelo.rolseguridad.RolUsuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RolUsuarioDAO extends CrudRepository<RolUsuario, Long> {
	Page<RolUsuario> findAll(Pageable pageable);
	
	@Query(value = "SELECT  r.descripcion FROM rol_usuario ru join rol r  on ru.id_rol = r.id_rol  where id_usuario =?1",nativeQuery=true)
	public List<String> validacionadmin(Long usuario);
	

}

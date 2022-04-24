package com.irfeyal.modelo.dao.inventarios;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Repository
public interface AprobacionDao extends CrudRepository<Aprobacion, Long> {

	@Query(value = "SELECT a FROM Aprobacion a where a.id_aprobacion = :id_aprobacion")
	public Aprobacion detalleAprobacion(@Param("id_aprobacion") Integer id_aprobacion);

	@Query(value = "select apr.observacion_aproba, apr.detalle_control, apr.fecha_aprobacion, r.descripcion, (p.nombre || ' ' ||p.apellido) as administrador,\r\n"
			+ "k.precio_kit,k.periodo,ml.nombre_modulo, ml.cantidad,ml.numero_modulo,ml.cod_modulo,\r\n"
			+ "(select ps.nombre||' '||ps.apellido as ingresadopor from  persona ps \r\n"
			+ "inner join usuario us ON us.id_persona = ps.id_persona \r\n"
			+ "inner join rol_usuario rus on rus.id_usuario = us.id_usuario \r\n"
			+ "inner join rol rs on rs.id_rol = rus.id_rol \r\n" + "where rus.id_rolusuario = ik.id_secretaria)\r\n"
			+ "from aprobacion apr\r\n" + "inner join rol_usuario ru on ru.id_rolusuario = apr.id_rolu_admin \r\n"
			+ "inner join usuario u on u.id_usuario = ru.id_usuario  \r\n"
			+ "inner join rol r on r.id_rol = ru.id_rol \r\n"
			+ "inner join persona p on p.id_persona = u.id_persona \r\n"
			+ "inner join ingreso_kit ik on ik.ingrekit_id = apr.aprobacion_id \r\n"
			+ "inner join kit k on k.kit_id = ik.ingrekit_id \r\n"
			+ "inner join modulo_libro ml on ml.kit_id  = ik.ingrekit_id \r\n"
			+ "where apr.id_aprobacion = ?", nativeQuery = true

	)
	public Object detalleApro(@Param("id_aprobacion") Integer id_aprobacion);

	@Query(value = "select * from empleado e where e.id_empleado = ?;", nativeQuery = true)
	public Empleado obtenerEmpleado(@Param("id_empleado") Integer id_empleado);
	

}

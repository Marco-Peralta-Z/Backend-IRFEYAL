package com.irfeyal.modelo.dao.pagos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import com.irfeyal.modelo.pagos.Comprobante;

public interface IComprobanteDao extends CrudRepository<Comprobante, Long>{
	
	Page<Comprobante> findAll(Pageable pageable);
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "select pe.cedula, pe.nombre, pe.apellido,co.id_comprobante, co.estado, co.fecha, co.imagen, co.valor_total, co.id_empleado, co.id_matricula, co.id_tipo_comprobante, co.id_tipo_pago "
			+ " from Comprobante co " 
			+ " inner join matriculas m on m.id_matricula = co.id_matricula "
			+ "	inner join estudiantes e on e.id_estudiante = m.id_estudiante "
			+ "	inner join persona pe on pe.id_persona = e.id_persona"
			+ " WHERE pe.cedula =?1",nativeQuery=true)
	Comprobante buscarcedulaestudiante(String cedula);
}

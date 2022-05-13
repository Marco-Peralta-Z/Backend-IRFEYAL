package com.irfeyal.modelo.dao.pagos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.pagos.Comprobante;

public interface IComprobanteDao extends CrudRepository<Comprobante, Long>{
	
	Page<Comprobante> findAll(Pageable pageable);
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "select  pers.cedula ,CONCAT(pers.nombre,pers.apellido) ,com.id_comprobante, com.estado, com.fecha, com.imagen, com.valor_total, com.id_empleado, com.id_matricula, com.id_tipo_comprobante, com.id_tipo_pago from comprobante com "
			+ "inner join matriculas ma on ma.id_matricula = com.id_matricula "
			+ "inner join estudiantes e on e.id_estudiante = ma.id_estudiante "
			+ "inner join persona pers on pers.id_persona = e.id_persona "
			+ "where pers.cedula = ?'0102184322'", nativeQuery = true)
	List<Comprobante> Buscardeudas(String cedula);
}

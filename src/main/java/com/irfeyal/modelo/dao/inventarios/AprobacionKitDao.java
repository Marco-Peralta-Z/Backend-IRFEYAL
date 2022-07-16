package com.irfeyal.modelo.dao.inventarios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.AprobacionKit;

@Repository
public interface AprobacionKitDao extends CrudRepository<AprobacionKit, Long> {

	
	@Query(nativeQuery = true, value = "select  e.id_estudiante, tc.concepto_pago, ki.id_kit, sum(c.valor_total) as total_pagado, apro.estado_aproba   from  matriculas ma\r\n"
			+ "left join kit ki on ki.id_curso = ma.id_curso\r\n"
			+ "left join estudiantes e on e.id_estudiante = ma.id_estudiante\r\n"
			+ "left join comprobante c on c.id_matricula = ma.id_matricula\r\n"
			+ "left join tipo_comprobante tc on tc.id_tipo_comprobante  = c.id_tipo_comprobante\r\n"
			+ "left join aprobacionkit apro on apro.id_estudiante = e.id_estudiante\r\n"
			+ "where tc.concepto_pago = 'Kit' group by 1,2,3,5")
	public List<Object> estudiantesPagado();

	
}

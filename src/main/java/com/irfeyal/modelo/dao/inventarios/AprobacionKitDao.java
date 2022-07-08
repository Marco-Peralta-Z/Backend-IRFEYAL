package com.irfeyal.modelo.dao.inventarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.EstudiantePagoKit;
import com.irfeyal.modelo.inventarios.TempPagoKit;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.matricula.Matricula;



@Repository
public interface AprobacionKitDao extends CrudRepository<AprobacionKit, Long> {

	
	@Query(nativeQuery = true, value = "select  e.id_estudiante, tc.concepto_pago, ki.id_kit,  sum(c.valor_total) as total_pagado  from  matriculas ma \n"
			+ "left join kit ki on ki.id_curso = ma.id_curso\n"
			+ "left join estudiantes e on e.id_estudiante = ma.id_estudiante \n"
			+ "left join comprobante c on c.id_matricula = ma.id_matricula\n"
			+ "left join tipo_comprobante tc on tc.id_tipo_comprobante  = c.id_tipo_comprobante\n"
			+ "where tc.concepto_pago = 'Kit' group by 1,2,3")
	public List<Object> estudiantesPagado();

	
}

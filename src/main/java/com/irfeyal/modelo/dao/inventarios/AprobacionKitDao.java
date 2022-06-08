package com.irfeyal.modelo.dao.inventarios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.TempPagoKit;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.matricula.Matricula;



@Repository
public interface AprobacionKitDao extends CrudRepository<AprobacionKit, Long> {

	
	@Query(nativeQuery = true, value = "select e.id_estudiante, c.valor_total from comprobante c \r\n"
			+ "inner join tipo_pago tp on tp.id_tipo_pago = c.id_tipo_pago\r\n"
			+ "inner join tipo_comprobante tc on tc.id_tipo_comprobante = c.id_tipo_comprobante \r\n"
			+ "inner join kit k on k.id_kit = tc.id_kit \r\n"
			+ "inner join matriculas m on m.id_matricula = c.id_matricula \r\n"
			+ "inner join estudiantes e on e.id_estudiante = m.id_estudiante \r\n"
			+ "inner join persona p on p.id_persona = e.id_persona \r\n")
	public List<Object> estudiantesPagado();

	
}

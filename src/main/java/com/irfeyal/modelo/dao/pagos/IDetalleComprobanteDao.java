package com.irfeyal.modelo.dao.pagos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.pagos.DetalleComprobante;

public interface IDetalleComprobanteDao extends CrudRepository<DetalleComprobante, Long>{
	
	Page<DetalleComprobante> findAll(Pageable pageable);
	
	@Query(value="select d from DetalleComprobante d where d.id_comprobante.id_matricula.estudiante.id_persona.cedula like %?1%")
	public List<DetalleComprobante> findByCedulaEstudiante(String cedula);
	
	
}

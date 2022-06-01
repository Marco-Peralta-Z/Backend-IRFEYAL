package com.irfeyal.servicio.inventarios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.AprobacionKitInterface;
import com.irfeyal.modelo.dao.inventarios.AprobacionKitDao;
import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Service // ("IAutoServiceImplement")
@Transactional
public class AprobacionKitService implements AprobacionKitInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private AprobacionKitDao aprobacionDao;
		
	
	@Override
	public AprobacionKit save(AprobacionKit aprobacion) {

		AprobacionKit a = aprobacionDao.save(aprobacion);
		
		return a;
	}

	@Override
	public List<AprobacionKit> listAllAprobacion() {
		// TODO Auto-generated method stub
		return (List<AprobacionKit>) aprobacionDao.findAll();
	}

	@Override
	public Optional<AprobacionKit> getById(Long aprobacionId) {

		return aprobacionDao.findById(aprobacionId);
	}

	@Override
	public AprobacionKit update(Long aprobacionId, double nuevaAprobacion) {
		// TODO Auto-generated method stub
		return null;
	}



	
	public boolean validarAprobacion(AprobacionKit aprobacion) {
		String observacionAproba = aprobacion.getTipoAprobacion();
		Boolean estadoAproba = aprobacion.getEstadoAproba();
		String detalleControl = aprobacion.getDetalleControl();
		Date fechaAprobacion = aprobacion.getFechaAprobacion();
		
		if(observacionAproba!=null 
				&& estadoAproba != null
				&& detalleControl != null
				&& fechaAprobacion != null
				&& estadoAproba != null
				) {
			return true;
		}
		
		
		return false;
	}

	@Override
	public AprobacionKit delete(Long id_aprobacion) {
		AprobacionKit aprobacion = getById(id_aprobacion).get();
		if(aprobacion == null) {
			return null;
		}else {
			aprobacionDao.deleteById(id_aprobacion);
			return aprobacion;
			
		}
	}

}

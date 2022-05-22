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

import com.irfeyal.interfaces.inventarios.AprobacionInterface;
import com.irfeyal.modelo.dao.inventarios.AprobacionDao;
import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Service // ("IAutoServiceImplement")
@Transactional
public class AprobacionService implements AprobacionInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private AprobacionDao aprobacionDao;
		
	
	@Override
	public Aprobacion save(Aprobacion aprobacion) {

		Aprobacion a = aprobacionDao.save(aprobacion);
		
		return a;
	}

	@Override
	public List<Aprobacion> listAllAprobacion() {
		// TODO Auto-generated method stub
		return (List<Aprobacion>) aprobacionDao.findAll();
	}

	@Override
	public Optional<Aprobacion> getById(Long aprobacionId) {

		return aprobacionDao.findById(aprobacionId);
	}

	@Override
	public Aprobacion update(Long aprobacionId, double nuevaAprobacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long aprobacionId) {
		return false;
		
	}

	// -----------------------MIS METODOS -------------------------------------
	public Object getDetalleAprobacion(Integer id) {
		Object detalleAprobacion = aprobacionDao.detalleApro(id);
		return detalleAprobacion;
	}
	
	public boolean validarAprobacion(Aprobacion aprobacion) {
		String observacionAproba = aprobacion.getTipoAprobacion();
		Boolean estadoAproba = aprobacion.getEstadoAproba();
		String detalleControl = aprobacion.getDetalleControl();
		Date fechaAprobacion = aprobacion.getFechaAprobacion();
		Date fechaControl = aprobacion.getFechaControl();
		
		if(observacionAproba!=null 
				&& estadoAproba != null
				&& detalleControl != null
				&& fechaAprobacion != null
				&& estadoAproba != null
				&& fechaControl != null
				) {
			return true;
		}
		
		
		return false;
	}

}

/*


package com.irfeyal.servicio.inventarios;

import java.util.ArrayList;
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

import com.irfeyal.interfaces.inventarios.IngresoKitInterface;
import com.irfeyal.interfaces.inventarios.MetodosModInventarios;
import com.irfeyal.modelo.dao.inventarios.AprobacionDao;
import com.irfeyal.modelo.dao.inventarios.IngresoKitDao;
import com.irfeyal.modelo.dao.inventarios.KitDao;
import com.irfeyal.modelo.dao.inventarios.ModuloLibroDao;
import com.irfeyal.modelo.dao.rolseguridad.EmpleadoDAO;
import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.IngresoKit;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@Service // ("IAutoServiceImplement")
@Transactional
public class IingresoKitService implements IngresoKitInterface {
	
	MetodosModInventarios metodosModInventarios = new MetodosModInventarios();
	
	@Autowired
	private IngresoKitDao ingresoKitRepo;

	@Autowired
	private AprobacionDao aprobacionRepo;

	@Autowired
	AprobacionService aprobacionService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	IKitService kitservice;

	@Override
	public IngresoKit save(IngresoKit ingresoKit) {
		boolean respValidaIngrKit = validarIngresoKit(ingresoKit);
		
		if(respValidaIngrKit==true) {
			Aprobacion aprobacion= aprobacionRepo.save(ingresoKit.getId_aprobacion());
			Date fechaActual = metodosModInventarios.obtenerFechaActual();
			aprobacion.setFechaAprobacion(fechaActual);
			aprobacion.setFechaControl(fechaActual);
			ingresoKit.setFechaIngreso(metodosModInventarios.obtenerFechaActual());
			ingresoKit.setId_aprobacion(aprobacion);
			//Kit nuevoKit = kitservice.save(ingresoKit.getId_kit());
			//ingresoKit.setId_kit(nuevoKit);
			Long idSecre = ingresoKit.getId_secretaria().getId_empleado();
			Long idAdmin = ingresoKit.getId_aprobacion().getId_empleado_admin().getId_empleado();
			Empleado secre = empleadoService.findById(idSecre);
			Empleado admin = empleadoService.findById(idAdmin);
			ingresoKit.getId_aprobacion().setId_empleado_admin(admin);
			ingresoKit.setId_secretaria(secre);
			return ingresoKitRepo.save(ingresoKit);
		}else {
			return null;// ingresoKitRepo.save(ingresoKit);
		}
		
		
		
	}

	@Override
	public List<IngresoKit> listAllIngresoKit() {
		// TODO Auto-generated method stub
		return (List<IngresoKit>) ingresoKitRepo.findAll();
	}

	@Override
	public Optional<IngresoKit> getById(Long ingresoKitId) {
		// TODO Auto-generated method stub
		return ingresoKitRepo.findById(ingresoKitId);
	}

	@Override
	public IngresoKit update(Long ingresoKitId, double nuevoIngresoKit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long ingresoKitId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	public boolean validarIngresoKit(IngresoKit ingresoKit) {
	
		return false;
		
	}

}


*/
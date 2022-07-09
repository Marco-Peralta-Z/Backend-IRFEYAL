package com.irfeyal.servicio.inventarios;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.irfeyal.interfaces.inventarios.AprobacionKitInterface;
import com.irfeyal.modelo.dao.inventarios.AprobacionKitDao;
import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.EstudiantePagoKit;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.inventarios.TempPagoKit;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.matricula.EstudianteServiceImpl;

@Service // ("IAutoServiceImplement")
@Transactional
public class AprobacionKitService implements AprobacionKitInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private AprobacionKitDao aprobacionDao;
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;

	@Autowired
	private IKitService kitService;
	
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
	
	
	public List<EstudiantePagoKit> listaPagosEstud() {
		Gson gson = new Gson();
		List<Object> obj = aprobacionDao.estudiantesPagado();
		List<EstudiantePagoKit> listaEstudPagos = new ArrayList<>();
		
		for (Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			String a = gson.toJson(object);
			JsonParser parseJSON = new JsonParser();
			JsonArray stringlistatiposPago = (JsonArray) parseJSON.parse(a);
			EstudiantePagoKit tempPagoKit = new EstudiantePagoKit();
			tempPagoKit.setIdEstudiante(Integer.parseInt(""+stringlistatiposPago.get(0)));
			tempPagoKit.setConceptoPago("Kit");
			tempPagoKit.setIdKit(Integer.parseInt(""+stringlistatiposPago.get(2)));
			tempPagoKit.setValorPagado(Float.parseFloat(""+stringlistatiposPago.get(3)));
			List<Estudiante> listEstudiante = estudianteServiceImpl.findAll();
			for (int i = 0; i < listEstudiante.size(); i++) {
				if((""+listEstudiante.get(i).getid_estudiante()).equals(""+tempPagoKit.getIdEstudiante())) {
					tempPagoKit.setEstudiante(listEstudiante.get(i));
					i=listEstudiante.size();
				}
			}
			List<Kit> listaKit = kitService.listAllKit();
			for (int i = 0; i < listaKit.size(); i++) {
				if((""+listaKit.get(i).getId_kit()).equals(tempPagoKit.getIdKit()+"")) {
					tempPagoKit.setKit(listaKit.get(i));
				}
			}
			listaEstudPagos.add(tempPagoKit);
		}
		return listaEstudPagos;
		
	}

}

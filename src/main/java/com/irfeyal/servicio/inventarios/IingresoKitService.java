package com.irfeyal.servicio.inventarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.IngresoKitInterface;
import com.irfeyal.modelo.dao.inventarios.AprobacionDao;
import com.irfeyal.modelo.dao.inventarios.IngresoKitDao;
import com.irfeyal.modelo.dao.inventarios.KitDao;
import com.irfeyal.modelo.dao.inventarios.ModuloLibroDao;
import com.irfeyal.modelo.inventarios.IngresoKit;
import com.irfeyal.modelo.inventarios.ModuloLibro;

@Service
public class IingresoKitService implements IngresoKitInterface {
	@Autowired
	private IngresoKitDao ingresoKitRepo;
	
	
	@Autowired
	private AprobacionDao aprobacionRepo;
	
	@Autowired
	private KitDao kitRepo;
	
	@Autowired
	private ModuloLibroDao moduloLibroRepo;
	

	@Override
	public IngresoKit save(IngresoKit ingresoKit) {
		// return ingresoKitRepo.save(ingresoKit);
		/*
		 * System.out.println("Fecha ingreso kit"+ingresoKit.getFechaIngreso());
		 * System.out.println("observacion aprovacion"+ingresoKit.getAprobacion().
		 * getObservacionAproba());
		 * System.out.println("Periodo kit"+ingresoKit.getKit().getPeriodo());
		 * System.out.println("Periodo kit"+ingresoKit.getKit().getPeriodo());
		 */

		//boolean estadoAprobacion = ingresoKit.getAprobacion().getEstadoAproba();

		//if (estadoAprobacion = true) {

			// m.setCantidad(ingresoKit.get)
			// System.out.println("*------------------------------->");
			/*
			List<ModuloLibro> listaModulos = new ArrayList<ModuloLibro>();
			for (int i = 0; i < ingresoKit.getKit().getModulo_libro().size(); i++) {
				ModuloLibro m = new ModuloLibro();
				m.setCantidad(ingresoKit.getKit().getModulo_libro().get(i).getCantidad());
				m.setCodModulo(ingresoKit.getKit().getModulo_libro().get(i).getCodModulo());
				m.setCurso(ingresoKit.getKit().getModulo_libro().get(i).getCurso());
				m.setNombreModulo(ingresoKit.getKit().getModulo_libro().get(i).getNombreModulo());
				m.setNumero(ingresoKit.getKit().getModulo_libro().get(i).getNumero());
				m.setNumeroModulo(ingresoKit.getKit().getModulo_libro().get(i).getNumeroModulo());
				ModuloLibro newModuloLibro = moduloLibroRepo.save(m);
				listaModulos.add(newModuloLibro);
			}
			System.out.println("*------------------------------->1");
			
			
			Kit k = new Kit();
			k.setPeriodo(ingresoKit.getKit().getPeriodo());
			k.setPrecioKit(ingresoKit.getKit().getPrecioKit());
			k.setModulo_libro(listaModulos);
			Kit newKit = kitRepo.save(k);
			System.out.println("*------------------------------->2");
			
			
			Aprobacion a = new Aprobacion();
			a.setDetalleControl(ingresoKit.getAprobacion().getDetalleControl());
			a.setEstadoAproba(ingresoKit.getAprobacion().getEstadoAproba());
			a.setFechaAprobacion(ingresoKit.getAprobacion().getFechaAprobacion());
			a.setFechaControl(ingresoKit.getAprobacion().getFechaControl());
			a.setId_rolu_admin(ingresoKit.getAprobacion().getId_rolu_admin());
			a.setObservacionAproba(ingresoKit.getAprobacion().getObservacionAproba());
			
			Aprobacion newProbacion = aprobacionRepo.save(a);
			System.out.println("*------------------------------->3");
			
			IngresoKit i = new IngresoKit();
			i.setAprobacion(newProbacion);
			i.setFechaIngreso(ingresoKit.getFechaIngreso());
			i.setId_secretaria(ingresoKit.getId_secretaria());
			i.setKit(newKit);
			System.out.println("*------------------------------->4");
			
			return ingresoKitRepo.save(i);*/

		//}

		return  null;//ingresoKitRepo.save(ingresoKit);
	}

	@Override
	public List<IngresoKit> listAllIngresoKit() {
		// TODO Auto-generated method stub
		return (List<IngresoKit>) ingresoKitRepo.findAll();
	}

	@Override
	public Optional<IngresoKit> getById(Long ingresoKitId) {
		// TODO Auto-generated method stub
		return null;
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

}

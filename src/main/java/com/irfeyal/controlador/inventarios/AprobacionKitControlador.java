package com.irfeyal.controlador.inventarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.irfeyal.interfaces.pagos.IDetalleComprobanteService;
import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.EstudiantePagoKit;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.inventarios.TempPagoKit;
//import com.irfeyal.modelo.inventarios.TempPagoKit;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.pagos.DetalleComprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.IKitService;
import com.irfeyal.servicio.inventarios.ModulolibroService;
import com.irfeyal.servicio.matricula.EstudianteServiceImpl;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@RestController
@RequestMapping("/aprobacionkit")
@CrossOrigin(origins = "*")
public class AprobacionKitControlador {

	@Autowired
	AprobacionKitService aprobacionService;

	@Autowired
	EmpleadoService empleadoService;

	@Autowired // (required = false)
	// @Qualifier("IAutoServiceImplement")
	IKitService kitService;

	@Autowired
	EstudianteServiceImpl estudianteService;

	@Autowired
	ModulolibroService modulolibroService;
	
	@Autowired
	IDetalleComprobanteService detalleComprobanteService;

	@GetMapping(path = "/list", produces = { "application/json" })
	public List<AprobacionKit> listAprobacion() {
		return aprobacionService.listAllAprobacion();
	}
	
	@GetMapping(path="/estudiantespagokit", produces = "application/json")
	public List<EstudiantePagoKit> listaEstudiantesPagoKit(){
		List<DetalleComprobante> lista = detalleComprobanteService.findAll();
		List<EstudiantePagoKit> listaConteoPagos = new ArrayList<>();
		
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdComprobante().getTipoComprobante().getConcepto_pago().equals("Kit")) {
				EstudiantePagoKit estudiantePagoKit =  new EstudiantePagoKit();
				estudiantePagoKit.setIdComprobante(lista.get(i).getIdComprobante().getId());
				estudiantePagoKit.setConceptoPago(lista.get(i).getIdComprobante().getTipoComprobante().getConcepto_pago());
				estudiantePagoKit.setValorPagado(lista.get(i).getIdComprobante().getValor_total());
				estudiantePagoKit.setEstudiante(lista.get(i).getIdComprobante().getIdMatricula().getEstudiante());
				estudiantePagoKit.setPeriodo(lista.get(i).getIdComprobante().getIdMatricula().getId_periodo());
				listaConteoPagos.add(estudiantePagoKit);
			}
		}
		return listaConteoPagos;	
	}
	
	

	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearAprobacion(@Validated @RequestBody AprobacionKit aprobacion,
			BindingResult result) {
		AprobacionKit nuevaAprobacion = null;
		Map<String, Object> respuesta = new HashMap<>();
		// System.out.println(aprobacion.getSecretaria());
		if (aprobacion.getAdministrador() != null) {
			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream()
						.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
						.collect(Collectors.toList());
				respuesta.put("errores", errors);
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
			}
			try {
				// Guardar malla
				Empleado emp = empleadoService.findById(aprobacion.getAdministrador().getId_empleado());
				aprobacion.setAdministrador(emp);
				aprobacion.setDetalleControl(aprobacion.getDetalleControl().toUpperCase());
				nuevaAprobacion = aprobacionService.save(aprobacion);
			} catch (DataAccessException e) {
				respuesta.put("mensaje", "Error al crear entidad");
				respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			respuesta.put("status", "ok");
			respuesta.put("aprobacion", nuevaAprobacion);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
		} else {
			respuesta.put("mensaje", "No existe el empleado");
			respuesta.put("error", null);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping(produces = { "application/json" })
	public ResponseEntity<?> buscarAprobaId(@RequestParam("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<AprobacionKit> aprobacion = this.aprobacionService.getById(id);
		if (aprobacion.isPresent()) {
			respuesta.put("status", "ok");
			respuesta.put("aprobacion", aprobacion.get());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "/entregakit", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> entregaKitEstudiante(@Validated @RequestBody AprobacionKit aprobacionKit,
			BindingResult result) {
		Estudiante kitEntregadoEstudiante = null;
		AprobacionKit aprobaEntregaKit = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {

			Estudiante estudianteBuscar = estudianteService.findById(aprobacionKit.getEstudiante().getid_estudiante());

			Kit kitBuscar = kitService.getById(aprobacionKit.getKit().getId_kit()).get();

			Empleado empleadoBuscar = empleadoService.findById(aprobacionKit.getAdministrador().getId_empleado());

			List<Kit> listaKitGuardar = estudianteBuscar.getListadoKits();

			listaKitGuardar.add(kitBuscar);
			estudianteBuscar.setListadoKits(listaKitGuardar);

			kitEntregadoEstudiante = estudianteService.save(estudianteBuscar);

			aprobacionKit.setKit(kitBuscar);
			aprobacionKit.setEstudiante(kitEntregadoEstudiante);
			aprobacionKit.setAdministrador(empleadoBuscar);

			// actualizar S T O K MODULOS
			List<ModuloLibro> listaModulosEditar = aprobacionKit.getKit().getListaModulos();
			List<ModuloLibro> listaModulosBaseDatos = modulolibroService.listAllModuloLibro();

			for (int i = 0; i < listaModulosBaseDatos.size(); i++) {
				for (int j = 0; j < listaModulosEditar.size(); j++) {
					if (listaModulosBaseDatos.get(i).getCodModulo().equals(listaModulosEditar.get(j).getCodModulo())) {
						int stockBD = listaModulosBaseDatos.get(i).getCantidad();
						int restarStockModulo = stockBD - 1;
						ModuloLibro ml = modulolibroService.getById(listaModulosBaseDatos.get(i).getId_modulo_libro())
								.get();
						ml.setCantidad(ml.getCantidad()-1);
						modulolibroService.save(ml);
					}
				}
			}

			aprobaEntregaKit = aprobacionService.save(aprobacionKit);

		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("aprobaEntregaKit", aprobaEntregaKit);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actualizarEntregaKit(@Validated @RequestBody AprobacionKit aprobacionKitUpdate,
			BindingResult result) {

		AprobacionKit aprobaBuscar = aprobacionService.getById(aprobacionKitUpdate.getId_aprobacion()).get();

		Estudiante kitEntregadoEstudiante = null;
		AprobacionKit aprobaEntregaKit = null;
		Map<String, Object> respuesta = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {

			Estudiante estudianteBuscar = estudianteService
					.findById(aprobacionKitUpdate.getEstudiante().getid_estudiante());

			Kit kitBuscar = kitService.getById(aprobacionKitUpdate.getKit().getId_kit()).get();

			Empleado empleadoBuscar = empleadoService.findById(aprobacionKitUpdate.getAdministrador().getId_empleado());

			List<Kit> listaKitGuardar = estudianteBuscar.getListadoKits();

			listaKitGuardar.add(kitBuscar);
			estudianteBuscar.setListadoKits(listaKitGuardar);

			kitEntregadoEstudiante = estudianteService.save(estudianteBuscar);

			aprobaBuscar.setKit(kitBuscar);
			aprobaBuscar.setEstudiante(kitEntregadoEstudiante);
			aprobaBuscar.setAdministrador(empleadoBuscar);

			// regresar S T O K MODULOS
			List<ModuloLibro> listaModulosEditar = aprobaBuscar.getKit().getListaModulos();
			List<ModuloLibro> listaModulosBaseDatos = modulolibroService.listAllModuloLibro();

			for (int i = 0; i < listaModulosBaseDatos.size(); i++) {
				for (int j = 0; j < listaModulosEditar.size(); j++) {
					if (listaModulosBaseDatos.get(i).getCodModulo().equals(listaModulosEditar.get(j).getCodModulo())) {
						int stockBD = listaModulosBaseDatos.get(i).getCantidad();
						int restarStockModulo = stockBD + 1;
						ModuloLibro ml = modulolibroService.getById(listaModulosBaseDatos.get(i).getId_modulo_libro())
								.get();
						ml.setCantidad(restarStockModulo);
						modulolibroService.save(ml);
					}
				}
			}

			// restart S T O K MODULOS
			List<ModuloLibro> listaModulosEditarRestar = aprobacionKitUpdate.getKit().getListaModulos();
			List<ModuloLibro> listaModulosBaseDatosRestar = modulolibroService.listAllModuloLibro();

			for (int i = 0; i < listaModulosBaseDatos.size(); i++) {
				for (int j = 0; j < listaModulosEditar.size(); j++) {
					if (listaModulosBaseDatos.get(i).getCodModulo().equals(listaModulosEditar.get(j).getCodModulo())) {
						int stockBD = listaModulosBaseDatos.get(i).getCantidad();
						int restarStockModulo = stockBD - 1;
						ModuloLibro ml = modulolibroService.getById(listaModulosBaseDatos.get(i).getId_modulo_libro())
								.get();
						ml.setCantidad(restarStockModulo);
						modulolibroService.save(ml);
					}
				}
			}

			aprobaBuscar.setEstadoAproba(aprobacionKitUpdate.getEstadoAproba());
			aprobaBuscar.setDetalleControl(aprobacionKitUpdate.getDetalleControl());
			aprobaBuscar.setFechaAprobacion(aprobacionKitUpdate.getFechaAprobacion());
			aprobaBuscar.setTipoAprobacion(aprobacionKitUpdate.getTipoAprobacion());

			aprobaEntregaKit = aprobacionService.save(aprobaBuscar);

		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("aprobacionUpdate", aprobaEntregaKit);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);

	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteAprobacionKit(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			AprobacionKit moduloLibro = aprobacionService.delete(id);
			if (moduloLibro == null) {
				respuesta.put("mensaje", "El modulo con id: " + id + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el modulo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "La aprobacion ha sido eliminada");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	@GetMapping(path = "/estudipagados", produces = { "application/json" })
	public ResponseEntity<Map<String, Object>> lisEstudiantePago() {
		List<TempPagoKit> listaEstidiantes = new ArrayList<>();
		List<TempPagoKit> listaPagos = aprobacionService.listaPagosEstud();
		for (Iterator iterator = listaPagos.iterator(); iterator.hasNext();) {
			TempPagoKit temp = (TempPagoKit) iterator.next();
			Estudiante es = new Estudiante();
			es = estudianteService.findById(temp.getId_estudiante());
			temp.setEstudiante(es);
			listaEstidiantes.add(temp);
		}
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("status", "ok");
		respuesta.put("listaEstudiante", listaEstidiantes);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}	
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/
	/* NO BORRAR DESCARGAR LAS DEPENDENCIAS BOORRA TU CODIGO NO EL DE LOS DEMAS*/

}

/*
 
 */

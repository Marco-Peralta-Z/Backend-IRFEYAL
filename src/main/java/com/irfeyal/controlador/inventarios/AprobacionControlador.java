package com.irfeyal.controlador.inventarios;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@RestController
@RequestMapping("/aprobacion")
@CrossOrigin(origins = "*")
public class AprobacionControlador {

	@Autowired
	AprobacionService aprobacionService;

	@Autowired
	EmpleadoService empleadoService;

	@GetMapping(path = "/list", produces = { "application/json" })
	public List<Aprobacion> listAprobacion() {
		return aprobacionService.listAllAprobacion();
	}


	
	
	
	
	
	@RequestMapping(value = "/crear/", method = RequestMethod.POST)
	public ResponseEntity<Aprobacion> creaeAprobacion(@Valid @RequestBody Aprobacion aprobacion) {

		Empleado emple = empleadoService.findById(aprobacion.getId_empleado_admin().getId_empleado());

		if (emple != null) {
			Aprobacion aprobacionReturn = aprobacionService.save(aprobacion,emple);

			if (aprobacionReturn != null) {
				System.out.print("------------>Entidad creada");
			} else {
				System.out.print("------------>No se pudo gardar");
			}

			return new ResponseEntity(aprobacionReturn, HttpStatus.CREATED);
		} else {
			System.out.print("empleado no encontrado");
		}

		return null;

	}

	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Aprobacion> buscarAprobaId(@RequestParam("id") Long id){
		Optional<Aprobacion> aprobacion = this.aprobacionService.getById(id);
		if(aprobacion.isPresent()) {
			return new ResponseEntity(aprobacion.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(produces = {"application/json"},value = "/eliminar/")
	public boolean eliminarAprobaId(@RequestParam("id") Long id){
		boolean aprobacion = this.aprobacionService.delete(id);
		return aprobacion;
	}

}

/*
 
 */

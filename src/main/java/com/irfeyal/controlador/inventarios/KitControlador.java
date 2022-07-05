package com.irfeyal.controlador.inventarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.servicio.inventarios.IKitService;
import com.irfeyal.servicio.inventarios.ModulolibroService;
import com.irfeyal.servicio.matricula.EstudianteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kit")
@CrossOrigin(origins = "*")
public class KitControlador {
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IKitService kitService;
	
	@Autowired
	EstudianteServiceImpl estudianteService;
	
	@Autowired
	ModulolibroService modulolibroService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Kit> listKit(){
		return kitService.listAllKit();
		
	}
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearKit(@Validated @RequestBody Kit kit, BindingResult result) {
		Kit nuevoKit = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Guardar kit
			kit.setNombrekit(kit.getNombrekit().toUpperCase());
			nuevoKit = kitService.save(kit, result);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("kit", nuevoKit);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerKit(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Optional<Kit> optionalKit = this.kitService.getById(id);
		if(optionalKit.isPresent()) {
			respuesta.put("status", "ok");
			respuesta.put("kit", optionalKit.get());
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping(path = "/entregakit", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> entregaKitEstudiante(@Validated @RequestBody Estudiante estudiante, BindingResult result) {
		Estudiante kitEntregadoEstudiante = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			
			Estudiante estudianteBuscar = estudianteService.findById(estudiante.getid_estudiante());
			List<Kit> listaKitGuardar = new ArrayList<>();
			for (int i = 0; i < estudiante.getListadoKits().size(); i++) {
				Kit k = new Kit();
				k = kitService.getById(estudiante.getListadoKits().get(i).getId_kit()).get();
				listaKitGuardar.add(k);
			}
			
			estudianteBuscar.setListadoKits(listaKitGuardar);
			
			kitEntregadoEstudiante = estudianteService.save(estudianteBuscar);
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("kit", kitEntregadoEstudiante);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actualizarKit(@PathVariable("id") Long idKit, @Validated @RequestBody Kit kit,
			BindingResult result) {
		Kit kitActual = kitService.getById(idKit).get();
		Kit kitUpdate = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (kitActual == null) {
			respuesta.put("mensaje", "Error: no se pudo editar el Kit: "
					.concat(idKit.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizando kit
			List<ModuloLibro> listaModulos = new ArrayList<>();
			for (int i = 0; i < kit.getListaModulos().size(); i++) {
				ModuloLibro modLib = new ModuloLibro();
				modLib = modulolibroService.getById(kit.getListaModulos().get(i).getId_modulo_libro()).get();
				listaModulos.add(modLib);
			}
			
			kitActual.setNombrekit(kit.getNombrekit().toUpperCase());
			kitActual.setPeriodo(kit.getPeriodo());
			kitActual.setPrecioKit(kit.getPrecioKit());
			kitActual.setListaModulos(listaModulos);
			
			
			kitUpdate = kitService.update(kitActual);
			
			
			
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "El Kit ha sido actualizado con éxito");
		respuesta.put("kit", kitUpdate);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	

}

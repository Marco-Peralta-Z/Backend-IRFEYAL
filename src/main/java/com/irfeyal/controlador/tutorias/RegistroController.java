package com.irfeyal.controlador.tutorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;
import com.irfeyal.servicio.tutorias.RegistroServiceImpl;


@RestController
@RequestMapping("/Registro")
public class RegistroController {

	@Autowired
	private RegistroServiceImpl registroserviceimpl;
	
	@Autowired
	private IRegistroService registroservice;
	
	//Lista los registros
	@GetMapping()
	public List<Registro> index(){
		return registroserviceimpl.findAll();
	}
	
	
	//Inserta un nuevo registro
	@PostMapping()
	public ResponseEntity<Map<String, Object>> insertarRegistro(@RequestBody Registro registro) {
		Map<String, Object> mensaje = new HashMap<>();
		try {
			this.registroserviceimpl.save(registro);
		} catch (DataAccessException e) {
			mensaje.put("mensaje", "Error al realizar el ingreso de registro");
			mensaje.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
          return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		mensaje.put("mensaje",	"El registro fue creado con exito");
		return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.CREATED);	
	}
	
	
	
	
	// buscar por id
	@GetMapping("{id_registro}")
	public ResponseEntity<?> show(@PathVariable Long id_registro) {
		Registro registro= registroserviceimpl.findById(id_registro);
		Map <String, Object> response =new HashMap<>();
		try {
			registro= registroserviceimpl.findById(id_registro);
		} catch (Exception e) {
		response.put("mensaje", "Error al realizar consulta");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(registro==null) {
			response.put("mensaje", "El id del registro ".concat(id_registro.toString().concat(id_registro.toString().concat(" no existe"))));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Registro>(registro,HttpStatus.OK);
	}
	
	//eliminar un registro por id
		@DeleteMapping(path="{id_registro}")
		public void delete( @PathVariable Long id_registro) {
			registroserviceimpl.delete(id_registro);	
		}
		
		
		@GetMapping("/Periodo")
		public List<Periodo> listarPeridod() {
			return registroserviceimpl.findAllperiodo();
		}
		
		
		@GetMapping("/Periodos/{idemple}")
		public List<Periodo> listperiodos(@PathVariable Long idemple) {
			return registroservice.Listperiodosempelados(idemple);
		}
		@GetMapping("/Modalidades/{idemple}/{idmod}")
		public List<Modalidad> listmodalidades(@PathVariable Long idemple,@PathVariable Long idmod) {
			return registroservice.listmodalidadempelados(idemple, idmod);
		}
		@GetMapping("/Cursos/{idemple}/{idmod}")
		public List<Curso> listcurso(@PathVariable Long idemple,@PathVariable Long idmod) {
			return registroservice.ListCursosempelados(idemple, idmod);
		}
		@GetMapping("/Paralelos/{idemple}/{idcurso}")
		public List<Paralelo> listparalelo(@PathVariable Long idemple,@PathVariable Long idcurso) {
			return registroservice.ListParaleloempleados(idemple, idcurso);
		}
		@GetMapping("/Asignaturas/{idemple}/{idperiodo}/{idcurso}/{idparalelo}")
		public List<Asignatura> listasignatura(@PathVariable Long idemple , @PathVariable Long idperiodo, @PathVariable Long idcurso,@PathVariable Long idparalelo) {
			return registroservice.ListAsignaturaempleados(idemple, idperiodo, idcurso, idparalelo);
		}
		
		
		
}

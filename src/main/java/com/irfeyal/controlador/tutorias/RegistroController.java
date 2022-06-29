package com.irfeyal.controlador.tutorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;
import com.irfeyal.servicio.tutorias.RegistroServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroServiceImpl registroserviceimpl;
	
	@Autowired
	private IRegistroService registroservice;
	
	//Lista los registros
	@GetMapping("/ListarRegistros")
	public List<Registro> index(){
		return registroserviceimpl.findAll();
	}
	
	
	//Inserta un nuevo registro
	@PostMapping("/Nuevoregistro")
	public ResponseEntity<Map<String, Object>> insertarRegistro(@RequestBody Registro registro, BindingResult result) {
		
		Registro registronew = null;
		
		Map<String, Object> mensaje = new HashMap<>();
		
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			mensaje.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.BAD_REQUEST);
		}
		
		try {
			registronew=registroserviceimpl.save(registro);
		} catch (DataAccessException e) {
			mensaje.put("mensaje", "Error al realizar el ingreso de registro");
			mensaje.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
          return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		mensaje.put("mensaje",	"El registro fue creado con exito");
		mensaje.put("cliente", registronew);
		return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.CREATED);	
	}
	
	
	
	
	// buscar por id
	@GetMapping("ListarporId/{id_registro}")
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
			response.put("mensaje", "El id del registro ".concat(id_registro.toString().concat(" no existe")));
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
		
		@GetMapping("/Malla/{idemple}/{per}")
		public List<Malla>ListMalla(@PathVariable Long idemple, @PathVariable Long per){
			return registroservice.ListMalla(idemple, per);
		}
		
		
		@GetMapping("/Modalidades/{idemple}/{per}/{malla}")
		public List<Modalidad> listmodalidades(@PathVariable Long idemple,@PathVariable Long per, @PathVariable Long malla) {
			return registroservice.listmodalidadempelados(idemple, per, malla);
		}
		@GetMapping("/Cursos/{idemple}/{per}/{malla}/{idmod}")
		public List<Curso> listcurso(@PathVariable Long idemple, @PathVariable Long per,@PathVariable Long malla,@PathVariable Long idmod ) {
			return registroservice.ListCursosempelados(idemple, per, malla, idmod);
		}
		@GetMapping("/Paralelos/{idemple}/{per}/{malla}/{idmod}/{idcurso}")
		public List<Paralelo> listparalelo(@PathVariable Long idemple, @PathVariable Long per, @PathVariable Long malla, @PathVariable Long idmod, @PathVariable Long idcurso) {
			return registroservice.ListParaleloempleados(idemple, per, malla, idmod, idcurso);
		}
		@GetMapping("/Asignaturas/{idemple}/{per}/{malla}/{idmod}/{idcurso}/{idparalelo}")
		public List<Asignatura> listasignatura(@PathVariable Long idemple , @PathVariable Long per,@PathVariable Long malla, @PathVariable Long idmod, @PathVariable Long idcurso,@PathVariable Long idparalelo) {
			return registroservice.ListAsignaturaempleados(idemple, per, malla, idmod, idcurso, idparalelo);
		}
		
		@GetMapping("/Filtrocompleto/{idasig}/{idperiodo}/{idcurso}/{idparalelo}/{idmod}")
		public List<Registro> listcompleta(@PathVariable Long idasig , @PathVariable Long idperiodo, @PathVariable Long idcurso,@PathVariable Long idparalelo, @PathVariable Long idmod) {
			return registroservice.filtrocompleto(idasig,idperiodo,idcurso, idparalelo, idmod);
		}
		
		@GetMapping("/buscarestudianteporcedula/{ced}")
		public Comprobante fecha(@PathVariable String ced) {

			return registroservice.buscarceduestudiante(ced);

		}
		
		@PutMapping(value="/Update/{id_registro}")
		public ResponseEntity<Object>updateRegistro(@RequestBody Registro registro, @PathVariable Long id_registro){
			this.registroserviceimpl.update(registro, id_registro);
			return ResponseEntity.ok(Boolean.TRUE);	
		}
		
		//Para secretaria, certificado de promocion
		@GetMapping("/buscarcedulaEstudiante/{cedula}")
		public List<Registro> buscarPorCedulaEstudiante(@PathVariable String cedula){
			return registroserviceimpl.findByCedulaEstudiante(cedula); 
		}
		
}

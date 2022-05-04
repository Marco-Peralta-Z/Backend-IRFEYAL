package com.irfeyal.controlador.rolseguridad;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.rolseguridad.UsuarioInterface;
import com.irfeyal.modelo.rolseguridad.Usuario;
import com.irfeyal.modelo.rolseguridad.UsuarioLogin;
import com.irfeyal.servicio.rolseguridad.UsuarioLoginServices2;
import com.irfeyal.servicio.rolseguridad.UsuarioServices;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapUsuario")


public class UsuarioControler {
	
	@Autowired
	 private UsuarioServices usuarioSer;
	@Autowired
	private UsuarioLoginServices2 usuarioLoginSer;
	
	@GetMapping("/Usuario")
	public List<Usuario> index(){
		return usuarioSer.findAll();
	}
	
	
	//metodo de busqueda 
	
	@GetMapping(path = "/list", produces = { "application/json" })
	public List<Usuario> listausuarios() {
		return usuarioSer.listAllUsuario();
	}

	@GetMapping(path = "/login", produces = { "application/json" })
	public UsuarioLogin login(@RequestParam(value = "usuario") String usuario, @RequestParam(value = "contrasenia") String contrasenia) {
		System.out.println("*********************************************");
		System.out.print( usuarioLoginSer.LoginUser(usuario, contrasenia));
		
		return usuarioLoginSer.LoginUser(usuario, contrasenia);
	}
	
	
	
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			Usuario usuarioNew =usuarioSer.findById(id);
			usuarioSer.deleteUsuario(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el usuario de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Usuario eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/usuario")
	public ResponseEntity<?> create(@Validated @RequestBody Usuario usuario, BindingResult result) {
		
		
		Usuario usuarioNew= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			usuarioNew= usuarioSer.saveUsuario(usuarioNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El usuario ha sido creado con exito");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Usuario usuario,BindingResult result, @PathVariable Long id) {
		Usuario usuarioActual = usuarioSer.findById(id);
		Usuario usuarioUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (usuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
		usuarioActual.setUsuario(usuario.getUsuario());
		usuarioActual.setContrasenia(usuario.getContrasenia());
		usuarioActual.setEstUsuario(usuario.getEstUsuario());

		usuarioActual.setEmpleado(usuario.getEmpleado());
		usuarioUpdate= usuarioSer.saveUsuario(usuarioActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El Usuario ha sido actualizado con exito");
		response.put("usuario", usuarioUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

}

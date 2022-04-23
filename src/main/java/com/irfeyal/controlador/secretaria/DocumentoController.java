package com.irfeyal.controlador.secretaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.secretaria.IDocumentoService;
import com.irfeyal.modelo.secretaria.Documento;


@CrossOrigin(origins= {"http://localhost:9070"})
@RestController
@RequestMapping("/api")
public class DocumentoController {
	
	@Autowired
	private IDocumentoService documentoService;
	
	//listar todos los documentos
	@GetMapping("/documentos")
	public List<Documento> index(){
		return documentoService.findAll();
	}
		
	//Buscar por id
	@GetMapping("/documentos/{id}")
	public Documento show(@PathVariable Long id) {
		return documentoService.findById(id);
	}
	
	//Guardar
	@PostMapping("/documentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Documento save(@RequestBody Documento documento) {
		
		return documentoService.save(documento);
	}
	
	//Editar
	@PutMapping("/documentos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Documento update(@RequestBody Documento documento, @PathVariable Long id) {
		Documento documentoActual = documentoService.findById(id);
		documentoActual.setTipo_documento(documento.getTipo_documento());
		documentoActual.setDescripcion(documento.getDescripcion());
		documentoActual.setUbicacion(documento.getUbicacion());
		
		return documentoService.save(documentoActual);
		
	}
	
	
	
	//Eliminar
	@DeleteMapping("/documentos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		documentoService.delete(id);
	}
	
	

}

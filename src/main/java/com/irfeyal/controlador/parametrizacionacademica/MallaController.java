package com.irfeyal.controlador.parametrizacionacademica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.irfeyal.interfaces.parametrizacionacademica.MallaServices;
import com.irfeyal.modelo.parametrizacionacademica.Malla;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/malla")
public class MallaController {

    @Autowired
    private MallaServices mallaService;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<?> getMallas() {
        return new ResponseEntity<>(mallaService.getAllMalla(), HttpStatus.OK);
    }

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<?> getAllMallas(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(mallaService.getAllMalla(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getMallaById(@PathVariable("id") Long idMalla) {
        Optional<Malla> malla = null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            malla = mallaService.getMallaById(idMalla);
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (malla.isEmpty()) {
            respuesta.put("mensaje",
                    "La Malla ID: ".concat(idMalla.toString().concat(": no existe en la base de datos")));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(malla, HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> createMalla(@Validated @RequestBody Malla malla, BindingResult result) {
        Malla mallaNuevo = null;
        Map<String, Object> respuesta = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            respuesta.put("errores", errors);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        try {
            // Guardar malla
            malla.setDescripcion(malla.getDescripcion().toUpperCase());
            System.out.println(malla.getId_modalidad());
            mallaNuevo = mallaService.saveMalla(malla);
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al crear la malla en la base de datos");
            respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "La Malla ha sido creado con éxito!");
        respuesta.put("malla: ", mallaNuevo);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateMalla(@PathVariable("id") Long idMalla, @Validated @RequestBody Malla malla,
            BindingResult result) {
        Optional<Malla> mallaActual = mallaService.getMallaById(idMalla);
        Malla mallaUpdated = null;
        Map<String, Object> respuesta = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            respuesta.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if (mallaActual.isEmpty()) {
            respuesta.put("mensaje", "Error: no se pudo editar la Malla ID: "
                    .concat(idMalla.toString().concat(", no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        try {
            // Actualización malla
            mallaActual.get().setEstado(malla.getEstado());
            mallaActual.get().setDescripcion(malla.getDescripcion().toUpperCase());
            mallaActual.get().setListarea(malla.getListarea());
            mallaActual.get().setListaAsignaturas(malla.getListaAsignaturas());
            mallaActual.get().setListaCursos(malla.getListaCursos());
            mallaActual.get().setId_modalidad(malla.getId_modalidad());
            mallaUpdated = mallaService.saveMalla(mallaActual.get());
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al realizar el update en la base de datos");
            respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
        }
        respuesta.put("mensaje", "La Malla ha sido actualizado con éxito");
        respuesta.put("malla", mallaUpdated);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Map<String, Object>> deleteMalla(@PathVariable("id") Long idMalla) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            Malla mallaRecu = mallaService.deleteMalla(idMalla);
            if (mallaRecu == null) {
                respuesta.put("mensaje", "La Malla ID: " + idMalla + " no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al eliminar la Malla de la base de datos");
            respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "La Malla ID: " + idMalla + ", ha sido eliminado");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

}

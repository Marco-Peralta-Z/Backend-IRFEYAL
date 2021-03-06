package com.irfeyal.servicio.inventarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.irfeyal.interfaces.inventarios.KitInterface;
import com.irfeyal.modelo.dao.inventarios.KitDao;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

@Service // ("IAutoServiceImplement")
@Transactional
public class IKitService implements KitInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private KitDao kitRepo;
	
	@Autowired
	ModulolibroService modulolibroService;
	
	@Override
	public Kit save(Kit kit, BindingResult result) {
		
		Kit kitSave= kitRepo.save(kit);
		
		return kitSave;
	
	}

	@Override
	public List<Kit> listAllKit() {
		// TODO Auto-generated method stub
		return (List<Kit>) kitRepo.findAll();
	}

	@Override
	public Optional<Kit> getById(Long kitId) {
		return  kitRepo.findById(kitId) ;
	}
	
	public Integer getKitParaPagos(Long id_estudiante){
		Integer kitParaPago = kitRepo.kitEstudianteParaPagos(id_estudiante);
		return kitParaPago;
	}

	@Override
	public Kit update(Kit updateKit) {
		
		Kit k = kitRepo.save(updateKit);
		
		return k;
	}

	@Override
	public Kit delete(Long kitId) {
		Kit kitEliminar = getById(kitId).get();
		if(kitEliminar == null) {
			return null;
		}else {
			kitRepo.deleteById(kitId);
			return kitEliminar;
		}
	}

	public boolean ValidarKit(Kit kit) {
		boolean validacion = false;
		try {
			String nombre = kit.getNombrekit();
			int precioKit = kit.getPrecioKit();
			Periodo periodo = kit.getPeriodo();
			//System.out.print("-*-*-*-*-*-***-*-*-*-*-*------>"+validaModulo);
			List<ModuloLibro> listaModulos = new ArrayList<>();
			for (int i = 0; i < kit.getListaModulos().size(); i++) {
				ModuloLibro returnModLibro = modulolibroService.getById(kit.getListaModulos().get(i).getId_modulo_libro()).get();
				listaModulos.add(returnModLibro);
			}
			if (nombre.length() > 0 && precioKit> 0 && periodo != null && listaModulos.size() > 0) {
				validacion = true;
			} else {
				validacion = false;
			}
		}catch(NullPointerException nex) {
			System.out.print("Error insert kit> "+nex);
			validacion =  false;
		}
		
		return validacion;
	}
	
}

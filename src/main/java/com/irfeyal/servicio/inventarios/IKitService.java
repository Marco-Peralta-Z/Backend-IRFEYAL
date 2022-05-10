package com.irfeyal.servicio.inventarios;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.KitInterface;
import com.irfeyal.modelo.dao.inventarios.KitDao;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;

@Service // ("IAutoServiceImplement")
@Transactional
public class IKitService implements KitInterface {

	// @Qualifier("kitRepo")
	@Autowired
	private KitDao kitRepo;
	
	@Autowired
	ModulolibroService modulolibroService;
	
	@Override
	public Kit save(Kit kit) {
		if (ValidarKit(kit)) {
			Kit k = kitRepo.save(kit);
			List<ModuloLibro> listaModulos= kit.getModuloLibro();
			for(int i=0; i<listaModulos.size(); i++) {
				ModuloLibro moduloLibro = (ModuloLibro) listaModulos.get(i);
				moduloLibro.setKit(k);
				modulolibroService.save(moduloLibro);
			}
			return k;
		} else {
			return null;
		}
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

	@Override
	public Kit update(Long kitId, double nuevokit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long kitId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ValidarKit(Kit kit) {
		boolean validaModulo = true;
		int precioKit = kit.getPrecioKit();
		String periodo = kit.getPeriodo();
		List<ModuloLibro> listaModulos= kit.getModuloLibro();
		for(int i=0; i<listaModulos.size(); i++) {
			ModuloLibro moduloLibro = (ModuloLibro) listaModulos.get(i);
			boolean modLivalida = modulolibroService.ValidarModuloLibro(moduloLibro);
			if(modLivalida == false) {
				validaModulo=false;
			}
		}
		//System.out.print("-*-*-*-*-*-***-*-*-*-*-*------>"+validaModulo);
		if (precioKit > 0 && periodo != null && validaModulo == true) {
			return true;
		} else {
			return false;
		}
	}
	
}

package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.SalidaArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.SalidaArticuloDao;
import com.irfeyal.modelo.inventarios.Articulo;
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.inventarios.Salidaarticulo;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Service // ("IAutoServiceImplement")
@Transactional
public class SalidaArticuloService implements SalidaArticuloInterface {

	@Autowired
	SalidaArticuloDao salidaArticuloDao;
	
	@Autowired
	InventarioService inventarioService;
	
	@Override
	public Salidaarticulo save(Salidaarticulo salidaarticulo) {
		// TODO Auto-generated method stub
		return salidaArticuloDao.save(salidaarticulo);
	}

	@Override
	public List<Salidaarticulo> listAllSalidaarticulo() {
		// TODO Auto-generated method stub
		return (List<Salidaarticulo>) salidaArticuloDao.findAll();
	}

	@Override
	public Optional<Salidaarticulo> getById(Long id_Salidaarticulo) {
		// TODO Auto-generated method stub
		return salidaArticuloDao.findById(id_Salidaarticulo);
	}

	@Override
	public Salidaarticulo update(Long id_Salidaarticulo, double nuevoSalidaarticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salidaarticulo delete(Long id_Salidaarticulo) {
		Salidaarticulo salArti = getById(id_Salidaarticulo).get();
		if(salArti == null) {
			return null;
		}else {
			Empleado emp = salArti.getEmpleado();
			Inventario inv = salArti.getInventario();
			inv.setDisponibilidad(inv.getDisponibilidad()+1);
			inv.getArticulo().setArtiDisponibilidad(true);
			inventarioService.save(inv);
			salidaArticuloDao.deleteById(id_Salidaarticulo);
			return salArti;
			
		}
	}

}

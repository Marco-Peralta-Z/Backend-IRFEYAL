package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.InventarioInterface;
import com.irfeyal.modelo.dao.inventarios.InventarioDao;
import com.irfeyal.modelo.inventarios.Inventario;

@Service // ("IAutoServiceImplement")
@Transactional
public class InventarioService implements InventarioInterface {

	@Autowired
	InventarioDao inventarioDao;
	
	
	@Override
	public Inventario save(Inventario inventario) {
		// TODO Auto-generated method stub
		return inventarioDao.save(inventario);
	}

	@Override
	public List<Inventario> listAllInventario() {
		// TODO Auto-generated method stub
		return  (List<Inventario>) inventarioDao.findAll();
	}

	@Override
	public Optional<Inventario> getById(Long id_Inventario) {
		// TODO Auto-generated method stub
		return inventarioDao.findById(id_Inventario);
	}

	@Override
	public Inventario update(Long id_Inventario, double nuevoInventario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_inventario) {
		// TODO Auto-generated method stub
		return false;
	}

}

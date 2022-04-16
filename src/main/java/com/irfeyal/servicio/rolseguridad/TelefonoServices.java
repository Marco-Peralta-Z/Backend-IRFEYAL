package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.TelefonoInterface;
import com.irfeyal.modelo.dao.rolseguridad.TelefonoDAO;
import com.irfeyal.modelo.rolseguridad.Telefono;
@Service
public class TelefonoServices implements TelefonoInterface {

	@Autowired
	  private TelefonoDAO telfdao;

	@Override
	public List<Telefono> findAll() {
		// TODO Auto-generated method stub
		return (List<Telefono>)telfdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Telefono> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return telfdao.findAll(pageable);
	}

	@Override
	public Telefono findById(Long id) {
		// TODO Auto-generated method stub
		return telfdao.findById(id).orElse(null);
	}

	@Override
	public Telefono saveTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		return telfdao.save(telefono);
	}

	@Override
	public void deleteTelefono(Long id) {
		// TODO Auto-generated method stub
		telfdao.deleteById(id);
	}
	
	
}

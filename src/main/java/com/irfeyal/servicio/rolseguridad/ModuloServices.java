package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.rolseguridad.ModuloInterface;
import com.irfeyal.modelo.dao.rolseguridad.ModuloDAO;
import com.irfeyal.modelo.rolseguridad.Modulo;

@Service
public class ModuloServices implements ModuloInterface{
	@Autowired (required = true)
	private ModuloDAO modulodao;

	@Override
	public List<Modulo> findAll() {
		// TODO Auto-generated method stub
		return (List<Modulo>) modulodao.findAll();
	}

	@Override
	public Page<Modulo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return modulodao.findAll(pageable);
	}

	@Override
	public Modulo findById(Long id) {
		// TODO Auto-generated method stub
		return modulodao.findById(id).orElse(null);
	}

	@Override
	public Modulo saveModulo(Modulo modulo) {
		// TODO Auto-generated method stub
		return modulodao.save(modulo);
	}

	@Override
	public void deleteModulo(Long id) {
		// TODO Auto-generated method stub
		modulodao.deleteById(id);
		
	}

	
}

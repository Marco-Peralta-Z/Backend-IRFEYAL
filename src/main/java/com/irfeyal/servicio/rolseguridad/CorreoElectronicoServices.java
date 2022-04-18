package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.CorreoElectronicoInterface;
import com.irfeyal.modelo.dao.rolseguridad.CorreoElectronicoDAO;
import com.irfeyal.modelo.rolseguridad.CorreoElectronico;




@Service
public class CorreoElectronicoServices implements CorreoElectronicoInterface{
	
	@Autowired (required = true)
	  private CorreoElectronicoDAO correodao;

	@Override
	
	public List<CorreoElectronico> findAll() {
		// TODO Auto-generated method stub
		return (List<CorreoElectronico>)correodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CorreoElectronico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return correodao.findAll(pageable);
	}

	@Override
	public CorreoElectronico findById(Long id) {
		// TODO Auto-generated method stub
		return correodao.findById(id).orElse(null);
	}

	@Override
	public CorreoElectronico saveCorreo(CorreoElectronico correoelectronico) {
		// TODO Auto-generated method stub
		return correodao.save(correoelectronico);
	}

	@Override
	public void deleteCorreo(Long id) {
		// TODO Auto-generated method stub
		correodao.deleteById(id);
	}


	
	
	  
	
	
	

}

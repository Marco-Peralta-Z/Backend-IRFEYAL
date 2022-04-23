package com.irfeyal.servicio.secretaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.secretaria.IRegistroBitacoraService;
import com.irfeyal.modelo.dao.secretaria.IRegistroBitacoraDao;
import com.irfeyal.modelo.secretaria.RegistroBitacora;

@Service
public class RegistroBitacoraServiceImpl implements IRegistroBitacoraService{
	
	@Autowired
	private IRegistroBitacoraDao registroBitacoraDao;

	@Override
	@Transactional(readOnly = true)
	public List<RegistroBitacora> findAll() {
		
		return (List<RegistroBitacora>) registroBitacoraDao.findAll();
	}

	@Override
	public Page<RegistroBitacora> findAll(Pageable pageable) {
		
		return registroBitacoraDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroBitacora findById(Long id) {
		
		return registroBitacoraDao.findById(id).orElse(null);
	}

	@Override
	public RegistroBitacora save(RegistroBitacora registroBitacora) {
		
		return registroBitacoraDao.save(registroBitacora);
	}

	@Override
	public void delete(Long id) {
		registroBitacoraDao.deleteById(id);
		
	}

	


}

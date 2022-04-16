package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.EntregaKitInterface;
import com.irfeyal.modelo.dao.inventarios.EntregakitDao;
import com.irfeyal.modelo.inventarios.EntregaKit;

@Service//("IAutoServiceImplement")
@Transactional
public class EntregaKitService implements EntregaKitInterface{
	
	//@Qualifier("kitRepo")
		@Autowired
		private EntregakitDao entregakitRepo;

	@Override
	public EntregaKit save(EntregaKit entregaKit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntregaKit> listAllEntregaKit() {
		// TODO Auto-generated method stub
		return (List<EntregaKit>) entregakitRepo.findAll();
	}

	@Override
	public Optional<EntregaKit> getById(Long entregaKitId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntregaKit update(Long entregaKitId, double nuevaEntregaKit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long entregaKitId) {
		// TODO Auto-generated method stub
		return false;
	}
		
		
		
		

}

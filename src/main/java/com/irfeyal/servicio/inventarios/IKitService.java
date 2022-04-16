package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.KitInterface;
import com.irfeyal.modelo.dao.inventarios.KitDao;
import com.irfeyal.modelo.inventarios.Kit;


@Service//("IAutoServiceImplement")
@Transactional
public class IKitService implements KitInterface {
	
	//@Qualifier("kitRepo")
	@Autowired
	private KitDao KitRepo;

	@Override
	public Kit save(Kit kit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kit> listAllKit() {
		// TODO Auto-generated method stub
		return (List<Kit>) KitRepo.findAll();
	}

	@Override
	public Optional<Kit> getById(Long kitId) {
		// TODO Auto-generated method stub
		return null;
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

	


}

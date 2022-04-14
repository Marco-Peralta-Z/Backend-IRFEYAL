package com.irfeyal.servicio.parametrizacionacademica;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.parametrizacionacademica.ParaleloServices;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;

@Service
public class ParaleloServicesImp implements ParaleloServices {

	@Autowired
	private ParaleloRespository paraleloRepo;

	@Override
	public List<Paralelo> getAllParalelo() {
		return paraleloRepo.findAll();
	}

	@Override
	public Page<Paralelo> getAllParalelo(Pageable pageable) {
		return paraleloRepo.findAll(pageable);
	}

	@Override
	public Paralelo getParaleloById(Long idParalelo) {
		return paraleloRepo.getById(idParalelo);
	}

	@Override
	public Paralelo saveParalelo(Paralelo Paralelo) {
		return paraleloRepo.save(Paralelo);
	}

	@Override
	public Paralelo deleteParalelo(Long idParalelo) {
		try {
			Paralelo paraleloRecu = paraleloRepo.findById(idParalelo).get();
			paraleloRepo.delete(paraleloRecu);
			return paraleloRecu;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}

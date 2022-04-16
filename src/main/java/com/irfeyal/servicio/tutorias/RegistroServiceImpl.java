package com.irfeyal.servicio.tutorias;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.dao.tutorias.IRegistroDao;
import com.irfeyal.modelo.tutorias.Registro;

@Service
public class RegistroServiceImpl implements IRegistroService {
	
	@Autowired
	
	private IRegistroDao iregistrodao;
	
	public Registro save(Registro registro) {
		return iregistrodao.save(registro);
	}
	
	
	//Listar Registros
	public ArrayList<Registro>listarRegistro(){
		return (ArrayList<Registro>) iregistrodao.findAll(); 
	}
	
	// buscar por id
		@Override
		//@Transactional(readOnly = true)
		public Registro findById(Long id_registro) {
			// TODO Auto-generated method stub
			return iregistrodao.findById(id_registro).orElse(null);
		}
		
		@Override
		@Transactional 
		public void delete(Long id_registro) {	
			iregistrodao.deleteById(id_registro);
		}


		@Override
		public ArrayList<Registro> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		

}

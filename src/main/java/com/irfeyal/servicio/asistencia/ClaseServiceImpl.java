package com.irfeyal.servicio.asistencia;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.asistencia.IClaseService;

import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.dao.asistencia.IClaseDao;
import com.irfeyal.modelo.dao.rolseguridad.EmpleadoDAO;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.modelo.rolseguridad.Usuario;

@Service
public class ClaseServiceImpl implements IClaseService{
	
	@Autowired
	private IClaseDao clasedao;
	@Autowired
	private EmpleadoDAO usaurio;


	@Override
	public Clase save(Clase clase) {
		// TODO Auto-generated method stub
		return clasedao.save(clase);
	}

	@Override
	public List<Clase> findAll() {
		// TODO Auto-generated method stub
		return clasedao.findAll();
	}

	@Override
	public Clase findById(Long id) {
		// TODO Auto-generated method stub
		return clasedao.getById(id);
	}

	@Override
	public List<Clase> mostrarfechas(Long idestudiante, Integer iddocente, Integer idasignatura, Integer idcurso,
			Integer idparalelo, Integer idmodalidad, Integer idperiodo) {
		// TODO Auto-generated method stub
		return clasedao.mostrarfechasid(idestudiante, iddocente, idasignatura, idcurso, idparalelo, idmodalidad, idperiodo);
	}

	//CORREGIR 
	
	
	@Override
	public Clase ultimoingreso() {
		// TODO Auto-generated method stub
		return clasedao.findclaseingreseda();
	}

	@Override
	public List<Clase> validarclase(Integer iddocente, Integer idperiodo, Integer idmodalidad,Integer idcurso,
			Integer idparalelo,Integer idasignatura, Date fecha) {
		// TODO Auto-generated method stub
		return clasedao.validarclase(iddocente, idperiodo, idmodalidad, idcurso, idparalelo, idasignatura, fecha);
	}



	@Override
	public Long validarclass(Integer iddocente, Integer idperiodo, Integer idmodalidad, Integer idcurso,
			Integer idparalelo, Integer idasignatura, Date fecha) {
		// TODO Auto-generated method stub
		return clasedao.validarclass(iddocente, idperiodo, idmodalidad, idcurso, idparalelo, idasignatura, fecha);
	}

	

	
	
}

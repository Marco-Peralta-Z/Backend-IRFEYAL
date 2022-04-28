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

		/*
		 * 
		 * 
		 * SACAR INFORMACION
		 * 
		 *1)LISTA PERIODO (CONSULTA BD)
		 * 	CAPTURAR ID_PERIODO (FRONTEND)
		 * 	BUSCAR MODALIDADES QUE PERTENECEN UNICAMENTE AL PERIODO(CONSULTA BD)
		 *	LISTAR MODALIDADES COMBO BOX
		 *2)LISTA MODALIDADES EN COMBOBOX
		 *	CAPTURAR ID_MODALIDAD (FRONTEND)
		 * 	BUSCAR CURSOS QUE PERTENECEN UNICAMENTE A ESA MODALIDAD (CONSULTA BD)
		 * 	LISTAR CURSOS COMBO BOX
		 *3)LISTA CURSOS COMBOBOX
		 * 	CAPTURAR ID_CURSO (FRONTEND)
		 * 	BUSCAR PARALELOS QUE PERTENCEN UNICAMENTE A ESE CURSO (CONSULTA BD)
		 * 	LISTAR PARALELOS EN EL COMBOBOX
		 *4)LISTA PARALELOS COMBOBOX
		 *	CAPTURAR ID_PARALELO (FRONT)
		 *	BUSCAR ASIGNATURAS QUE PERTENECEN UNICAMENTE A ESE PARALELO (CONSULTA BD)
		 *	LISTAR ASIGNATURAS EN COMBO BOX
		 *5)LISTA ASIGNATURA EN EL COMBO BOX
		 *	CAPTURAR EL ID_ASIGNATURA (FRONTEND)
		 *	BUSCAR ESTUDIANTES QUE PERTENECEN UNICAMENTE A ESA ASIGNATURA O CURSO (CONSULTA BD)
		 *6)LISTA LOS ESTUDIANTES QUE PERTENECEN A LA ASIGNATURA O CURSO (CONSULTA BD)
		 *	REGISTRO DE NOTAS DE CADA ESTUDIANTE
		 *7)EVENTO GUARDAR
		 *	CAPTURAR LOS APORTES
		 *	¿COMO CAPTURAR EL ID_MATRICULA?
		 *		CAPTURAR EL ID_ESTUDIANTE EN LA TABLA (FRONTEND)
		 *		CON EL ID_ESTUDIANTE, BUSCAMOS EN MATRICULA Y CAPTURAMOS EL ID_MATRICULA (CONSULTA BD)
		 *		GUARDAR EN UNA VARIABLE EL ID_MATRICULA CAPTURADA (FRONTEND)
		 *	GUARDAR EN UNA VARIABLE EL ID_ASIGNATURA DEL 5.1 
		 *8)CAPTURAR APORTES, ID_MATRICULA, ID_ASIGNATURA Y GUARDAR EN REGISTRO
		 * 
*/
}

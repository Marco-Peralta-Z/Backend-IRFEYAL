package com.irfeyal.servicio.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.irfeyal.interfaces.asistencia.IAsistenciaService;
import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.dao.asistencia.IAsistenciaDao;
import com.irfeyal.modelo.dao.asistencia.IClaseDao;
import com.irfeyal.modelo.dao.matricula.IEstudianteDao;
import com.irfeyal.modelo.dao.rolseguridad.PersonaDAO;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.rolseguridad.Persona;

public class AsistenciaServiceImpl implements IAsistenciaService{
	
	@Autowired
	private IAsistenciaDao asistenciadao;
	@Autowired
	private PersonaDAO personadao;
	@Autowired
	private IEstudianteDao estudiantedao;
	@Autowired
	private IClaseDao clasedao;
	

	@Override
	public List<Asistencia> findAll() {
		// TODO Auto-generated method stub
		return (List<Asistencia>) asistenciadao.findAll();
	}

	@Override
	public Asistencia findById(Long id) {
		// TODO Auto-generated method stub
		return asistenciadao.findById(id).orElse(null);
	}

	@Override
	public Asistencia save(Asistencia asistencia) {
		// TODO Auto-generated method stub
		return asistenciadao.save(asistencia);
	}

	@Override
	public void delete(Long id) {
		asistenciadao.deleteById(id);
		
	}
	
	@Override
	public List <Persona> buscarcurso(Long id) {
			// TODO Auto-generated method stub
		return null; //personadao.buscarcurso(id);
	}

	@Override
	public List<Estudiante> buscarcursomodalidad(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura) {
		
		
			if ( id_periodo==0 && id_paralelo==0 && id_asignatura==0) {
				return estudiantedao.buscarcursomodalidad(id_mod);
				
			}else {
				if ( id_mod==0 && id_paralelo==0 && id_asignatura==0) {
					return estudiantedao.buscarcursoperiodo(id_periodo);
					
				}else {
					if ( id_mod==0 && id_periodo==0 && id_asignatura==0) {
						return estudiantedao.buscarcursoparalelo(id_paralelo);
						
					}else {
						if ( id_mod==0 && id_periodo==0 && id_paralelo==0 ) {
							return estudiantedao.buscarcursoasignatura(id_asignatura);
							
						}else {
							
							
							if (id_asignatura==0 && id_paralelo==0) {
								return estudiantedao.buscarcursomodperi(id_mod, id_periodo);
							}else {
								if (id_mod==0 && id_periodo==0) {
									return estudiantedao.buscarcursoparasig(id_paralelo, id_asignatura);
								}else {
									if (id_mod==0 && id_asignatura==0) {
										return estudiantedao.buscarcursoperipar(id_periodo, id_paralelo);
									}else {
										if (id_mod==0 && id_paralelo==0) {
											return estudiantedao.buscarcursoperiasig(id_periodo, id_asignatura);
										}else {
											if (id_periodo==0 && id_paralelo==0) {
												return estudiantedao.buscarcursomodasig(id_mod, id_asignatura);
											}else {
												if (id_periodo==0 && id_asignatura==0) {
													return estudiantedao.buscarcursomodpar(id_mod, id_paralelo);
												}else {
													
													
													if (id_asignatura==0 ) {
														return estudiantedao.buscarcursomodperpar(id_mod, id_periodo,id_paralelo);
													}else {
														if (id_paralelo==0 ) {
															return estudiantedao.buscarcursomodpersig(id_mod, id_periodo,id_asignatura);
														}else {
															if (id_periodo==0 ) {
																return estudiantedao.buscarcursomodparasig(id_mod, id_paralelo,id_asignatura);
															}else {
																if (id_mod==0 ) {
																	return estudiantedao.buscarcursoperparasig( id_periodo,id_paralelo,id_asignatura);
																}else {
																	 return estudiantedao.buscarcursomodalidad(id_mod, id_periodo, id_paralelo, id_asignatura);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

   }

	@Override
	public Estudiante buscarceduestudiante(String cedula) {
		
		return estudiantedao.buscarcedulaestudiante(cedula);
	}

	@Override
	public List<Modalidad> modalidaddocente(Integer id_docente) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

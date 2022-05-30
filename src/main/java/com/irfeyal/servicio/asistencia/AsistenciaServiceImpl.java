package com.irfeyal.servicio.asistencia;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.asistencia.IAsistenciaService;
import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.dao.asistencia.IAsistenciaDao;
import com.irfeyal.modelo.dao.asistencia.IClaseDao;
import com.irfeyal.modelo.dao.matricula.IEstudianteDao;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.rolseguridad.PersonaDAO;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Persona;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService{
	
	@Autowired
	private IAsistenciaDao asistenciadao;
	@Autowired
	private PersonaDAO personadao;
	@Autowired
	private IEstudianteDao estudiantedao;
	@Autowired
	private IClaseDao clasedao;
	
	@Autowired
	private ParaleloRespository paralelo;

	@Autowired
	private PeriodoRepository periodo;
	@Autowired
	private ModalidadRepository modalidad;
	@Autowired
	private AsignaturaRepository asignatura;
	
	@Autowired
	private CursoRepository curso;
	
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
		return personadao.buscarcurso(id);
	}

	@Override
	public List<Estudiante> buscarcursomodalidad(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura ,Long id_curs) {
		
				
			if ( id_periodo==0 && id_paralelo==0 && id_asignatura==0 && id_curs==0) {
				return estudiantedao.buscarcursomodalidad(id_mod);
			}else {
				if ( id_mod==0 && id_paralelo==0 && id_asignatura==0 && id_curs==0) {
					return estudiantedao.buscarcursoperiodo(id_periodo);	
				}else {
					if ( id_mod==0 && id_periodo==0 && id_asignatura==0 && id_curs==0) {
						return estudiantedao.buscarcursoparalelo(id_paralelo);	
					}else {
						if ( id_mod==0 && id_periodo==0 && id_paralelo==0 && id_curs==0) {
							return estudiantedao.buscarcursoasignatura(id_asignatura);	
						}else {
							if ( id_mod==0 && id_periodo==0 && id_paralelo==0 && id_asignatura==0) {
								return estudiantedao.buscarcursocurso(id_curs);	
						    }else {
							
							
							if (id_asignatura==0 && id_paralelo==0 && id_curs==0) {
								return estudiantedao.buscarcursomodperi(id_mod, id_periodo);
							}else {
								if (id_mod==0 && id_periodo==0 && id_curs==0) {
									return estudiantedao.buscarcursoparasig(id_paralelo, id_asignatura);
								}else {
									if (id_mod==0 && id_asignatura==0 && id_curs==0) {
										return estudiantedao.buscarcursoperipar(id_periodo, id_paralelo);
									}else {
										if (id_mod==0 && id_paralelo==0 && id_curs==0) {
											return estudiantedao.buscarcursoperiasig(id_periodo, id_asignatura);
										}else {
											if (id_periodo==0 && id_paralelo==0 && id_curs==0) {
												return estudiantedao.buscarcursomodasig(id_mod, id_asignatura);
											}else {
												if (id_periodo==0 && id_asignatura==0 && id_curs==0) {
													return estudiantedao.buscarcursomodpar(id_mod, id_paralelo);
												}else {
													if (id_periodo==0 && id_paralelo==0 && id_asignatura==0) {
														return estudiantedao.buscarcursomodcur(id_mod, id_curs);
													}else {
														if (id_mod==0 && id_paralelo==0 && id_asignatura==0) {
															return estudiantedao.buscarcursopericur(id_periodo, id_curs);
														}else {
															if (id_mod==0 && id_periodo==0 && id_asignatura==0) {
																return estudiantedao.buscarcursoparcur(id_paralelo, id_curs);
															}else {
																if (id_mod==0 && id_periodo==0 && id_paralelo==0) {
																	return estudiantedao.buscarcursoasigcur(id_asignatura, id_curs);
																}else {
																
																	
																	if (id_asignatura==0 && id_curs==0) {
																		return estudiantedao.buscarcursomodperpar(id_mod, id_periodo,id_paralelo);
																	}else {
																		if (id_paralelo==0 && id_curs==0) {
																			return estudiantedao.buscarcursomodperasig(id_mod, id_periodo,id_asignatura);
																		}else {
																			if (id_paralelo==0 && id_asignatura==0) {
																				return estudiantedao.buscarcursomodpercur(id_mod, id_periodo,id_curs);
																			}else {
																				if (id_periodo==0 && id_curs==0) {
																					return estudiantedao.buscarcursomodparasig(id_mod, id_paralelo,id_asignatura);
																				}else {
																					if (id_periodo==0 && id_asignatura==0) {
																						return estudiantedao.buscarcursomodparcur(id_mod, id_paralelo,id_curs);
																					}else {
																						if (id_periodo==0 && id_paralelo==0) {
																							return estudiantedao.buscarcursomodasigcur(id_mod, id_asignatura,id_curs);
																						}else {
																							if (id_mod==0 && id_curs==0) {
																								return estudiantedao.buscarcursoperparasig(id_periodo, id_paralelo,id_asignatura);
																							}else {
																								if (id_mod==0 && id_asignatura==0) {
																									return estudiantedao.buscarcursoperparcur(id_periodo, id_paralelo,id_curs);
																								}else {
																									if (id_mod==0 && id_paralelo==0) {
																										return estudiantedao.buscarcursoperasigcur(id_periodo, id_asignatura,id_curs);
																									}else {
																										if (id_mod==0 && id_periodo==0) {
																											return estudiantedao.buscarcursoparasigcur(id_paralelo, id_asignatura,id_curs);
																										}else {
																			
																											
													if (id_asignatura==0 ) {
														return estudiantedao.buscarcursomodperparcur(id_mod, id_periodo,id_paralelo,id_curs);
													}else {
														if (id_paralelo==0 ) {
															return estudiantedao.buscarcursomodperasigcur(id_mod, id_periodo,id_asignatura,id_curs);
														}else {
															if (id_periodo==0 ) {
																return estudiantedao.buscarcursomodparasigcur(id_mod, id_paralelo,id_asignatura,id_curs);
															}else {
																if (id_mod==0 ) {
																	return estudiantedao.buscarcursoperparasigcur( id_periodo,id_paralelo,id_asignatura,id_curs);
																}else {
																	if (id_curs==0 ) {
																		return estudiantedao.buscarcursomodperparasig( id_mod,id_periodo,id_paralelo,id_asignatura);
																	}else {
																	 return estudiantedao.buscarcursotodofil(id_mod, id_periodo, id_paralelo, id_asignatura, id_curs);
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
	                              }
                                }
                              }
			                }
					      }			
						}}}}}}}}}}
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

	@Override
	public List<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignatura.findAll();
	}

	@Override
	public List<Paralelo> findAllParalelo() {
		// TODO Auto-generated method stub
		return paralelo.findAll();
	}

	@Override
	public List<Modalidad> findAllModalidad() {
		// TODO Auto-generated method stub
		return modalidad.findAll();
	}

	@Override
	public List<Periodo> findAllperio() {
		// TODO Auto-generated method stub
		return periodo.findAll();
	}

	@Override
	public List<Curso> findAllcurso() {
		// TODO Auto-generated method stub
		return curso.findAll();
	}

	@Override

	public List<Asistencia> burcarasistencia(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,
			Long id_curso, Date fecha) {
		// TODO Auto-generated method stub
		return asistenciadao.buscarasistencia(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, fecha);
	}

	@Override
	public List<Estudiante> mostrarinformacion(long id) {
		// TODO Auto-generated method stub
		return estudiantedao.findestudianteid(id);
	}

	@Override
	public List<Periodo> listarpaeriodo(Long empleado) {
		// TODO Auto-generated method stub
		return periodo.listarperiodoasistencia(empleado);
	}

	@Override
	public List<Modalidad> listarmodalidad(Long emplead, Long idperiodo) {
		// TODO Auto-generated method stub
		return modalidad.listarmodalidadasistencia(emplead, idperiodo);
	}

	@Override
	public List<Curso> listarcurso(Long emplead, Long periodo, Long idmodalidad) {
		// TODO Auto-generated method stub
		return curso.listarcursoasistencia(emplead,periodo, idmodalidad);
	}

	@Override
	public List<Paralelo> listarparalelo(Long emple,Long periodo,Long modalidad, Long idcurso) {
		// TODO Auto-generated method stub
		return paralelo.listarparaleloasistencia(emple,periodo,modalidad, idcurso);
	}

	@Override
	public List<Asignatura> listarasignatura(Long empelado, Long idperiodo, Long modalidad, Long idcurso, Long idparalelo) {
		// TODO Auto-generated method stub
		return asignatura.listarasignaturaasistencia(empelado, idperiodo,modalidad, idcurso, idparalelo);
		
	}

	public List<Asistencia> actualizarfiltros(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,
			Long id_curso, Date fecha) {
		// TODO Auto-generated method stub
		return asistenciadao.actualizarfiltros(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, fecha);
	}

	
	

}

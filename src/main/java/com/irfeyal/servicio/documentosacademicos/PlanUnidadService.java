package com.irfeyal.servicio.documentosacademicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irfeyal.interfaces.documentosacademicos.PlanUnidadInterface;
import com.irfeyal.modelo.dao.documentosacademicos.PlanUnidadDAO;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.EmpleadoRepository;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.modelo.rolseguridad.Usuario;

@Service
public class PlanUnidadService implements PlanUnidadInterface {
	
	@Autowired
	private PlanUnidadDAO planUnidadDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	//Listar planes de unidad
	@Override
	public List<PlanUnidad> findAll() {
		return planUnidadDAO.findAll();
	}
	
    //Buscar usuario por id
	public Optional<Usuario> findUsuario (Long id){
		return usuarioDAO.findById(id);
	}
	
	//listar Planes de unidad por estado
	public List<PlanUnidad> findAllByEstado (String est){
		List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
		List<PlanUnidad> planunidades = planUnidadDAO.findAll();
		for (int i=0; i<planunidades.size(); i++) {
			if (planunidades.get(i).getEstado().equals(est)) {
				planunidadesRespuesta.add(planunidades.get(i));
			} 
		}
		return planunidadesRespuesta;
	}
	
	//listar Planes de unidad por Empleado y estado
		public List<PlanUnidad> findAllByEmpleado (Long id, String est){
			List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
			List<PlanUnidad> planunidades = planUnidadDAO.findAll();
			for (int i=0; i<planunidades.size(); i++) {
				if (planunidades.get(i).getEmpleado().getId_empleado() == id && planunidades.get(i).getEstado().equals(est)) {
					planunidadesRespuesta.add(planunidades.get(i));
				} 
			}
			return planunidadesRespuesta;
		}
		
		/*Buscar Plan de unidad por Unidad, asignatura, curso y modalidad 
		(Controlar la ceracion del Plan de Unidad con el mismo No de unidad)*/
		public boolean findPUByUnidadAsigCurso (Long id_u, Long id_a, Long id_c, Long id_m){
			List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
			List<PlanUnidad> planunidades = planUnidadDAO.findAll();
			boolean existe = false;
			for (int i=0; i<planunidades.size(); i++) {
				if ((planunidades.get(i).getUnidad().getIdUnidad() == id_u) &&
					(planunidades.get(i).getAsignatura().getId_asignatura() == id_a) &&
					(planunidades.get(i).getCurso().getId_curso() == id_c) &&
					(planunidades.get(i).getModalidad().getId_modalidad() == id_m)) {
					planunidadesRespuesta.add(planunidades.get(i));
				} 
			}
			if (planunidadesRespuesta.size() == 0) {
			    existe = false;
			} else {
				existe = true;
			}
			return existe; 
		}	
	
	//listar Asignaturas por Malla
		public List<Asignatura> findAllByMalla (Long id){
			List<Asignatura> AsigRespuesta = new ArrayList<>();
			List<Asignatura> asignaturas = asignaturaRepository.findAll();
			for (int i=0; i<asignaturas.size(); i++) {
				long id_malla = asignaturas.get(i).getMallas().get(0).getId_malla();
				if ( id_malla == id) {
					AsigRespuesta.add(asignaturas.get(i));
				}
			}
			return AsigRespuesta;
		}
		
	//Update Plan de Unidad
	public  PlanUnidad  updatePlanUnidad ( Long  id , PlanUnidad  planUnidad ) {
		planUnidad.setId_plan_unidad(id);
	       return planUnidadDAO.save(planUnidad);
	}

	//Save Plan de unidad
	@Override
	public <S extends PlanUnidad> S save(S entity) {
		return planUnidadDAO.save(entity);
	}

	//Encontrar plan de unidad por Id
	@Override
	public Optional<PlanUnidad> findById(Long id) {
		return planUnidadDAO.findById(id);
	}

	//Delete plan de unidad
	@Override
	public void deleteById(Long id) {
		planUnidadDAO.deleteById(id);
	}

}

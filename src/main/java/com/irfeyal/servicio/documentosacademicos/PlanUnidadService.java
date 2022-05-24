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
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Service
public class PlanUnidadService implements PlanUnidadInterface {
	
	@Autowired
	private PlanUnidadDAO planUnidadDAO;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	//Listar planes de unidad
	@Override
	public List<PlanUnidad> findAll() {
		return planUnidadDAO.findAll();
	}
	
    //Buscar empleado por id
	public List<Empleado> findEmpleado (Long id){
		List<Empleado> EmpleadoRespuesta = new ArrayList<>();
		List<Empleado> empleados = empleadoRepository.findAll();
		for (int i=0; i<empleados.size(); i++) {
			if ( empleados.get(i).getPersona().getid_persona() == id) {
				EmpleadoRespuesta.add(empleados.get(i));
			}
		}
		return EmpleadoRespuesta;
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
	
	//listar Planes de unidad por Empleado
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

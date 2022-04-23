package com.irfeyal.interfaces.documentosacademicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.irfeyal.modelo.documentosacademicos.PlanUnidad;

@Service
public interface PlanUnidadInterface {
	public List<PlanUnidad> findAll();
	
	public List<PlanUnidad> findAllByEstado (String est);
	
	public  PlanUnidad  updatePlanUnidad ( Long  id , PlanUnidad  planUnidad );
	
	public <S extends PlanUnidad> S save(S entity);
	
	public Optional<PlanUnidad> findById(Long id);
	
	public void deleteById(Long id);
}

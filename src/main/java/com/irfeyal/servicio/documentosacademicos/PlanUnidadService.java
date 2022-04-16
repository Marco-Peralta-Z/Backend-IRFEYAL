package com.irfeyal.servicio.documentosacademicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.dao.documentosacademicos.PlanUnidadDAO;
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;

@Service
public class PlanUnidadService implements PlanUnidadDAO {
	
	@Autowired
	private PlanUnidadDAO planUnidadDAO;
	

	@Override
	public List<PlanUnidad> findAll() {
		return planUnidadDAO.findAll();
	}
	
	//listar-Planes-de-unidad-por-estado
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
		
	//Update Plan de Unidad
	public  PlanUnidad  updatePlanUnidad ( Long  id , PlanUnidad  planUnidad ) {
		planUnidad.setIdPlanUnidad(id);
	       return planUnidadDAO.save(planUnidad);
	}

	@Override
	public List<PlanUnidad> findAll(Sort sort) {
		return planUnidadDAO.findAll(sort);
	}

	@Override
	public List<PlanUnidad> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends PlanUnidad> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<PlanUnidad> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlanUnidad getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanUnidad getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PlanUnidad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> S save(S entity) {
		return planUnidadDAO.save(entity);
	}

	@Override
	public Optional<PlanUnidad> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		planUnidadDAO.deleteById(id);
	}

	@Override
	public void delete(PlanUnidad entity) {
		planUnidadDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends PlanUnidad> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends PlanUnidad> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PlanUnidad> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends PlanUnidad> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends PlanUnidad, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}

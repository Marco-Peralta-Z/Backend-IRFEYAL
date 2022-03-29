package com.example.demo.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Empleado;

public interface EmpleadoDAO extends CrudRepository<Empleado, Long>{
	Page<Empleado> findAll(Pageable pageable);
}

package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Empresa;



public interface EmpresaDAO extends CrudRepository<Empresa, Integer> {

}

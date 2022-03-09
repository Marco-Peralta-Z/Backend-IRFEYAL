package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona	, Long>{

}

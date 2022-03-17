package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Persona;

public interface PersonaDAO extends CrudRepository<Persona, Integer> {

}

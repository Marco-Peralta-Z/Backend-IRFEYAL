package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Asistencia;


public interface IAsistenciaDao extends CrudRepository<Asistencia, Long> {

}

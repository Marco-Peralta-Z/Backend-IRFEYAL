package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.entity.Telefono;

public interface TelefonoDAO extends CrudRepository<Telefono, Integer> {

}

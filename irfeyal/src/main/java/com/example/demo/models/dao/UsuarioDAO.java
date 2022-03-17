package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

}

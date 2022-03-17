package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Extension;


public interface ExtensionDAO extends CrudRepository<Extension, Integer> {

}

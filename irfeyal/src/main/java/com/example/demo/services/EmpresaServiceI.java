package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Empresa;


public interface EmpresaServiceI {


	public List<Empresa> findAll();
    public Empresa  saveEmpresa(Empresa empresa);
    public Empresa findById(Long id);
    public List<Empresa> deleteEmpresa();
    public List<Empresa> updateEmpresa();
}

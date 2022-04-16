package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Empresa;


public interface EmpresaInterface {


	public List<Empresa> findAll();
    public Empresa  saveEmpresa(Empresa empresa);
    public Empresa findById(Long id);
      public List<Empresa> updateEmpresa();
	public void deleteEmpresa (Long id);
    
    
}

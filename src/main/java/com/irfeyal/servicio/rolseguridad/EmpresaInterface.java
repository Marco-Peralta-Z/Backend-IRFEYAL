package com.irfeyal.servicio.rolseguridad;

import java.util.List;



import com.irfeyal.modelo.rolseguridad.Empresa;



public interface EmpresaInterface {


	public List<Empresa> findAll();
    public Empresa  saveEmpresa(Empresa empresa);
    public Empresa findById(Long id);
    public List<Empresa> deleteEmpresa();
    public List<Empresa> updateEmpresa();
    
    
}

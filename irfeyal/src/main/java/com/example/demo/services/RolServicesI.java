package com.example.demo.services;

import java.util.List;


import com.example.demo.models.entity.Rol;

public interface RolServicesI {

	public List<Rol> findAll();
    public List<Rol> saveRol();
    public List<Rol> deleteRol();
    public List<Rol> updateRol();

}

package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.entity.Telefono;

public interface TelefonoServicesI {


	public List<Telefono> findAll();
    public List<Telefono> saveTelefono();
    public List<Telefono> deleteTelefono();
    public List<Telefono> updateTelefono();
}

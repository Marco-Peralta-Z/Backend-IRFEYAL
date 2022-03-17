package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.CorreoElectronico;



public interface CorreoElectronicoServicesI {
	@Autowired

	public List<CorreoElectronico> findAll();
    public List<CorreoElectronico> saveCorreoElectronico();
    public List<CorreoElectronico> deleteCorreoElectronico();
    public List<CorreoElectronico> updateCorreoElectronico();

}

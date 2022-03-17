package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.CorreoElectronicoDAO;

import com.example.demo.models.entity.CorreoElectronico;


@Service
public class CorreoElectronicoServices implements CorreoElectronicoServicesI{
	
	@Autowired
	  private CorreoElectronicoDAO correodao;

	@Override
	public List<CorreoElectronico> findAll() {
		// TODO Auto-generated method stub
		return (List<CorreoElectronico> ) correodao.findAll();
	}

	@Override
	public List<CorreoElectronico> saveCorreoElectronico() {
		// TODO Auto-generated method stub
		return (List<CorreoElectronico> ) correodao.findAll();
	}

	@Override
	public List<CorreoElectronico> deleteCorreoElectronico() {
		// TODO Auto-generated method stub
		return (List<CorreoElectronico> ) correodao.findAll();
	}

	@Override
	public List<CorreoElectronico> updateCorreoElectronico() {
		// TODO Auto-generated method stub
		return (List<CorreoElectronico> ) correodao.findAll();
	}
	  
	
	
	

}

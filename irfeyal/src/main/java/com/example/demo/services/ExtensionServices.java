package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ExtensionDAO;
import com.example.demo.models.entity.Extension;

@Service
public class ExtensionServices implements ExtensionServicesI {

	@Autowired
	  private ExtensionDAO extension;
	  
	
	
	@Override
	public List<Extension> findAll() {
		// TODO Auto-generated method stub
		return (List<Extension> ) extension.findAll();
	}

	@Override
	public List<Extension> saveExtension() {
		// TODO Auto-generated method stub
		return (List<Extension> ) extension.findAll();
	}

	@Override
	public List<Extension> deleteExtension() {
		// TODO Auto-generated method stub
		return (List<Extension> ) extension.findAll();
	}

	@Override
	public List<Extension> updateExtension() {
		// TODO Auto-generated method stub
		return (List<Extension> ) extension.findAll();
	}

}

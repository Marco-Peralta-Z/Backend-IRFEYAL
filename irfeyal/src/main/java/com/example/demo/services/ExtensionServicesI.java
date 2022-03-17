package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Extension;


public interface ExtensionServicesI {
	@Autowired

	public List<Extension> findAll();
    public List<Extension> saveExtension();
    public List<Extension> deleteExtension();
    public List<Extension> updateExtension();
}

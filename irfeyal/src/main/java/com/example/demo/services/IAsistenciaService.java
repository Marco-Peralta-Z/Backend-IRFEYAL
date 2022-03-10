package com.example.demo.service;

import java.util.List;


import com.example.demo.models.entity.Asistencia;

public interface IAsistenciaService {
	public List<Asistencia> findAll();
	public Asistencia findById(Long id);
	public Asistencia save(Asistencia asistencia);
	public void delete(Long id);
	
}

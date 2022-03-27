package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Usuario;

@Repository
public interface UsuarioServicesI extends JpaRepository<Usuario, Integer>{
	
@Query (value="SELECT * FROM usuario WHERE usuario=?1 AND contrasenia=?2", nativeQuery = true) 
 Usuario login (String usuario, String contrasenia);

}

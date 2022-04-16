package com.irfeyal.servicio.rolseguridad;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.UsuarioInterface;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.rolseguridad.Usuario;

@Service
public class UsuarioServices implements UsuarioInterface{

	@Autowired
	  private UsuarioDAO usuariodao;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return(List<Usuario>) usuariodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuariodao.findAll(pageable);
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id).orElse(null);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariodao.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		usuariodao.deleteById(id);
	}

	
	
	


}

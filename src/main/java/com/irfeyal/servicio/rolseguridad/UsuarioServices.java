package com.irfeyal.servicio.rolseguridad;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.UsuarioInterface;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.rolseguridad.Usuario;

@Service
public class UsuarioServices implements UsuarioInterface, UserDetailsService {

	@Autowired (required = true)
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

	@Override
	public List<Usuario> listAllUsuario() {
		return (List<Usuario>) usuariodao.findAll();
	}

	@Override
	public Usuario Login(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		//return usuariodao.login(usuario, contrasena);
		return null;
	}

	@Override
	public Usuario update(Long id_usuario, double nuevaAprobacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Method for security back-end
	 * */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuariodao.findByUsuario(username);
		
		if ( usuario == null ) {
			System.out.println("=======> Error en el login : No existe el usuario: "+ username + " en el sistema.");
			throw new UsernameNotFoundException("Error en el login : No existe el usuario: "+ username + " en el sistema.");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(rolUsuario -> new SimpleGrantedAuthority( rolUsuario.getRol().getDescripcion() ))
				.peek(rol -> System.out.print(" ==========> Rol: "+rol))
				.collect( Collectors.toList() );
		return new User(usuario.getUsuario(), usuario.getContrasenia(), usuario.getEstUsuario(), true, true, true, authorities);
	}



}

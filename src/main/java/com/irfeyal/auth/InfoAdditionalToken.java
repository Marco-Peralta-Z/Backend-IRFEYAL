package com.irfeyal.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.irfeyal.interfaces.rolseguridad.UsuarioInterface;
import com.irfeyal.modelo.rolseguridad.Usuario;

/*
 * 
 * Agregar informacion adicional al token
 * 
 * */

@Component
public class InfoAdditionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioInterface usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		// buscar por usuario "cedula" en este caso
		Usuario usuario = usuarioService.findByUsuario(authentication.getName());
		
		// Hasmap para pasar informacion adicional al token
		Map<String, Object> info = new HashMap<>();
		info.put("id", usuario.getId_usuario());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	
}

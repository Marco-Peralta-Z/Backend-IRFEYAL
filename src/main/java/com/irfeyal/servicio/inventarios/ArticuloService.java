package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.ArticuloInterface;
import com.irfeyal.modelo.dao.inventarios.ArticuloDao;
import com.irfeyal.modelo.inventarios.Articulo;

@Service // ("IAutoServiceImplement")
@Transactional
public class ArticuloService implements ArticuloInterface {
	
	@Autowired
	private ArticuloDao articuloDao;
	
	@Override
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Articulo> listAllArticulo() {
		// TODO Auto-generated method stub
		return (List<Articulo>) articuloDao.findAll();
	}

	@Override
	public Optional<Articulo> getById(Long id_articulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo update(Long id_articulo, double nuevoArticulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id_articulo) {
		// TODO Auto-generated method stub
		return false;
	}

}

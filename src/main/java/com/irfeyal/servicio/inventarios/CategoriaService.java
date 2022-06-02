package com.irfeyal.servicio.inventarios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.inventarios.CategoriaInterface;
import com.irfeyal.modelo.dao.inventarios.CategoriaDao;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.ModuloLibro;

@Service // ("IAutoServiceImplement")
@Transactional
public class CategoriaService implements CategoriaInterface {

	@Autowired
	CategoriaDao categoriaDao;

	@Override
	public Categoria save(Categoria categoria) {
		boolean validar = validarCategoria(categoria);
		if( validar = true) {
			return categoriaDao.save(categoria);
		}else {
			return null;
		}
	}

	@Override
	public List<Categoria> listAllCategoria() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	public Optional<Categoria> getById(Long id_categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(id_categoria);
	}

	@Override
	public Categoria update(Long id_categoria, double nuevaCategoria) {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean validarCategoria(Categoria categoria) {
		if (categoria.getCatedescri() != null
				&& categoria.getCatenombre() != null) {
			return true;
		}else {
			return false;
		}

		
	}


	@Override
	public Categoria delete(Long idCategoria) {
		Categoria moduloL = getById(idCategoria).get();
		if(moduloL == null) {
			return null;
		}else {
			categoriaDao.deleteById(idCategoria);
			return moduloL;
			
		}
	}

}

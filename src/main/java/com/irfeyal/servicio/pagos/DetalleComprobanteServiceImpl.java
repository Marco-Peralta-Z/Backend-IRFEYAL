package com.irfeyal.servicio.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.pagos.IDetalleComprobanteService;
import com.irfeyal.modelo.dao.pagos.IDetalleComprobanteDao;
import com.irfeyal.modelo.pagos.DetalleComprobante;

@Service
public class DetalleComprobanteServiceImpl implements IDetalleComprobanteService{

	@Autowired
	private IDetalleComprobanteDao detalleComprobanteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleComprobante> findAll() {
		
		return (List<DetalleComprobante>) detalleComprobanteDao.findAll();
	}

	@Override
	public Page<DetalleComprobante> findAll(Pageable pageable) {
		
		return detalleComprobanteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleComprobante findById(Long id) {
		
		return detalleComprobanteDao.findById(id).orElse(null);
	}

	@Override
	public DetalleComprobante save(DetalleComprobante detalleComprobante) {
		
		return detalleComprobanteDao.save(detalleComprobante);
	}

	@Override
	public void delete(Long id) {
		detalleComprobanteDao.deleteById(id);
		
	}

	@Override
	public List<DetalleComprobante> findByCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		return detalleComprobanteDao.findByCedulaEstudiante(cedula);
	}

}

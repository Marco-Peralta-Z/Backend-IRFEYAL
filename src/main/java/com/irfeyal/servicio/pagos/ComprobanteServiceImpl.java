package com.irfeyal.servicio.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.pagos.IComprobanteService;
import com.irfeyal.modelo.dao.pagos.IComprobanteDao;
import com.irfeyal.modelo.pagos.Comprobante;

@Service
public class ComprobanteServiceImpl implements IComprobanteService{

	@Autowired
	IComprobanteDao comprobanteDato;
	
	@Override
	@Transactional(readOnly = true)
	public List<Comprobante> findAll() {
		
		return (List<Comprobante>) comprobanteDato.findAll();
	}

	@Override
	public Page<Comprobante> findAll(Pageable pageable) {
		
		return comprobanteDato.findAll(pageable);
	}

	@Override
	public Comprobante findById(Long id) {
		
		return comprobanteDato.findById(id).orElse(null);
	}


	@Override
	public Comprobante save(Comprobante comprobante) {
		
		return comprobanteDato.save(comprobante);
	}

	@Override
	public void delete(Long id) {
		comprobanteDato.deleteById(id);
		
	}

	@Override
	public Comprobante buscarPorEstadoAndMatriculaAndTipocomprobante(boolean estado, Long idMatricula,
			Long idConceptoPago) {
		return comprobanteDato.buscarPorEstadoAndMatriculaAndTipocomprobante(estado, idMatricula, idConceptoPago);
	}

	
}

package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Paralelo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParaleloServices {

	public List<Paralelo> getAllParalelo();

	public Page<Paralelo> getAllParalelo(Pageable pageable);

	public Optional<Paralelo> getParaleloById(Long idParalelo);

	public Paralelo saveParalelo(Paralelo paralelo);

	public Paralelo deleteParalelo(Long idParalelo);

}

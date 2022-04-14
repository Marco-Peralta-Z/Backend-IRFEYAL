package com.irfeyal.interfaces.parametrizacionacademica;

import java.util.List;
import java.util.Optional;

import com.irfeyal.modelo.parametrizacionacademica.Horario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HorarioServices {

	public List<Horario> getAllHorario();

	public Page<Horario> getAllHorario(Pageable pageable);

	public Optional<Horario> getHorarioById(Long idHorario);

	public Horario saveHorario(Horario horario);

	public Horario deleteHorario(Long idHorario);

}

package com.irfeyal.modelo.inventarios;

import com.irfeyal.modelo.matricula.Estudiante;


public class TempPagoKit {
	Long id_estudiante;
	Float valor_total;
	Estudiante estudiante;
	
	
	public TempPagoKit() {
		super();
	}


	public Long getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Float getValor_total() {
		return valor_total;
	}

	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}

	
	
	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	@Override
	public String toString() {
		return "TempPagoKit [id_estudiante=" + id_estudiante + ", valor_total=" + valor_total + "]";
	}
	
	
	
}

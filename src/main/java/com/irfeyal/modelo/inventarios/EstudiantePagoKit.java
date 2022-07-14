package com.irfeyal.modelo.inventarios;

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

public class EstudiantePagoKit {
	
	private Integer idEstudiante;

	private String conceptoPago;
	
	private Integer idKit;
	
	private float valorPagado;
	
	private Estudiante estudiante;

	private Kit kit;
	
	private boolean estadoAprobacion;
	
	public EstudiantePagoKit() {
		super();
	}






	public EstudiantePagoKit(Integer idEstudiante, String conceptoPago, Integer idKit, float valorPagado,
			Estudiante estudiante, Kit kit, boolean estadoAprobacion) {
		super();
		this.idEstudiante = idEstudiante;
		this.conceptoPago = conceptoPago;
		this.idKit = idKit;
		this.valorPagado = valorPagado;
		this.estudiante = estudiante;
		this.kit = kit;
		this.estadoAprobacion = estadoAprobacion;
	}


	public boolean isEstadoAprobacion() {
		return estadoAprobacion;
	}

	public void setEstadoAprobacion(boolean estadoAprobacion) {
		this.estadoAprobacion = estadoAprobacion;
	}
	
	public Integer getIdEstudiante() {
		return idEstudiante;
	}


	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}


	public String getConceptoPago() {
		return conceptoPago;
	}


	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
	}


	public Integer getIdKit() {
		return idKit;
	}


	public void setIdKit(Integer idKit) {
		this.idKit = idKit;
	}


	public float getValorPagado() {
		return valorPagado;
	}


	public void setValorPagado(float valorPagado) {
		this.valorPagado = valorPagado;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}




	public Kit getKit() {
		return kit;
	}




	public void setKit(Kit kit) {
		this.kit = kit;
	}

	
	
	
}

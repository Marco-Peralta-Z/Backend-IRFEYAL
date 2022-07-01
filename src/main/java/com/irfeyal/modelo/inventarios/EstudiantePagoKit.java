package com.irfeyal.modelo.inventarios;

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

public class EstudiantePagoKit {

	private long idComprobante;
	
	private String conceptoPago;
	
	private float valorPagado;
	
	private Estudiante estudiante;
	
	private Periodo periodo;
	
	private Kit kit;

	public EstudiantePagoKit() {
		super();
	}

	public EstudiantePagoKit(long idComprobante, String conceptoPago, float valorPagado, Estudiante estudiante,
			Periodo periodo, Kit kit) {
		super();
		this.idComprobante = idComprobante;
		this.conceptoPago = conceptoPago;
		this.valorPagado = valorPagado;
		this.estudiante = estudiante;
		this.periodo = periodo;
		this.kit = kit;
	}

	public long getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(long idComprobante) {
		this.idComprobante = idComprobante;
	}

	public String getConceptoPago() {
		return conceptoPago;
	}

	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
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

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	@Override
	public String toString() {
		return "EstudiantePagoKit [idComprobante=" + idComprobante + ", conceptoPago=" + conceptoPago + ", valorPagado="
				+ valorPagado + ", estudiante=" + estudiante + ", periodo=" + periodo + ", kit=" + kit + "]";
	}

	
	
	
	
	
	
	
	
}

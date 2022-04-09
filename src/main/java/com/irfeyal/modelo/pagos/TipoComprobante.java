package com.irfeyal.modelo.pagos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

@Entity
@Table(name = "tipo_comprobante")
public class TipoComprobante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_comprobante")
	private Long id_tipo_comprobante;

	@Column
	private String concepto_pago;

	@OneToOne
	@JoinColumn(name = "id_periodo")
	private Periodo id_periodo;

	@OneToOne
	@JoinColumn(name = "id_kit")
	private Kit id_kit;

	public TipoComprobante() {

	}

	public TipoComprobante(Long id_tipo_comprobante, String concepto_pago, Periodo id_periodo, Kit id_kit) {
		super();
		this.id_tipo_comprobante = id_tipo_comprobante;
		this.concepto_pago = concepto_pago;
		this.id_periodo = id_periodo;
		this.id_kit = id_kit;
	}

	public Long getIdTipoComprobante() {
		return id_tipo_comprobante;
	}

	public void setIdTipoComprobante(Long id_tipo_comprobante) {
		this.id_tipo_comprobante = id_tipo_comprobante;
	}

	public String getConcepto_pago() {
		return concepto_pago;
	}

	public void setConcepto_pago(String concepto_pago) {
		this.concepto_pago = concepto_pago;
	}

	public Kit getKit() {
		return id_kit;
	}

	public void setKit(Kit id_kit) {
		
		this.id_kit = id_kit;
	}

	public Periodo getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Periodo id_periodo) {
		this.id_periodo = id_periodo;
	}

}
package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.irfeyal.modelo.rolseguridad.Empleado;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "aprobacion")
public class Aprobacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aprobacion")
	private Long id_aprobacion;
    
    @Column(name = "tipo_aproba")
    private String tipoAprobacion;
    
    @Column(name = "id_tipo_aprobacion")
    private Long idTipoAprobacion;
    
        
    @Column(name = "estado_aproba")
    private Boolean estadoAproba;
    
    @Column(name = "detalle_control")
    private String detalleControl;
    
    
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    
    @Column(name = "fecha_control")
    @Temporal(TemporalType.DATE)
    private Date fechaControl;
    
    @JoinColumn(name = "id_secretaria", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado secretaria;

    public Aprobacion() {
    }
    

	public Long getId_aprobacion() {
		return id_aprobacion;
	}

	public void setId_aprobacion(Long id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}

	

	public String getTipoAprobacion() {
		return tipoAprobacion;
	}


	public void setTipoAprobacion(String tipoAprobacion) {
		this.tipoAprobacion = tipoAprobacion;
	}


	public Boolean getEstadoAproba() {
		return estadoAproba;
	}

	public void setEstadoAproba(Boolean estadoAproba) {
		this.estadoAproba = estadoAproba;
	}

	public String getDetalleControl() {
		return detalleControl;
	}

	public void setDetalleControl(String detalleControl) {
		this.detalleControl = detalleControl;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}




	public Empleado getSecretaria() {
		return secretaria;
	}


	public void setSecretaria(Empleado secretaria) {
		this.secretaria = secretaria;
	}


	public Long getIdTipoAprobacion() {
		return idTipoAprobacion;
	}


	public void setIdTipoAprobacion(Long idTipoAprobacion) {
		this.idTipoAprobacion = idTipoAprobacion;
	}


	

}

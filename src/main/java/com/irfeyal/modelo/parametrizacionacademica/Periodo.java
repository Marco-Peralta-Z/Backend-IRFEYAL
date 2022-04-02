package com.irfeyal.modelo.parametrizacionacademica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "periodo")
public class Periodo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_periodo;

    @Column(name = "actividades")
    private String actividades;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_activiti")
    private Date fecha_activiti;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Calendar fecha_creacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_fin")
    private Date fecha_fin;

    @Column(name = "costo_mensualidad")
    private Double costo_mensualidad;

    @Column(name = "costo_matricula")
    private Double costo_matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_malla")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Malla id_malla;

    public Periodo() {
        super();
    }

    public Long getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(Long id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public Date getFecha_activiti() {
        return fecha_activiti;
    }

    public void setFecha_activiti(Date fecha_activiti) {
        this.fecha_activiti = fecha_activiti;
    }

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getCosto_mensualidad() {
        return costo_mensualidad;
    }

    public void setCosto_mensualidad(Double costo_mensualidad) {
        this.costo_mensualidad = costo_mensualidad;
    }

    public Double getCosto_matricula() {
        return costo_matricula;
    }

    public void setCosto_matricula(Double costo_matricula) {
        this.costo_matricula = costo_matricula;
    }

    public Malla getId_malla() {
        return id_malla;
    }

    public void setId_malla(Malla id_malla) {
        this.id_malla = id_malla;
    }

}//fin()

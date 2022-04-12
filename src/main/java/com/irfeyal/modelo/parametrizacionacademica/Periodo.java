package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:41.

@Data
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
    @Column(name = "fecha_actividad")
    private Date fecha_actividad;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @PrePersist
    private void setDateFecha(){
        this.fecha_creacion = new Date();
    }

    //Relación Periodo-Malla
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_malla")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Malla malla;

}

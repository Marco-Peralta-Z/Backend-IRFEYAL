package com.irfeyal.modelo.tutorias;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

@Entity
@Table(name = "registro")
@NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_registro;

	@Column
	private float aporte1;
	@Column
	private float aporte2;
	@Column
	private float examen_Iquimestre;
	@Column
	private float promedio_Iquimestre;
	@Column
	private float aporte3;
	@Column
	private float aporte4;
	@Column
	private float examen_IIquimestre;
	@Column
	private float promedio_IIquimestre;
	@Column
	private float conducta;
	@Column
	private float examen_supletorio;
	@Column
	private float examen_remedial;
	@Column
	private float examen_gracia;
	@Column
	private float nota_final;
	@Column
	private String estado;

	@OneToOne()
	@JoinColumn(name = "id_matricula")
	private Matricula id_matricula;

	@OneToOne()
	@JoinColumn(name = "fkid_asignatura")
	private Asignatura id_asignatura;

	public Registro() {
	}

	public Registro(Long id_registro, float aporte1, float aporte2, float examen_Iquimestre, float promedio_Iquimestre,
			float aporte3, float aporte4, float examen_IIquimestre, float promedio_IIquimestre, float conducta,
			float nota_final, float examen_supletorio, float examen_remedial, float examen_gracia, String estado) {
		super();
		this.id_registro = id_registro;
		this.aporte1 = aporte1;
		this.aporte2 = aporte2;
		this.examen_Iquimestre = examen_Iquimestre;
		this.promedio_Iquimestre = promedio_Iquimestre;
		this.aporte3 = aporte3;
		this.aporte4 = aporte4;
		this.examen_IIquimestre = examen_IIquimestre;
		this.promedio_IIquimestre = promedio_IIquimestre;
		this.conducta = conducta;
		this.nota_final = nota_final;
		this.examen_supletorio = examen_supletorio;
		this.examen_remedial = examen_remedial;
		this.examen_gracia = examen_gracia;
		this.estado = estado;
	}

	public Long getId_registro() {
		return id_registro;
	}

	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}

	public float getAporte1() {
		return aporte1;
	}

	public void setAporte1(float aporte1) {
		this.aporte1 = aporte1;
	}

	public float getAporte2() {
		return aporte2;
	}

	public void setAporte2(float aporte2) {
		this.aporte2 = aporte2;
	}

	public float getExamen_Iquimestre() {
		return examen_Iquimestre;
	}

	public void setExamen_Iquimestre(float examen_Iquimestre) {
		this.examen_Iquimestre = examen_Iquimestre;
	}

	public float getPromedio_Iquimestre() {
		return promedio_Iquimestre;
	}

	public void setPromedio_Iquimestre(float promedio_Iquimestre) {
		this.promedio_Iquimestre = promedio_Iquimestre;
	}

	public float getAporte3() {
		return aporte3;
	}

	public void setAporte3(float aporte3) {
		this.aporte3 = aporte3;
	}

	public float getAporte4() {
		return aporte4;
	}

	public void setAporte4(float aporte4) {
		this.aporte4 = aporte4;
	}

	public float getExamen_IIquimestre() {
		return examen_IIquimestre;
	}

	public void setExamen_IIquimestre(float examen_IIquimestre) {
		this.examen_IIquimestre = examen_IIquimestre;
	}

	public float getPromedio_IIquimestre() {
		return promedio_IIquimestre;
	}

	public void setPromedio_IIquimestre(float promedio_IIquimestre) {
		this.promedio_IIquimestre = promedio_IIquimestre;
	}

	public float getConducta() {
		return conducta;
	}

	public void setConducta(float conducta) {
		this.conducta = conducta;
	}

	public float getExamen_supletorio() {
		return examen_supletorio;
	}

	public void setExamen_supletorio(float examen_supletorio) {
		this.examen_supletorio = examen_supletorio;
	}

	public float getExamen_remedial() {
		return examen_remedial;
	}

	public void setExamen_remedial(float examen_remedial) {
		this.examen_remedial = examen_remedial;
	}

	public float getExamen_gracia() {
		return examen_gracia;
	}

	public void setExamen_gracia(float examen_gracia) {
		this.examen_gracia = examen_gracia;
	}

	public float getNota_final() {
		return nota_final;
	}

	public void setNota_final(float nota_final) {
		this.nota_final = nota_final;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Matricula getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(Matricula id_matricula) {
		this.id_matricula = id_matricula;
	}

	public Asignatura getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Asignatura id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	/*----REPORTE TUTORIAS*/
	public String getNombre() {
		return this.id_matricula != null ? this.id_matricula.getEstudiante().getId_persona().getNombre() : "----";
	}

	public String getApellido() {
		return this.id_matricula != null ? this.id_matricula.getEstudiante().getId_persona().getApellido() : "----";
	}

	public String getCedula() {
		return this.id_matricula != null ? this.id_matricula.getEstudiante().getId_persona().getCedula() : "----";
	}

	public String getCurso() {
		return this.id_matricula != null ? this.id_matricula.getCurso().getDescripcion() : "------";
	}

	public String getParalelo() {
		return this.id_matricula != null ? this.id_matricula.getId_paralelo().getDescripcion() : "-----";
	}

	public String getAsignatura() {
		return this.id_asignatura != null ? this.id_asignatura.getDescripcion() : "------";
	}

}

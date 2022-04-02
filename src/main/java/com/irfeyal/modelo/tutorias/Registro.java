package com.irfeyal.modelo.tutorias;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registro")

public class Registro implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_registro;
	
	@Column
	private int aporte1;
	@Column
	private int aporte2;
	@Column
	private int aporte3;
	@Column
	private int aporte4;
	@Column
	private int evaluacion1;
	@Column
	private int aporte5;
	@Column
	private int aporte6;
	@Column
	private int aporte7;
	@Column
	private int aporte8;
	@Column
	private int evaluacion2;
	@Column
	private int examenfinal;
	@Column
	private int promediofinal;
	@Column
	private int examen_supletorio;
	@Column
	private int promedio_supletorio;
	@Column
	private int examen_remedial;
	@Column
	private int promedio_remedial;
	@Column
	private int examen_gracia;
	@Column
	private int promedio_gracia;
	@Column
	private int comportamiento;
	
	
	public Registro() {
	}

	public Registro(Long id_registro, int aporte1, int aporte2, int aporte3, int aporte4, int evaluacion1, int aporte5,
			int aporte6, int aporte7, int aporte8, int evaluacion2, int examenfinal, int promediofinal,
			int examen_supletorio, int promedio_supletorio, int examen_remedial, int promedio_remedial,
			int examen_gracia, int promedio_gracia, int comportamiento) {
		super();
		this.id_registro = id_registro;
		this.aporte1 = aporte1;
		this.aporte2 = aporte2;
		this.aporte3 = aporte3;
		this.aporte4 = aporte4;
		this.evaluacion1 = evaluacion1;
		this.aporte5 = aporte5;
		this.aporte6 = aporte6;
		this.aporte7 = aporte7;
		this.aporte8 = aporte8;
		this.evaluacion2 = evaluacion2;
		this.examenfinal = examenfinal;
		this.promediofinal = promediofinal;
		this.examen_supletorio = examen_supletorio;
		this.promedio_supletorio = promedio_supletorio;
		this.examen_remedial = examen_remedial;
		this.promedio_remedial = promedio_remedial;
		this.examen_gracia = examen_gracia;
		this.promedio_gracia = promedio_gracia;
		this.comportamiento = comportamiento;
	}

	public Long getId_registro() {
		return id_registro;
	}

	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}

	public int getAporte1() {
		return aporte1;
	}

	public void setAporte1(int aporte1) {
		this.aporte1 = aporte1;
	}

	public int getAporte2() {
		return aporte2;
	}

	public void setAporte2(int aporte2) {
		this.aporte2 = aporte2;
	}

	public int getAporte3() {
		return aporte3;
	}

	public void setAporte3(int aporte3) {
		this.aporte3 = aporte3;
	}

	public int getAporte4() {
		return aporte4;
	}

	public void setAporte4(int aporte4) {
		this.aporte4 = aporte4;
	}

	public int getEvaluacion1() {
		return evaluacion1;
	}

	public void setEvaluacion1(int evaluacion1) {
		this.evaluacion1 = evaluacion1;
	}

	public int getAporte5() {
		return aporte5;
	}

	public void setAporte5(int aporte5) {
		this.aporte5 = aporte5;
	}

	public int getAporte6() {
		return aporte6;
	}

	public void setAporte6(int aporte6) {
		this.aporte6 = aporte6;
	}

	public int getAporte7() {
		return aporte7;
	}

	public void setAporte7(int aporte7) {
		this.aporte7 = aporte7;
	}

	public int getAporte8() {
		return aporte8;
	}

	public void setAporte8(int aporte8) {
		this.aporte8 = aporte8;
	}

	public int getEvaluacion2() {
		return evaluacion2;
	}

	public void setEvaluacion2(int evaluacion2) {
		this.evaluacion2 = evaluacion2;
	}

	public int getExamenfinal() {
		return examenfinal;
	}

	public void setExamenfinal(int examenfinal) {
		this.examenfinal = examenfinal;
	}

	public int getPromediofinal() {
		return promediofinal;
	}

	public void setPromediofinal(int promediofinal) {
		this.promediofinal = promediofinal;
	}

	public int getExamen_supletorio() {
		return examen_supletorio;
	}

	public void setExamen_supletorio(int examen_supletorio) {
		this.examen_supletorio = examen_supletorio;
	}

	public int getPromedio_supletorio() {
		return promedio_supletorio;
	}

	public void setPromedio_supletorio(int promedio_supletorio) {
		this.promedio_supletorio = promedio_supletorio;
	}

	public int getExamen_remedial() {
		return examen_remedial;
	}

	public void setExamen_remedial(int examen_remedial) {
		this.examen_remedial = examen_remedial;
	}

	public int getPromedio_remedial() {
		return promedio_remedial;
	}

	public void setPromedio_remedial(int promedio_remedial) {
		this.promedio_remedial = promedio_remedial;
	}

	public int getExamen_gracia() {
		return examen_gracia;
	}

	public void setExamen_gracia(int examen_gracia) {
		this.examen_gracia = examen_gracia;
	}

	public int getPromedio_gracia() {
		return promedio_gracia;
	}

	public void setPromedio_gracia(int promedio_gracia) {
		this.promedio_gracia = promedio_gracia;
	}

	public int getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(int comportamiento) {
		this.comportamiento = comportamiento;
	}
	
	

}

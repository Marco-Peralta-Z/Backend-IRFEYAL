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
@Table(name="registro")
@NamedQuery(name="Registro.findAll", query="SELECT r FROM Registro r")
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
	private int examen_Iquimestre;
	@Column
	private int promedio_Iquimestre;
	@Column
	private int aporte3;
	@Column
	private int aporte4;
	@Column
	private int examen_IIquimestre;
	@Column
	private int promedio_IIquimestre;
	@Column
	private int examen_supletorio;
	@Column
	private int examen_remedial;
	@Column
	private int examen_gracia;
	@Column
	private int nota_final;
	
	
	 @OneToOne()
		@JoinColumn(name="id_matricula")
		private Matricula id_matricula;
	 
	 @OneToOne()
		@JoinColumn(name="fkid_asignatura")
		private Asignatura id_asignatura;
	
	public Registro() {
	}


	public Registro(Long id_registro, int aporte1, int aporte2, int examen_Iquimestre, int promedio_Iquimestre,
			int aporte3, int aporte4, int examen_IIquimestre, int promedio_IIquimestre, int examen_supletorio,
			int examen_remedial, int examen_gracia, int nota_final) {
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
		this.examen_supletorio = examen_supletorio;
		this.examen_remedial = examen_remedial;
		this.examen_gracia = examen_gracia;
		this.nota_final = nota_final;
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


	public int getExamen_Iquimestre() {
		return examen_Iquimestre;
	}


	public void setExamen_Iquimestre(int examen_Iquimestre) {
		this.examen_Iquimestre = examen_Iquimestre;
	}


	public int getPromedio_Iquimestre() {
		return promedio_Iquimestre;
	}


	public void setPromedio_Iquimestre(int promedio_Iquimestre) {
		this.promedio_Iquimestre = promedio_Iquimestre;
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


	public int getExamen_IIquimestre() {
		return examen_IIquimestre;
	}


	public void setExamen_IIquimestre(int examen_IIquimestre) {
		this.examen_IIquimestre = examen_IIquimestre;
	}


	public int getPromedio_IIquimestre() {
		return promedio_IIquimestre;
	}


	public void setPromedio_IIquimestre(int promedio_IIquimestre) {
		this.promedio_IIquimestre = promedio_IIquimestre;
	}


	public int getExamen_supletorio() {
		return examen_supletorio;
	}


	public void setExamen_supletorio(int examen_supletorio) {
		this.examen_supletorio = examen_supletorio;
	}


	public int getExamen_remedial() {
		return examen_remedial;
	}

	
	public void setExamen_remedial(int examen_remedial) {
		this.examen_remedial = examen_remedial;
	}


	public int getExamen_gracia() {
		return examen_gracia;
	}


	public void setExamen_gracia(int examen_gracia) {
		this.examen_gracia = examen_gracia;
	}


	public int getNota_final() {
		return nota_final;
	}


	public void setNota_final(int nota_final) {
		this.nota_final = nota_final;
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
	
	
	

}

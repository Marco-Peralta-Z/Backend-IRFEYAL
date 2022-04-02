package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "paralelo")
public class Paralelo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_paralelo;

	@Column(name = "descripcion")
	private String descripcion_paralelo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fec_creacion")
	private Date fec_creacion_paralelo;
	
	@PrePersist
	private void setFechaCreacion() {
		this.fec_creacion_paralelo = new Date();
	}
	
	@ManyToMany
	@JoinTable(
			name = "curso_paralelo",
			joinColumns = { @JoinColumn(name = "id_paralelo") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos;

	// idMatricula
	
	public Long getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Long id_paralelo) {
		this.id_paralelo = id_paralelo;
	}

	public String getDescripcion_paralelo() {
		return descripcion_paralelo;
	}

	public void setDescripcion_paralelo(String descripcion_paralelo) {
		this.descripcion_paralelo = descripcion_paralelo;
	}

	public Date getFec_creacion_paralelo() {
		return fec_creacion_paralelo;
	}

	public void setFec_creacion_paralelo(Date fec_creacion_paralelo) {
		this.fec_creacion_paralelo = fec_creacion_paralelo;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion_paralelo, fec_creacion_paralelo, id_paralelo, listaCursos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paralelo other = (Paralelo) obj;
		return Objects.equals(descripcion_paralelo, other.descripcion_paralelo)
				&& Objects.equals(fec_creacion_paralelo, other.fec_creacion_paralelo)
				&& Objects.equals(id_paralelo, other.id_paralelo) && Objects.equals(listaCursos, other.listaCursos);
	}

	@Override
	public String toString() {
		return "Paralelo [id_paralelo=" + id_paralelo + ", descripcion_paralelo=" + descripcion_paralelo
				+ ", fec_creacion_paralelo=" + fec_creacion_paralelo + ", listaCursos=" + listaCursos
				+ ", getId_paralelo()=" + getId_paralelo() + ", getDescripcion_paralelo()=" + getDescripcion_paralelo()
				+ ", getFec_creacion_paralelo()=" + getFec_creacion_paralelo() + ", getListaCursos()="
				+ getListaCursos() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}

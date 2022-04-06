package com.irfeyal.modelo.rolseguridad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="modulo")
@NamedQuery(name="modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_modulo")
		private Integer idModulo;

		@Column(name="modulo")
		private String modulo;
		

		public Modulo() {
		}

		public Integer getIdModulo() {
			return this.idModulo;
		}

		public void setIdModulo(Integer idModulo) {
			this.idModulo = idModulo;
		}

		public String getModulo() {
			return this.modulo;
		}

		public void setModulo(String modulo) {
			this.modulo = modulo;
		}
}
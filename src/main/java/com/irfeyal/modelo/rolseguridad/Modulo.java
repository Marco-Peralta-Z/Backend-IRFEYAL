package com.irfeyal.modelo.rolseguridad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		
		@Column(name="url")
		private String url;
		
		@ManyToOne
		@JoinColumn(name = "id_rol_usuario")
		private RolUsuario id_rol_usuario;

		public Modulo() {
		}
		
		public Modulo(Integer idModulo, String modulo, String url, RolUsuario id_rol_usuario) {
			super();
			this.idModulo = idModulo;
			this.modulo = modulo;
			this.url = url;
			this.id_rol_usuario = id_rol_usuario;
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

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public RolUsuario getId_rol_usuario() {
			return id_rol_usuario;
		}

		public void setId_rol_usuario(RolUsuario id_rol_usuario) {
			this.id_rol_usuario = id_rol_usuario;
		}
		
}
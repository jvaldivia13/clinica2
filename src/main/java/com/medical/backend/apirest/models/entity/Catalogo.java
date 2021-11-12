package com.medical.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="adm_catalogos_mae")
public class Catalogo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="nom_tabla")
	private String nombre;
	
	@Column(name = "id_elemento")
	private Long idelemento;
	
	@Column(name = "cod_elemento")
	private String codelemento;
	
	@Column(name = "nom_elemento")
	private String nomelemento;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "cod_especialidad")
	private String codespecialidad;
	
	@Column(name = "cod_medico")
	private String codmedico;
	
	@Column(name = "id_user")
	private int  iduser;
	
	@Column(name = "fec_registro")
	@Temporal(TemporalType.DATE)
	private Date fcreacion;
	
	@Column(name = "user_registro")
	private String user;
	
	
	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public String getCodelemento() {
		return codelemento;
	}

	public void setCodelemento(String codelemento) {
		this.codelemento = codelemento;
	}

	public String getCodespecialidad() {
		return codespecialidad;
	}

	public void setCodespecialidad(String codespecialidad) {
		this.codespecialidad = codespecialidad;
	}

	public String getCodmedico() {
		return codmedico;
	}

	public void setCodmedico(String codmedico) {
		this.codmedico = codmedico;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdelemento() {
		return idelemento;
	}

	public void setIdelemento(Long idelemento) {
		this.idelemento = idelemento;
	}

	public String getNomelemento() {
		return nomelemento;
	}

	public void setNomelemento(String nomelemento) {
		this.nomelemento = nomelemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(Date fcreacion) {
		this.fcreacion = fcreacion;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	private static final long serialVersionUID = 1L;

}

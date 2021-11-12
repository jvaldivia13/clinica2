package com.medical.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cli_receta_cab")
public class Receta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id_receta;
	

	@JsonIgnoreProperties(value={"recetas", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@Column(name = "cod_medico")
	private String medico;
	
	@Column(name = "cod_dpto")
	private String dpto;
	
	@Column(name = "cod_dx")
	private String dx;
	
	@Column(name = "nota_orden")
	private String nota;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "receta_id")
	private List<ItemReceta> items;
	
	@Column(name = "fec_registro")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "user_registro")
	private String usereg;
	
	
	public Receta() {
		items = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getDx() {
		return dx;
	}

	public void setDx(String dx) {
		this.dx = dx;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUsereg() {
		return usereg;
	}

	public void setUsereg(String usereg) {
		this.usereg = usereg;
	}
	
	
	public Double getTotal() {
		Double total = 0.00;
		for (ItemReceta item : items) {
			total += item.getImporte();
		}
		return total;
	}
	
	public Long getId_receta() {
		return id_receta;
	}

	public void setId_receta(Long id_receta) {
		this.id_receta = id_receta;
	}

	public List<ItemReceta> getItems() {
		return items;
	}

	public void setItems(List<ItemReceta> items) {
		this.items = items;
	}

	private static final long serialVersionUID = 1L;

}

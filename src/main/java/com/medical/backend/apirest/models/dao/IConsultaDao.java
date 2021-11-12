package com.medical.backend.apirest.models.dao;

import java.util.Date;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medical.backend.apirest.models.entity.Orden;
import com.medical.backend.apirest.models.entity.Receta;

public interface IConsultaDao extends CrudRepository< Receta, Integer> {
	
	@Query("select p from Receta p where p.medico like %?1% and fecha=?2 ")
	public List<Receta>getData(String medico, Date fecha);
	
	
	@Query("select p from Orden p where p.medico like %?1% and fecha=?2 ")
	public List<Orden>getDataOrden(String medico, Date fecha);

}

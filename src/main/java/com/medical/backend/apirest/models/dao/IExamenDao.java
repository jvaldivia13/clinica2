package com.medical.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medical.backend.apirest.models.entity.Examen;

public interface IExamenDao extends JpaRepository<Examen, Long>{
	
	@Query("select p from Examen p where p.nombre like %?1%")
	public List<Examen> findByNombre(String term);
	
	public List<Examen> findByNombreContainingIgnoreCase(String term);
	
	public List<Examen> findByNombreStartingWithIgnoreCase(String term);

}

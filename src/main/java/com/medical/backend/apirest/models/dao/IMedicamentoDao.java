package com.medical.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medical.backend.apirest.models.entity.Medicamento;


public interface IMedicamentoDao extends JpaRepository<Medicamento, Long> {
	
	@Query("select p from Medicamento p where p.nombre like %?1%")
	public List<Medicamento> findByNombre(String term);
	
	public List<Medicamento> findByNombreContainingIgnoreCase(String term);
	
	public List<Medicamento> findByNombreStartingWithIgnoreCase(String term);


}

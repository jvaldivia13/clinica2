package com.medical.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.medical.backend.apirest.models.entity.Catalogo;

public interface ICatalogoDao extends CrudRepository<Catalogo, Long> {

	@Query("select p from Catalogo p where p.nombre like %?1%")
	public List<Catalogo> findByNombre(String term);
	
	@Query("select p from Catalogo p where p.nombre =?1 and nomelemento like %?2%")
	public List<Catalogo> findByElementoCatalogo(String stabla, String Selemento);
	
	@Query("select p from Catalogo p where codmedico =?1")
	public List<Catalogo> findByMedico(String cmp);
	
	@Query("select p from Catalogo p where iduser =?1")
	public Catalogo findByIdUser(int iduser);
	
	public List<Catalogo> findByNombreContainingIgnoreCase(String term);
	
	public List<Catalogo> findByNombreStartingWithIgnoreCase(String term);
	
}

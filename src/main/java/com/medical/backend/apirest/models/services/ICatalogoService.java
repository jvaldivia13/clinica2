package com.medical.backend.apirest.models.services;

import java.util.List;

import com.medical.backend.apirest.models.entity.Catalogo;

public interface ICatalogoService {
	
	public List<Catalogo> findCatalogoByNombre(String term);
	public List<Catalogo> findCatalogoByElemento(String stabla, String selemento);
	public List<Catalogo> findCatalogoByMedico(String cmp);
	public Catalogo findCatalogoByIdUser(int iduser);

}

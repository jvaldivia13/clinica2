package com.medical.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.backend.apirest.models.dao.ICatalogoDao;
import com.medical.backend.apirest.models.entity.Catalogo;


@Service
public class CatalogoServiceImpl implements ICatalogoService{
	
	@Autowired
	private ICatalogoDao catalogoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Catalogo> findCatalogoByNombre(String term) {
		return catalogoDao.findByNombreContainingIgnoreCase(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Catalogo> findCatalogoByElemento(String stabla, String selemento) {
		return catalogoDao.findByElementoCatalogo(stabla, selemento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Catalogo> findCatalogoByMedico(String cmp) {
		return catalogoDao.findByMedico(cmp);
	}

	@Override
	public Catalogo findCatalogoByIdUser(int iduser) {
		return catalogoDao.findByIdUser(iduser);
	}
	 
	
	
	
	
	
}

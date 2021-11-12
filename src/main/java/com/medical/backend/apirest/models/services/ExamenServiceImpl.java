package com.medical.backend.apirest.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.backend.apirest.models.dao.IConsultaDao;
import com.medical.backend.apirest.models.dao.IExamenDao;
import com.medical.backend.apirest.models.dao.IOrdenDao;
import com.medical.backend.apirest.models.entity.Examen;
import com.medical.backend.apirest.models.entity.Orden;
import com.medical.backend.apirest.models.entity.Receta;

@Service
public class ExamenServiceImpl implements IExamenService{
	
	@Autowired
	private IExamenDao examenDao;
	
	@Autowired
	private IOrdenDao ordenDao;
	
	@Autowired
	private IConsultaDao consultaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findExamenByNombre(String term) {
		return examenDao.findByNombreContainingIgnoreCase(term);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Orden findOrdenById(Long id) {
		return ordenDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Orden saveOrden(Orden orden) {
		return ordenDao.save(orden);
	}

	@Override
	@Transactional
	public void deleteOrdenById(Long id) {
		ordenDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Orden> SerchOrdenByDate(String medico, Date fecha) {
		return consultaDao.getDataOrden(medico, fecha);
	}
	
		
}

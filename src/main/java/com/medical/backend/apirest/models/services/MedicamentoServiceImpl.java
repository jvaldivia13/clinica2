package com.medical.backend.apirest.models.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.backend.apirest.models.dao.IConsultaDao;
import com.medical.backend.apirest.models.dao.IMedicamentoDao;
import com.medical.backend.apirest.models.dao.IRecetaDao;
import com.medical.backend.apirest.models.entity.Medicamento;
import com.medical.backend.apirest.models.entity.Receta;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService{
	
	public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";
	
	@Autowired
	private IMedicamentoDao medicamentoDao;
	
	@Autowired
	private IRecetaDao recetaDao;
	
	@Autowired
	private IConsultaDao consultaDao;
	
	@Autowired
	EntityManager em;
	

	@Override
	public List<Medicamento> findMedicamentoByNombre(String term) {
		return medicamentoDao.findByNombreContainingIgnoreCase(term);
	}

	@Override
	public Receta findRecetaById(Long id) {
		return recetaDao.findById(id).orElse(null);
	}

	@Override
	public Receta saveReceta(Receta receta) {
		return recetaDao.save(receta);
	}

	@Override
	public void deleteRecetaById(Long id) {
		recetaDao.deleteById(id);
		
	}

	@Override
	public List<Receta> SerchRecetaByDate(String medico, Date fecha) {

		return consultaDao.getData(medico, fecha);
	}


	

}

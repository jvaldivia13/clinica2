package com.medical.backend.apirest.models.services;

import java.util.Date;
import java.util.List;

import com.medical.backend.apirest.models.entity.Medicamento;
import com.medical.backend.apirest.models.entity.Receta;

public interface IMedicamentoService {
	
	public Receta findRecetaById(Long id);
	
	public List<Receta> SerchRecetaByDate(String medico ,Date fecha);
			
	public Receta saveReceta(Receta receta);
		
	public void deleteRecetaById(Long id);
	
	public List<Medicamento> findMedicamentoByNombre(String term);

}


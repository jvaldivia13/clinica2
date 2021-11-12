package com.medical.backend.apirest.models.services;

import java.util.Date;
import java.util.List;

import com.medical.backend.apirest.models.entity.Examen;
import com.medical.backend.apirest.models.entity.Orden;
import com.medical.backend.apirest.models.entity.Receta;

public interface IExamenService {
	
	
    public Orden findOrdenById(Long id);
    
    public List<Orden> SerchOrdenByDate(String medico ,Date fecha);
	
	public Orden saveOrden(Orden orden);
	
	public void deleteOrdenById(Long id);
	
	public List<Examen> findExamenByNombre(String term);

}

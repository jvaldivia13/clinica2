package com.medical.backend.apirest.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.medical.backend.apirest.models.entity.Receta;

public interface IRecetaDao extends CrudRepository<Receta, Long> {
	

}

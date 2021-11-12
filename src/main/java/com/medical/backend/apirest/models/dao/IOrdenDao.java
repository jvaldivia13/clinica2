package com.medical.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.medical.backend.apirest.models.entity.Orden;

public interface IOrdenDao extends CrudRepository<Orden, Long>{

}

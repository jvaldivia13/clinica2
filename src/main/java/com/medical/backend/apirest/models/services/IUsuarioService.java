package com.medical.backend.apirest.models.services;

import com.medical.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}

package com.medical.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.medical.backend.apirest.models.entity.Medicamento;
import com.medical.backend.apirest.models.entity.Receta;
import com.medical.backend.apirest.models.services.IMedicamentoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RecetaRestController {
	
	@Autowired
	private IMedicamentoService medicinaService;
	
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/recetas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Receta show(@PathVariable Long id) {
		return medicinaService.findRecetaById(id);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/recetas")
	@ResponseStatus(HttpStatus.OK)
	public List<Receta> BandejaReceta(
			@RequestParam(required=false) String medico, 
			@RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha) {
		return medicinaService.SerchRecetaByDate(medico,fecha);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/recetas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		medicinaService.deleteRecetaById(id);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/recetas")
	@ResponseStatus(HttpStatus.CREATED)
	public Receta crear(@RequestBody Receta receta) {
		return medicinaService.saveReceta(receta);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/medicamento/filtrar-medicamento/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Medicamento> filtrarProductos(@PathVariable String term){
		return medicinaService.findMedicamentoByNombre(term);
	}
	

}

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

import com.medical.backend.apirest.models.entity.Examen;
import com.medical.backend.apirest.models.entity.Orden;
import com.medical.backend.apirest.models.entity.Receta;
import com.medical.backend.apirest.models.services.IExamenService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrdenRestController {
	
	@Autowired
	private IExamenService examenService;
	
	
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/orden")
	@ResponseStatus(HttpStatus.OK)
	public List<Orden> BandejaReceta(
			@RequestParam(required=false) String medico, 
			@RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha) {
		return examenService.SerchOrdenByDate(medico, fecha);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/ordenes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Orden show(@PathVariable Long id) {
		return examenService.findOrdenById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/ordenes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		examenService.deleteOrdenById(id);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/ordenes")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden crear(@RequestBody Orden orden) {
		return examenService.saveOrden(orden);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/examen/filtrar-examen/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Examen> filtrarProductos(@PathVariable String term){
		return examenService.findExamenByNombre(term);
	}
	

}

package com.medical.backend.apirest.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.backend.apirest.models.entity.Catalogo;
import com.medical.backend.apirest.models.services.ICatalogoService;
import com.medical.backend.apirest.view.ReportPdfService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CatalogoRestController {
	
	
	@Autowired
	private ICatalogoService catalogoservice;
	
		
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/catalogo/filtrar-catalogo/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Catalogo> filtrarProductos(@PathVariable String term){
		return catalogoservice.findCatalogoByNombre(term);
	}
	
	
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/catalogo/filtrar-elemento")
	@ResponseStatus(HttpStatus.OK)
	public List<Catalogo> filtrarElemento(@RequestParam(required=false) String stabla, 
										  @RequestParam(required=false) String selemento ){
		return catalogoservice.findCatalogoByElemento(stabla,selemento);
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/catalogo/filtrar-medico")
	@ResponseStatus(HttpStatus.OK)
	public List<Catalogo> filtrarMedico(@RequestParam(required=false) String cmp ){
		return catalogoservice.findCatalogoByMedico(cmp);
	}
	
	

}

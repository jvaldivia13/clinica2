package com.medical.backend.apirest.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.backend.apirest.view.ReportPdfService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ReporteRestControler {
	
private final ReportPdfService reportPdfService;
	
	public ReporteRestControler(ReportPdfService pdfGeneratorService) {
        this.reportPdfService = pdfGeneratorService;
    }
	
	  @Secured({"ROLE_ADMIN"})
	  @GetMapping("/pdf/generate")
	    public void generatePDF(HttpServletResponse response,
	    		@RequestParam(required=false) Long idfactura
	    		) throws IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());

	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=receta_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);

	        this.reportPdfService.export(response,idfactura);
	    }

}

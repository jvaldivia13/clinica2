package com.medical.backend.apirest.view;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.medical.backend.apirest.models.entity.ItemReceta;
import com.medical.backend.apirest.models.entity.Receta;
import com.medical.backend.apirest.models.services.IMedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.io.IOException;


@Service
	public class ReportPdfService {
	   
	@Autowired
	private IMedicamentoService medicinaService;
	
	    public void export(HttpServletResponse response , Long idfactura) throws IOException {
	    	
	    
	    	
	        Document document = new Document(PageSize.A5);
	        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
						
			document.setPageSize(PageSize.LETTER.rotate());
			document.setMargins(-20, -20, 30, 20);
			
	        PdfWriter.getInstance(document, response.getOutputStream());

	        document.open();
			PdfPCell celda = null;
			
			/*Tabla Para El Titulo del PDF*/
			PdfPTable tablaTitulo = new PdfPTable(1);
							
			celda = new PdfPCell(new Phrase("Receta Medica", fuenteTitulo));
			celda.setBorder(0);
			celda.setBackgroundColor(new Color(255,255,255));
			celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setPadding(30);
			
			tablaTitulo.addCell(celda);
			tablaTitulo.setSpacingAfter(30);
			
			Receta receta = medicinaService.findRecetaById(idfactura);
			
			PdfPTable tablaCabera = new PdfPTable(1);
			
			                          
			celda = new PdfPCell(new Phrase("Nombre", fuenteTitulo));
			celda.setBorder(0);
			celda.setBackgroundColor(new Color(255,255,255));
			celda.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
			celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);  
			tablaCabera.addCell(celda);
			tablaCabera.addCell(receta.getCliente().getNombre()+" "+receta.getCliente().getApellido()) ;
			
			
			tablaCabera.addCell(receta.getCliente().getEmail());
			tablaCabera.addCell(receta.getDx());
			
			
			tablaCabera.setSpacingAfter(40);
			document.add(tablaTitulo);
			document.add(tablaCabera);
			
			PdfPTable tablaItems = new PdfPTable(4);
			tablaItems.setWidths(new float [] {1, 3.5f, 1, 3.5f});
			tablaItems.addCell(new Phrase("Codigo"));
			tablaItems.addCell(new Phrase("Nombre"));
			tablaItems.addCell(new Phrase("Cantidad"));
			tablaItems.addCell(new Phrase("Posologia"));

			
			for(ItemReceta item: receta.getItems()) {
				tablaItems.addCell(item.getMedicina().getId().toString());
				tablaItems.addCell(item.getMedicina().getNombre());
				tablaItems.addCell(item.getCantidad().toString());
				tablaItems.addCell(item.getPosologia());
				
			}
			
			document.add(tablaItems);
	        document.close();
	    }
	}

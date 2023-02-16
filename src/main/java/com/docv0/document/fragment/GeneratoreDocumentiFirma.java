package com.docv0.document.fragment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class GeneratoreDocumentiFirma implements Serializable{

	// servizio per generare pdf di firma
	public Document generaPdf(String nomePdf,String nome, String cognome, String cf, String firma) throws FileNotFoundException, DocumentException {

		Document document = new Document();
		// prendo in input come si chiama sto file
		PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/generatedoc/"+nomePdf+".pdf"));
		document.open();
		document.add(new Paragraph("Documenti utente :"));
		document.add(new Paragraph(new Date().toString()));
		PdfPTable table=new PdfPTable(2);

		PdfPCell cell = new PdfPCell (new Paragraph ("Dati Utente"));

		cell.setColspan (2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		cell.setBackgroundColor (new BaseColor (140, 221, 8));                                  

		table.addCell(cell);                                    
		ArrayList<String[]> row= new ArrayList<>();
		String[] data=new String[2];
		data[0]=nome;
		data[1]=cognome;
		String[] data1=new String[2];
		data1[0]=cf;
		data1[1]=firma;
		row.add(data);
		row.add(data1);

		for (String[] cols : row) {
			for (String col : cols) {
				table.addCell(col);
			}
		}

		document.add(table);
		document.close();

		return document;   
	}
}

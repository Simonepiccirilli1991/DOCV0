package com.docv0.document.fragment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class DocumentFragment {

	
	// genera documento
	public Document generaDocumenti(String nomeFile) throws Exception {

		
		return generaPdf(nomeFile);   
	}
	// legge pdf e lo ritorna
	public byte[] leggiDocumento() throws IOException {
		Path pdfPath = Paths.get("C:\\tmp\\provaPoste.pdf");
		//ClassPathResource res = new ClassPathResource("provaPoste.pdf");  
		//Path pdfPath = Paths.get(res.getPath());
		byte[] contents = Files.readAllBytes(pdfPath);
		
		return contents;
	}
	
	
	// metodo che genera
	private Document generaPdf(String nomePdf) throws FileNotFoundException, DocumentException {
		
		Document document = new Document();
		// prendo in input come si chiama sto file
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		PdfWriter.getInstance(document, new FileOutputStream("C:/tmp/"+nomePdf+".pdf"));
		//PdfWriter.getInstance(document, new FileOutputStream("C:/tmp/"+nomePdf+".pdf"));
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
		ArrayList<String[]> row=new ArrayList<String[]>();
		String[] data=new String[2];
		data[0]="1";
		data[1]="2";
		String[] data1=new String[2];
		data1[0]="3";
		data1[1]="4";
		row.add(data);
		row.add(data1);

		for(int i=0;i<row.size();i++) {
			String[] cols=row.get(i);
			for(int j=0;j<cols.length;j++){
				table.addCell(cols[j]);
			}
		}

		document.add(table);
		document.close();

		return document;   
	}
	
	
}

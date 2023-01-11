package com.docv0.document.fragment;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
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

import com.docv0.controller.model.DocumentRequest;
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
	
	// legge pdf e lo ritorna
	public byte[] leggiDocumento() throws IOException {
		Path pdfPath = Paths.get("src/main/resources/test/provaPoste.pdf");
		//ClassPathResource res = new ClassPathResource("provaPoste.pdf");  
		//Path pdfPath = Paths.get(res.getPath());
		byte[] contents = Files.readAllBytes(pdfPath);
		
		return contents;
	}
	
	public InputStream leggiDocument() throws IOException {
		Path pdfPath = Paths.get("src/main/resources/test/provaPoste.pdf");
		byte[] contents = Files.readAllBytes(pdfPath);
		InputStream resp =  new ByteArrayInputStream(contents);
		
		return resp;
	}
	
	
}

package com.docv0.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docv0.document.fragment.DocumentFragment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DocumentService {

	
	private final DocumentFragment docFragment;
	
	// costruttore per non mettere autowired sul componente
	public DocumentService(DocumentFragment docFragment) {
		this.docFragment = docFragment;
	}
	
	
	public Document generaPdf(String nomeFile) throws Exception {
		
		Document response = docFragment.generaDocumenti(nomeFile);
		return response;
	}
	
	
	public byte[] leggiPdf(String nomePdf) throws IOException {
		
		byte[] response = docFragment.leggiDocumento();
		
		return response;
	}
}

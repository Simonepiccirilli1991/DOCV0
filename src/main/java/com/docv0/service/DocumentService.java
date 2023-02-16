package com.docv0.service;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docv0.controller.model.DocumentRequest;
import com.docv0.document.fragment.DocumentFragment;
import com.docv0.document.fragment.GeneratoreDocumentiFirma;
import com.itextpdf.text.Document;


@Service
public class DocumentService {

	@Autowired GeneratoreDocumentiFirma generaDoc;
	
	private final DocumentFragment docFragment;
	
	// costruttore per non mettere autowired sul componente
	public DocumentService(DocumentFragment docFragment) {
		this.docFragment = docFragment;
	}
	
	public Document generaDocAnagrafica(DocumentRequest req) throws Exception {
		
		return generaDoc.generaPdf(req.getPdfName(), req.getNome(), req.getCognome(), req.getCf(), req.getFirma());
	}
	
	public Document generaPdf(String nomeFile) throws Exception {
		//TODO cambiare oggetto con anagrafica
		return generaDoc.generaPdf(nomeFile, nomeFile, nomeFile, nomeFile, nomeFile);
	}
	
	
	public byte[] leggiPdf(String nomePdf) throws IOException {

		return docFragment.leggiDocumento();
	}
}

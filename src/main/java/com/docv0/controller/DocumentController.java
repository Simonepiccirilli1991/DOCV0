package com.docv0.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.docv0.controller.model.DocumentRequest;
import com.docv0.service.DocumentService;
import com.docv0.service.ReadJsonService;
import com.itextpdf.text.Document;

@RestController
@RequestMapping("docv0")
public class DocumentController {

	@Autowired
	private DocumentService docService;
	@Autowired
	ReadJsonService readJsonService;
	
	@RequestMapping("getPdf")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<byte[]> getDocument() throws Exception{
		
		
		byte[] response = docService.leggiPdf("provaPoste");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
		ResponseEntity<byte[]> oResponse = new ResponseEntity<>(response, headers, HttpStatus.OK);
		return oResponse;
//		docService.generaPdf("prova");
//		Path pdfPath = Paths.get("C:\\tmp\\prova.pdf");
//		//File file1= new File("C:\tmp\report.pdf");
//		byte[] contents = Files.readAllBytes(pdfPath);
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_PDF);
//	    // Here you have to set the actual filename of your pdf
//	    String filename = "output.pdf";
//	    headers.setContentDispositionFormData(filename, filename);
//	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//	    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
//	    return response;
	}
	
	
	@PostMapping("post/document")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Document> generaDocumento(@RequestBody DocumentRequest request) throws Exception{
		
		Document docDto = docService.generaPdf("prova");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
		ResponseEntity<Document> oResponse = new ResponseEntity<>(docDto, headers, HttpStatus.OK);
		return oResponse;
	}
	
	@RequestMapping("json")
	public String json() throws Exception {
		return readJsonService.json();
	}
}

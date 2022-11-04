package com.docv0.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class ReadJsonService {

	public String json() throws Exception {
	 String file = "src/test/resources/funnel.json";
     String json = readFileAsString(file);
     
     return json;
	}
	
	 public static String readFileAsString(String file)throws Exception
	    {
	        return new String(Files.readAllBytes(Paths.get(file)));
	    }
}

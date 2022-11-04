package com.docv0;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DocvControllerTest {

	@Autowired
	protected MockMvc mvc;
	
	@Test
	public void getDocumentOk() throws  Exception {
		// non e mockato al momento ma worka uguale
		String mock =  mvc.perform(get("http://localhost:8080/docv0/getPdf")
				.contentType("application/json")
				.header("abi", "abi")
				.header("appname", "appname")
//				.content(objectMapper.writeValueAsString(iRequest))
				.characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andReturn().getResponse()
				.getContentAsString();
		
		System.out.println(mock);
		
	}
}

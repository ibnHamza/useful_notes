package me.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import me.error.GlobalExceptionHandler;
 

class CustomDataControllerTest {
	
	@Autowired
	private MockMvc mvcWeb;
	
	@Mock
	CustomService CustomService;
	
	 @InjectMocks
	 CustomController CustomController;
	
	CacheBody req;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
        this.mvcWeb = MockMvcBuilders.standaloneSetup(new GlobalExceptionHandler(), CustomController).build();
 
		 
	}

	@Test
	void testCustomSetValue() {
		Mockito.when(CustomService.setValue(Mockito.anyString(), Mockito.anyString(), Mockito.anyLong())).thenReturn(true);
	
		 
		try {
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(req)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.responseEntity").value(true));
			
		 
			
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(req)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.genericError.errorCode").value("ERROR_CODE_1"));
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	@Test
	void testCustomRetiveValue() {
		
	 
		
		
		 
		try {
			Mockito.when(CustomService.getValue(Mockito.any())).thenReturn(response);
			
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(request)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.responseEntity.fieldValue").value(response));
			
			 
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(request)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.genericError.errorCode").value("ERROR_CODE_2"));
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testCustomGetAllvalue() {
		String response = "TEST_VALUE1,TEST_VALUE2";
		try {
			Mockito.when(CustomService.getAllvalue()).thenReturn(response);
			
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api"))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.responseEntity").value(response));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testCustomGetCollectionValues() {
		 
		
		try {
			Mockito.when(CustomService.getValue(Mockito.any())).thenReturn(response);
			
		 mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(dataRequest)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
		 
		 dataRequest= new ArrayList<>();
		 mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(dataRequest)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.genericError.errorCode").value("ERROR_CODE_1"));
		
		 
			
			mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(dataRequest)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(jsonPath("$.genericError.errorCode").value("ERROR_CODE_1"));
		
		 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Test
	void testCustomSetCollectionValues() {
	 
		
		try {
			Mockito.when(CustomService.getValue(Mockito.any())).thenReturn(response);
			
		 mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(CustomTestUtils.convertObjectToJsonBytes(dataRequest)))
			.andExpect(MockMvcResultMatchers.status().is(200))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
		 
		 
			 mvcWeb.perform(MockMvcRequestBuilders.post("/api/custom/some-custom-api")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(CustomTestUtils.convertObjectToJsonBytes(dataRequest)))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.genericError.errorCode").value("ERROR_CODE_3"));
			
		 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
	}

}

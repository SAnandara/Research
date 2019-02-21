package com.ref.demo.datacollection.util;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ref.demo.datacollection.entity.Customer;

public class JsonUtil {
	
	private JsonUtil(){}

	private static final ObjectMapper  objectMapper = new ObjectMapper() ; 
	
	
	public static Customer getObj(final String json) throws IOException{
		return  getObjReader(new TypeReference<Customer>(){}).readValue(json); 
	}
	
	public static <T>String getJSONStr(final T element) throws JsonProcessingException{
		return getObjectMapperWriter().writeValueAsString(element) ;
	}
	
	private static ObjectReader getObjReader(TypeReference<Customer> typeReference) {
		return objectMapper.readerFor(typeReference) ;
	}
	
	private static ObjectWriter getObjectMapperWriter(){
		return objectMapper.writer();
	}
	
	
}

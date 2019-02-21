package com.ref.demo.datacollection.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




@Component
@Scope("prototype")
public class ServiceRequest {
	
	private Map<String,String> payload = new HashMap<>();
	
	private String serviceName = "" ;
	private String value="";
	//private Object object;
	private ServiceMethods serviceMethods;
	
	

	public ServiceMethods getServiceMethods() {
		return serviceMethods;
	}

	public void setServiceMethods(ServiceMethods serviceMethods) {
		this.serviceMethods = serviceMethods;
	}

	public void addPayLoad(final String key,final String value) {
		payload.put(key,value);
	}
	
	public Map<String, String> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, String> payload) {
		this.payload = payload;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

	
	
	

}

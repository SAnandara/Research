package com.ref.demo.datacollection.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceResponse {
	private Map<String,Object> payload = new HashMap<>();
	private String responseJson ;
	private String serviceName ;
	private ServiceMethods serviceMethods;
	private List<String> responseJsonList ;
	
	
	public ServiceMethods getServiceMethods() {
		return serviceMethods;
	}
	public void setServiceMethods(ServiceMethods serviceMethods) {
		this.serviceMethods = serviceMethods;
	}
	public Map<String, Object> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
	public String getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	private boolean error ;
	private String errorMsg ;


	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public List<String> getResponseJsonList() {
		return responseJsonList;
	}
	public void setResponseJsonList(List<String> responseJsonList) {
		this.responseJsonList = responseJsonList;
	}
}

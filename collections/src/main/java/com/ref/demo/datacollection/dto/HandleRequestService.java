package com.ref.demo.datacollection.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;
public interface HandleRequestService {

	public ServiceResponse handleRequest(final ServiceRequest serviceReq) throws DataValidationException, ProcessException, JsonProcessingException;
	
	public void setService(ServiceMethods serviceMethods);
	
	
}

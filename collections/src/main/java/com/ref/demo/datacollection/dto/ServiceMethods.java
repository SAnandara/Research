package com.ref.demo.datacollection.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;


public interface ServiceMethods {
	
	/**
	 * @param servReq
	 * @return
	 * @throws DataValidationException 
	 */
	public ServiceRequest validate(final ServiceRequest servReq) throws DataValidationException;

	/**
	 * @param servReq
	 * @return
	 * @throws DataValidationException 
	 * @throws JsonProcessingException 
	 */
	public ServiceResponse process(final ServiceRequest servReq) throws ProcessException, DataValidationException, JsonProcessingException;

	/**
	 * @param serviceResp
	 * @return
	 */
	public ServiceResponse processResponse(final ServiceResponse serviceResp);

}

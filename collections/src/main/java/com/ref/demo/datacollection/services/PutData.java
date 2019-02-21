package com.ref.demo.datacollection.services;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.dto.ServiceMethods;
import com.ref.demo.datacollection.dto.ServiceRequest;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.entity.Customer;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;
import com.ref.demo.datacollection.repository.customerRepository;
import com.ref.demo.datacollection.util.Constants;
import com.ref.demo.datacollection.util.JsonUtil;
import com.google.common.base.Strings;

@Component
public class PutData implements ServiceMethods{

	@Autowired
	private ServiceResponse serviceResponse ;
	@Autowired
	private customerRepository customerRepository ;
	private Customer Object=null;
	private Customer ObjectRespose=null;
	private String responseJson = Constants.EMPTY_STRING ;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName()) ;
	
	public ServiceRequest validate(ServiceRequest serviceRequest) throws DataValidationException {
		if(!serviceRequest.getPayload().isEmpty() && StringUtils.isEmpty(serviceRequest.getPayload().get(Constants.PUT_REQ_PARAM))){
			logger.error("Incorrect space Id");
			throw new DataValidationException("Something Went Wrong") ;
		}
			
		return serviceRequest;
	} 

	public ServiceResponse process(final ServiceRequest serviceRequest) throws ProcessException,DataValidationException {
		try {
			Object = (Customer)JsonUtil.getObj(serviceRequest.getPayload().get(Constants.PUT_REQ_PARAM)) ;
		} catch (IOException e) {
			throw new DataValidationException("Something went wrong") ;
		}
		
		if(Objects.nonNull(Object)) {
			ObjectRespose = customerRepository.save(Object);
		}
		 
		try {
			
			responseJson = JsonUtil.getJSONStr(ObjectRespose) ;
			//serviceResponse.setResponseJson(responseJson);
			
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			throw new ProcessException("Something went wrong");
		}
		 
		return serviceResponse;
	} 

	public ServiceResponse processResponse(ServiceResponse serviceResponse) {
		if(!Strings.isNullOrEmpty(responseJson)) {
			serviceResponse.setResponseJson(responseJson);
		}
		return serviceResponse;
	}
}

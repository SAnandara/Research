package com.ref.demo.datacollection;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.dto.ServiceRequest;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;

@Service("getImplementor")
public class GetImplementor extends RequestService {

	@Override
	public ServiceRequest validate(final ServiceRequest serviceRequest) throws DataValidationException  {
		
		return getServiceMethods().validate(serviceRequest);
	}
	
	@Override
	public ServiceResponse process(final ServiceRequest serviceRequest) throws ProcessException, DataValidationException, JsonProcessingException {
		return getServiceMethods().process(serviceRequest);
	}

	@Override
	public ServiceResponse processResponse(final ServiceResponse serviceResp) {
		return getServiceMethods().processResponse(serviceResp);
	}
	

}

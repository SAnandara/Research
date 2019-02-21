package com.ref.demo.datacollection;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.dto.HandleRequestService;
import com.ref.demo.datacollection.dto.ServiceMethods;
import com.ref.demo.datacollection.dto.ServiceRequest;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;

public abstract class RequestService implements HandleRequestService,ServiceMethods {
private ServiceMethods serviceMethods;
	
	@Override
	public ServiceResponse handleRequest(final ServiceRequest serviceRequest) throws DataValidationException, ProcessException, JsonProcessingException {
		final ServiceRequest serviceReq = validate(serviceRequest);
		final ServiceResponse serviceResp = process(serviceReq);
		return processResponse(serviceResp) ;
	}

	public ServiceMethods getServiceMethods() {
		return serviceMethods;
	}

	public void setService(ServiceMethods serviceMethods) {
		this.serviceMethods = serviceMethods;
	}
}

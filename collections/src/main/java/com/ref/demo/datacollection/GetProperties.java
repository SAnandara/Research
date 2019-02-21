package com.ref.demo.datacollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ref.demo.datacollection.dto.ServiceRequest;
import com.ref.demo.datacollection.util.Constants;


@Component
@Scope("prototype")
public class GetProperties {
	@Autowired
	private ServiceRequest serviceReq ;
	
	/**
	 * @param jsonData
	 * @return
	 */
	public ServiceRequest handle(final String jsonData) {
		
		serviceReq.getPayload().put(Constants.GET_REQ_PARAM, jsonData);
		
		return serviceReq;
	}
}

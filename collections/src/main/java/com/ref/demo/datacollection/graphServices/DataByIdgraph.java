package com.ref.demo.datacollection.graphServices;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.dto.ServiceMethods;
import com.ref.demo.datacollection.dto.ServiceRequest;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.entity.GraphSubscriptionStore;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;
import com.ref.demo.datacollection.repository.graphSubscriptionRepository;
import com.ref.demo.datacollection.util.Constants;
import com.ref.demo.datacollection.util.JsonUtil;

/**
 * 
 *
 */
@Component
public class DataByIdgraph implements ServiceMethods {

	private final static Logger logger = LoggerFactory.getLogger(DataByIdgraph.class);

	@Autowired
	private ServiceResponse serviceResponse;

	@Autowired
	private graphSubscriptionRepository Repository;

	private String responseJson;

	@Override
	public ServiceRequest validate(final ServiceRequest serviceRequest) throws DataValidationException {
		
		if (!serviceRequest.getPayload().isEmpty() ) {// Validate the Space Id
			final String id = serviceRequest.getPayload().get(Constants.GET_REQ_PARAM) ;
			if(StringUtils.isEmpty(id)) {
				logger.error("Missing ID in parameters");
				throw new DataValidationException("wrong");
			}
		}
		return serviceRequest;
	}


	@Override
	public ServiceResponse process(ServiceRequest serviceRequest) throws ProcessException {

		final Optional<GraphSubscriptionStore> Object = Repository
				.findById(serviceRequest.getPayload().get(Constants.GET_REQ_PARAM));

		try {
			if (Object.isPresent()) {
				responseJson = JsonUtil.getJSONStr(Object.get());
			} else {
				responseJson = "Id is not exist";
			}
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			throw new ProcessException(e.getMessage());
		}

		return serviceResponse;
	}

	@Override
	public ServiceResponse processResponse(ServiceResponse serviceResponse) {

		serviceResponse.setResponseJson(responseJson);

		return serviceResponse;
	}
}

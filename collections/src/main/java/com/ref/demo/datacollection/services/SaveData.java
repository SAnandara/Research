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

/**
 * 
 *
 */
@Component("saveData")
public class SaveData implements ServiceMethods{

	private final static Logger logger = LoggerFactory.getLogger(SaveData.class);

	@Autowired
	private ServiceResponse serviceResponse;
	@Autowired
	private customerRepository spaceRepository;
	private String Json;
	private Customer Object = null;

	@Override
	public ServiceRequest validate(ServiceRequest serviceRequest) throws DataValidationException {

		if (!serviceRequest.getPayload().isEmpty()
				&& StringUtils.isEmpty(serviceRequest.getPayload().get(Constants.POST_REQ_PARAM))) {
			logger.error("Incorrect space Id");
			throw new DataValidationException("exception");
		}

		return serviceRequest;
	}

	public ServiceResponse process(final ServiceRequest serviceRequest)
			throws ProcessException, DataValidationException {

		try {

			Object = JsonUtil.getObj(serviceRequest.getPayload().get(Constants.POST_REQ_PARAM));

		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new DataValidationException("Cant Save");
		}

		if (!Objects.isNull(Object)) {
			Object = spaceRepository.save(Object);
		}
		try {

			Json = JsonUtil.getJSONStr(Object);

		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			throw new ProcessException("error");
		}

		return serviceResponse;
	}

	public ServiceResponse processResponse(ServiceResponse serviceResponse) {
		serviceResponse.setResponseJson(Json);
		return serviceResponse;
	}
}

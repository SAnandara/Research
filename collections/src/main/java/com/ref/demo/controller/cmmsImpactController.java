package com.ref.demo.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ref.demo.datacollection.GetProperties;
import com.ref.demo.datacollection.cmmsServices.DataByIdcmms;
import com.ref.demo.datacollection.dto.HandleRequestService;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.entity.cmmsImpact;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;
import com.ref.demo.datacollection.repository.cmmsImpactRepository;


@RestController
public class cmmsImpactController {

	@Autowired
	private cmmsImpactRepository cmmsRepository;
	@Qualifier("getImplementor")
	@Autowired
	@Lazy
	private HandleRequestService getImplementor;
	@Autowired
	private ObjectFactory<DataByIdcmms> dataByIdFac;
	@Autowired
	private GetProperties getProperties ;

	@GetMapping("/cmms")
	public List<cmmsImpact> retrieveAllUsers() {
		return cmmsRepository.findAll();
	}
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("cmms/{id}")
	public ResponseEntity<String> getById(@PathVariable("id") String Id) throws DataValidationException, ProcessException, JsonProcessingException {

		
		getImplementor.setService(dataByIdFac.getObject());
		//Transfer the parameter from request
		final ServiceResponse serviceResponse=getImplementor.handleRequest(getProperties.handle(Id));

		return new ResponseEntity<>(serviceResponse.getResponseJson(), HttpStatus.OK);
		
	}
	@PostMapping("/cmms")
	public ResponseEntity<Object> createCustomer(@RequestBody cmmsImpact cmms2) {
		cmmsImpact saved = cmmsRepository.save(cmms2);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saved.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@DeleteMapping("/cmms/{id}")
	public void deleteUser(@PathVariable String id) {
	cmmsRepository.deleteById(id);
	}

}

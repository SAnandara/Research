package com.ref.demo.controller;


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ref.demo.datacollection.*;
import com.ref.demo.datacollection.dto.HandleRequestService;
import com.ref.demo.datacollection.dto.ServiceResponse;
import com.ref.demo.datacollection.entity.Customer;
import com.ref.demo.datacollection.exception.DataValidationException;
import com.ref.demo.datacollection.exception.ProcessException;
import com.ref.demo.datacollection.services.DataById;
import com.ref.demo.datacollection.services.PostImplemetor;
import com.ref.demo.datacollection.services.PutData;
import com.ref.demo.datacollection.services.SaveData;
import com.fasterxml.jackson.core.JsonProcessingException;






@RestController
public class CustomerController {
 	@Qualifier("putImplementor")
  	@Autowired
  	@Lazy
  	public HandleRequestService putImplementor;

	@Qualifier("postImplemetor")
  	@Autowired
  	@Lazy
  	public HandleRequestService implementor;
	@Qualifier("getImplementor")
	@Autowired
	@Lazy
	private HandleRequestService getImplementor;
	@Autowired
  	protected ObjectFactory<SaveData> saveDataFac;
	@Autowired
  	protected PostImplemetor postImplementor ;
	@Autowired
	private com.ref.demo.datacollection.repository.customerRepository customerRepository;
	@Autowired
	private ObjectFactory<DataById> dataByIdFac;
	@Autowired
  	public ObjectFactory<PutData> putDataFac;
	@Autowired
	private GetProperties getProperties ;
	@Autowired
	private PutProperties putProperties ;
	@Autowired
  	protected PostProperties postProp ;
	@GetMapping("/customers")
	public List<Customer> retrieveAllUsers() {
		return customerRepository.findAll();
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("customers/{id}")
	public ResponseEntity<String> getById(@PathVariable("id") String Id) throws DataValidationException, ProcessException, JsonProcessingException {

		
		getImplementor.setService(dataByIdFac.getObject());
		//Transfer the parameter from request
		final ServiceResponse serviceResponse=getImplementor.handleRequest(getProperties.handle(Id));

		return new ResponseEntity<>(serviceResponse.getResponseJson(), HttpStatus.OK);
		
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PostMapping("customers/{id}")
	public ResponseEntity<String> post(
			@RequestBody String jsonData) throws Exception {
		System.out.println("post test here");

		postImplementor.setService(saveDataFac.getObject());
		final ServiceResponse serviceResponse = postImplementor.handleRequest(postProp.handle(jsonData));

		return new ResponseEntity<>(serviceResponse.getResponseJson(), HttpStatus.OK);
	}
	@DeleteMapping("/customers/{id}")
	public void deleteUser(@PathVariable String id) {
	customerRepository.deleteById(id);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PutMapping("/{id}")
	public ResponseEntity<String> updateSample(@RequestBody String jsonData, @PathVariable("id") String id) throws Exception {

		putImplementor.setService(putDataFac.getObject());
		final ServiceResponse serviceResponse = putImplementor
				.handleRequest(putProperties.handle(jsonData, id));

		return new ResponseEntity<>(serviceResponse.getResponseJson(), HttpStatus.OK);
	}

}

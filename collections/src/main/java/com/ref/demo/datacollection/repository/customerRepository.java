package com.ref.demo.datacollection.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ref.demo.datacollection.entity.Customer;

@Repository
public interface customerRepository extends JpaRepository<Customer, String> {

	

}

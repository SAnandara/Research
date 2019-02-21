package com.ref.demo.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ref.demo.datacollection.entity.cmmsImpact;

@Repository
public interface cmmsImpactRepository extends JpaRepository<cmmsImpact, String> {

}

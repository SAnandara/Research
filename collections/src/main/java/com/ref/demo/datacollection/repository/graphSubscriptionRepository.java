package com.ref.demo.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ref.demo.datacollection.entity.GraphSubscriptionStore;
import com.ref.demo.datacollection.entity.cmmsImpact;

@Repository
public interface graphSubscriptionRepository extends JpaRepository<GraphSubscriptionStore, String> {

}

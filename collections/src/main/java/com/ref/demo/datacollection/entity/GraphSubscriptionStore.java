package com.ref.demo.datacollection.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class GraphSubscriptionStore {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	public String Id;
	public String subscriptionId;
	public Date ExpirationDateTime;
	public String userId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Date getExpirationDateTime() {
		return ExpirationDateTime;
	}
	public void setExpirationDateTime(Date expirationDateTime) {
		ExpirationDateTime = expirationDateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public GraphSubscriptionStore() {
		super();
	}

}

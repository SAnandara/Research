package com.ref.demo.datacollection.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class cmmsImpact {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	public String id;
	public String customerId;
	public String cmmsType;
	public String codeDescription;
	public String cmmsStatus;
	public Date date;
	public cmmsImpact(String id, String customerId, String cmmsType, String codeDescription, String cmmsStatus,
			Date date) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.cmmsType = cmmsType;
		this.codeDescription = codeDescription;
		this.cmmsStatus = cmmsStatus;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getcmmsStatus() {
		return cmmsStatus;
	}
	public void setcmmsStatus(String cmmsStatus) {
		this.cmmsStatus = cmmsStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCmmsType() {
		return cmmsType;
	}
	public void setCmmsType(String cmmsType) {
		this.cmmsType = cmmsType;
	}
	public String getCodeDescription() {
		return codeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	public cmmsImpact() {
	}
}

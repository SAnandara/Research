package com.ref.demo.datacollection.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Customer {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	public String Id;
	public String name;
	public String micId;
	public String domain;
	public String emailFromAddress;
	public String androidDownlaodLink;
	public String IsDownloadLink;
	public String supportWebLink;
	public String locationShareInvitationContext;
	public String invitationValueAddComment;
	public String invitationEmailSubject;
	public String org;
	public Customer(String id, String name, String micId, String domain, String emailFromAddress,
			String androidDownlaodLink, String isDownloadLink, String supportWebLink,
			String locationShareInvitationContext, String invitationValueAddComment, String invitationEmailSubject,
			String org) {
		super();
		Id = id;
		this.name = name;
		this.micId = micId;
		this.domain = domain;
		this.emailFromAddress = emailFromAddress;
		this.androidDownlaodLink = androidDownlaodLink;
		IsDownloadLink = isDownloadLink;
		this.supportWebLink = supportWebLink;
		this.locationShareInvitationContext = locationShareInvitationContext;
		this.invitationValueAddComment = invitationValueAddComment;
		this.invitationEmailSubject = invitationEmailSubject;
		this.org = org;
	}
	public Customer() {
	}
	
	

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMicId() {
		return micId;
	}
	public void setMicId(String micId) {
		this.micId = micId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getEmailFromAddress() {
		return emailFromAddress;
	}
	public void setEmailFromAddress(String emailFromAddress) {
		this.emailFromAddress = emailFromAddress;
	}
	public String getAndroidDownlaodLink() {
		return androidDownlaodLink;
	}
	public void setAndroidDownlaodLink(String androidDownlaodLink) {
		this.androidDownlaodLink = androidDownlaodLink;
	}
	public String getIsDownloadLink() {
		return IsDownloadLink;
	}
	public void setIsDownloadLink(String isDownloadLink) {
		IsDownloadLink = isDownloadLink;
	}
	public String getSupportWebLink() {
		return supportWebLink;
	}
	public void setSupportWebLink(String supportWebLink) {
		this.supportWebLink = supportWebLink;
	}
	public String getLocationShareInvitationContext() {
		return locationShareInvitationContext;
	}
	public void setLocationShareInvitationContext(String locationShareInvitationContext) {
		this.locationShareInvitationContext = locationShareInvitationContext;
	}
	public String getInvitationValueAddComment() {
		return invitationValueAddComment;
	}
	public void setInvitationValueAddComment(String invitationValueAddComment) {
		this.invitationValueAddComment = invitationValueAddComment;
	}
	public String getInvitationEmailSubject() {
		return invitationEmailSubject;
	}
	public void setInvitationEmailSubject(String invitationEmailSubject) {
		this.invitationEmailSubject = invitationEmailSubject;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}


}

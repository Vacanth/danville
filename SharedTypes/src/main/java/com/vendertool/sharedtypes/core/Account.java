package com.vendertool.sharedtypes.core;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	private String emailId;
	private ContactDetails contact;
	private Date createDate;
	private Date validTillDate;
	
	public Account(){}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public ContactDetails getContact() {
		return contact;
	}

	public void setContact(ContactDetails contact) {
		this.contact = contact;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getValidTillDate() {
		return validTillDate;
	}

	public void setValidTillDate(Date validTillDate) {
		this.validTillDate = validTillDate;
	}
}

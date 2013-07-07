package com.vendertool.sharedtypes.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContactDetails {
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String alternateEmailId;
	private Address address;
	private List<Phone> phones;
	
	public ContactDetails(){}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAlternateEmailId() {
		return alternateEmailId;
	}

	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	static class Phone {
		public enum PhoneType {
			MOBILE, HOME, WORK, PUBLIC, FAX;
		}
		
		private int countryCode;
		private int areaCode;
		private int number;
		
		public Phone(){}

		public int getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(int countryCode) {
			this.countryCode = countryCode;
		}

		public int getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(int areaCode) {
			this.areaCode = areaCode;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
	}
}

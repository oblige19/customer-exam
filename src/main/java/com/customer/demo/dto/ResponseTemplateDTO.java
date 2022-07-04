package com.customer.demo.dto;

import java.util.List;

import com.customer.demo.entity.Customer;

public class ResponseTemplateDTO {

	private Customer customer;
	private List<ContactDTO> contacts;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}

}

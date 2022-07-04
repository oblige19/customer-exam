package com.customer.demo.service;

import java.util.List;

import com.customer.demo.dto.ResponseTemplateDTO;
import com.customer.demo.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();
	
	Customer find(Long id);
	
	ResponseTemplateDTO findWithContact(Long id);
	
	String create(Customer customer);
	
	String update(Customer customer);
	
	String delete(Long id);
}

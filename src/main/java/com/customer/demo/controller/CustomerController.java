package com.customer.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.dto.ResponseTemplateDTO;
import com.customer.demo.entity.Customer;
import com.customer.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private final CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer find(@PathVariable("id") Long id) {
		return service.find(id);
	}
	
	@GetMapping("/{id}/contacts")
	public ResponseTemplateDTO findWithContacts(@PathVariable("id") Long id) {
		return service.findWithContact(id);
	}
	
	@PostMapping("")
	public String create(@RequestBody Customer customer) {
		return service.create(customer);
	}
	
	@PutMapping("")
	public String update(@RequestBody Customer customer) {
		return service.update(customer);
	}
	
}

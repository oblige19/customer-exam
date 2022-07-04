package com.customer.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.demo.dto.ContactDTO;
import com.customer.demo.dto.ResponseTemplateDTO;
import com.customer.demo.entity.Customer;
import com.customer.demo.repository.CustomerRepository;
import com.customer.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository repository;
	private final RestTemplate restTemplate;
	
	public CustomerServiceImpl(CustomerRepository repository, 
			RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Override
	public Customer find(Long id) {
		return repository.findById(id).orElse(new Customer());
	}

	@Override
	public String create(Customer customer) {
		return null;
	}

	@Override
	public String update(Customer customer) {
		return null;
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return null;
	}

	@Override
	public ResponseTemplateDTO findWithContact(Long id) {
		ResponseTemplateDTO response = new ResponseTemplateDTO();
		Customer customer = this.find(id);
		
		List<ContactDTO> contactDTOs = restTemplate.getForObject("http://CONTACT-SERVICE/contacts/" + id + "/customer", List.class);
		response.setCustomer(customer);
		response.setContacts(contactDTOs);
		
		return response;
	}

}

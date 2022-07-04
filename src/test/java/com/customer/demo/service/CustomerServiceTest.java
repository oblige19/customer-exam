package com.customer.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.demo.entity.Customer;

@TestPropertySource("/application.properties")
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql({"/customer.sql"})
public class CustomerServiceTest {
	
	@Autowired
	private CustomerService service;
	
	@Test
	public void findAll() {
		List<Customer> customers = service.findAll();
		Assert.assertTrue("Empty", !customers.isEmpty());
	}

	@Test
	public void createCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Juan");
		customer.setLastName("Dela Cruz");

		String result = service.create(customer);

		assertEquals(result, "Success");
	}


	@Test
	public void updateCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("JJ");
		customer.setLastName("Dela Cruz");

		String result = service.update(customer);

		assertEquals(result, "Success");
	}


	@Test
	public void deleteCustomer() {
		String result = service.delete(1L);

		assertEquals(result, "Success");
	}

}

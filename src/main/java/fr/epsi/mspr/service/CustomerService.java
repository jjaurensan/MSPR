package fr.epsi.mspr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.mspr.entity.Customer;
import fr.epsi.mspr.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

}

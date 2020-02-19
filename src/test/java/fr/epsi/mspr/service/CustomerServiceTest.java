package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.epsi.mspr.entity.Customer;
import fr.epsi.mspr.repository.CustomerRepository;
@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	CustomerService sut;

	@Test
	void createCustomer_createANewCustomerInRepository() {

		Customer customerDB = sut.create(new Customer("John Doe", "2 rue de l'ecureuil"));
		Optional<Customer> resultat = customerRepository.findById(customerDB.getId());
		assertTrue(resultat.isPresent());
	}

}

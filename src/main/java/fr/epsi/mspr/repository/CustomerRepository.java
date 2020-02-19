package fr.epsi.mspr.repository;

import org.springframework.data.repository.CrudRepository;

import fr.epsi.mspr.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

package fr.epsi.mspr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String adresse;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param adresse
	 */
	public Customer(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
	}
	
	
}

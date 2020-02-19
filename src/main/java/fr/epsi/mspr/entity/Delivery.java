package fr.epsi.mspr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "delivery")
public class Delivery {
	
	private static final String FRENCH_DATE_FORMAT = "dd/MM/yyyy";

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Drone drone;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = FRENCH_DATE_FORMAT)
	private Date dateDeLivraison;
	
	@OneToOne
	private Customer customer;
	
	/**
	 * @param id
	 * @param drone
	 * @param dateDeLivraison
	 * @param customer
	 */
	public Delivery(Drone drone, Date dateDeLivraison,Customer customer) {
		super();
		//this.id = id;
		this.drone = drone;
		this.dateDeLivraison = dateDeLivraison;
		this.customer=customer;
	}
	
	public Delivery() {
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public Date getDateDeLivraison() {
		return dateDeLivraison;
	}

	public void setDateDeLivraison(Date dateDeLivraison) {
		this.dateDeLivraison = dateDeLivraison;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}

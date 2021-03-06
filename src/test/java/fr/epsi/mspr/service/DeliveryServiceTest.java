package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.epsi.mspr.entity.Customer;
import fr.epsi.mspr.entity.Delivery;
import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.repository.DeliveryRepository;

@SpringBootTest
class DeliveryServiceTest {

	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private DroneService droneService;
	@Autowired
	private CustomerService customerService;

	@Autowired
	private DeliveryService sut;

	@Test
	void createDelivery_createANewDeliveryInRepository() throws Exception {
		Date dateDeLivraison = new Date();
		Drone drone = droneService.create(new Drone("test", 0, 0, 0, null));
		Customer customer = customerService.create(new Customer("John Doe", "2 rue de l'ecureuil"));

		Delivery delivery = new Delivery(drone, dateDeLivraison, customer);
		Delivery deliveryDB = sut.create(delivery);

		Optional<Delivery> resultat = deliveryRepository.findById(deliveryDB.getId());
		assertTrue(resultat.isPresent());
	}

	@Test
	void deleteDelivery_deleteADeliveryInRepositoryById() throws Exception {
		Date dateDeLivraison = new Date();
		Drone drone = droneService.create(new Drone("test", 0, 0, 0, null));
		Customer customer = customerService.create(new Customer("John Doe", "2 rue de l'ecureuil"));
		Delivery delivery = sut.create(new Delivery(drone, dateDeLivraison, customer));

		sut.erase(delivery);

		Optional<Delivery> resultat = deliveryRepository.findById(delivery.getId());
		assertFalse(resultat.isPresent());
	}
	
	@Test
	void updateDelivery_updateADeliveryeInRepository() throws Exception {
		Date dateDeLivraison = new Date();
		Drone drone = droneService.create(new Drone("test", 0, 0, 0, null));
		Customer customer = customerService.create(new Customer("John Doe", "2 rue de l'ecureuil"));
		Customer customerUpdate = customerService.create(new Customer("John Doe", "15 rue de la marmotte"));
		Delivery delivery = sut.create(new Delivery(drone, dateDeLivraison, customer));
		
		sut.update(delivery.getId(),drone,dateDeLivraison,customerUpdate);
		
		
		Optional<Delivery> resultat = deliveryRepository.findById(delivery.getId());
		assertNotEquals(delivery, resultat);
	}

}

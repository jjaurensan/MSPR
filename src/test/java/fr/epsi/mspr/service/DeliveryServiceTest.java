package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
	private DeliveryService sut;

	@Test
	void createDelivery_createANewDeliveryInRepository() throws Exception {
		Date dateDeLivraison = new Date();
		Drone drone = new Drone();
		Customer customer = new Customer();

		Delivery delivery = new Delivery(drone, dateDeLivraison, customer);
		sut.create(delivery);

		Optional<Delivery> resultat = deliveryRepository.findById(delivery.getId());
		assertTrue(resultat.isPresent());
	}

}

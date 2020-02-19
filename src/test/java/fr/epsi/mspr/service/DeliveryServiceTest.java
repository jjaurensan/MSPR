package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	private DeliveryService sut;

	@Test
	void createDelivery_createANewDeliveryInRepository() throws Exception {
		Date dateDeLivraison = new Date();
		Drone drone =droneService.create(new Drone("test", 0, 0, 0, null)) ;
		 

		Delivery delivery = new Delivery(drone, dateDeLivraison);
		Delivery deliveryDB = sut.create(delivery);

		Optional<Delivery> resultat = deliveryRepository.findById(deliveryDB.getId());
		assertTrue(resultat.isPresent());
	}

}

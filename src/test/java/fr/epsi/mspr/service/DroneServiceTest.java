package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import antlr.collections.List;
import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.entity.Etat;
import fr.epsi.mspr.repository.DroneRepository;

@SpringBootTest
class DroneServiceTest {

	@Autowired
	private DroneService sut;

	@Autowired
	private DroneRepository droneRepo;

	@Test
	void createDrone_sauveLeDroneDansLeRepository() throws Exception {

		Drone drone = new Drone("nom drone 1", 1, 2, 3, Etat.ARRET);

		Drone droneDb = sut.create(drone);
		Optional<Drone> resultat = droneRepo.findById(droneDb.getId());
		assertTrue(resultat.isPresent());
	}

	@Test
	void readAllDrone_InRepository() throws Exception {
		int c=0;

		sut.create(new Drone("nom drone 1", 1, 2, 3, Etat.ARRET));

		Iterable<Drone> d = sut.findAll();
		for (Drone drone : d) c++;
		assertTrue(c > 0);
	}

	@Test
	void afficheLaBonneDescription() throws Exception {

		Drone droneTest = sut.create(new Drone("nom drone 1", 1, 2, 3, Etat.ARRET));

		assertEquals("nom drone 1", droneTest.toString());
	}	
	
	@Test
	void affichelaBonnePosY() throws Exception {

		Drone droneTest = sut.create(new Drone("nom drone 1", 1, 2, 3, Etat.ARRET));

		assertEquals(2.0, droneTest.getPosY());
	}
}
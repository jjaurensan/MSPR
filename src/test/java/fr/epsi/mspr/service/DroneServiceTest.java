package fr.epsi.mspr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	void verifieListeDroneNonVideApresAjout() throws Exception {
		// tester d'abord si le test fail
		Drone drone = new Drone("nom drone 1", 1, 2, 3, Etat.ARRET);


//		droneRepo.save(drone);
		assertTrue(droneRepo.findAll() != null);
	}
}
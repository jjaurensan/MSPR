package fr.epsi.mspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.service.DroneService;
import fr.epsi.mspr.service.exception.DroneDejaExistantException;
import fr.epsi.mspr.service.exception.DroneNonExistantException;

@RestController
public class DroneController {

	@Autowired
	private DroneService droneService;

// voir pour WebMvcLinkBuilder pour les réponses http plus tard
	@GetMapping("/drones" )
	@CrossOrigin
	public Iterable<Drone> getAll() {
		return droneService.findAll();
	}

	@GetMapping("/drones/{id}" )
	public Drone getById(@PathVariable long id) throws DroneNonExistantException {
		return droneService.findById(id).get();
	}

	@PostMapping(path = "/drones")
	public Drone createDrone(@RequestBody Drone drone) throws DroneDejaExistantException {

		return droneService.create(drone);
	}

	@PutMapping(path = "/drones/{id},{posX},{posY}")
	public Drone updateDrone(@PathVariable long id, @PathVariable float posX, @PathVariable float posY) throws DroneNonExistantException  {
		Drone updatedDrone = droneService.findById(id).get();
		updatedDrone.setPosX(posX);
		updatedDrone.setPosY(posY);
		
		return updatedDrone;
	}
}
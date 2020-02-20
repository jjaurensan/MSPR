package fr.epsi.mspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.service.DroneDejaExistantException;
import fr.epsi.mspr.service.DroneService;

@RestController
public class DroneController {

	@Autowired
	private DroneService droneService;

// voir pour WebMvcLinkBuilder pour les réponses http plus tard
	@GetMapping("/drones" )
	public Iterable<Drone> getAll() {
		return droneService.findAll();
	}

	@PostMapping(path = "/drones")
	public  Drone createDrone(@RequestBody Drone drone) throws DroneDejaExistantException {

		return droneService.create(drone);
	}
}
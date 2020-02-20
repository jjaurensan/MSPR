package fr.epsi.mspr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.mspr.service.DroneService;

@RestController
public class DroneController {

	@Autowired
	private DroneService droneService;

// voir pour WebMvcLinkBuilder pour les réponses http plus tard
	@GetMapping("/drones" )
	public String getAll() {
		
	//Iterable<Drone> getAll() throws DroneDejaExistantException {
		return "test";
	}
//
//	@PostMapping(path = "/drones/{1}")
//	Iterable<Drone> getAll() throws DroneDejaExistantException {
//		return droneService.findAll();
//	}
}
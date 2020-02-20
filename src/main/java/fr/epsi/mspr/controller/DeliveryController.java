package fr.epsi.mspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.mspr.entity.Delivery;
import fr.epsi.mspr.service.DeliveryService;

@RestController
public class DeliveryController {
	@Autowired
	private DeliveryService deliveryService;
	
	
	@GetMapping("/delivery")
	public Iterable<Delivery> getAll() throws Exception {
		
		
		return deliveryService.getAll();
	}
}

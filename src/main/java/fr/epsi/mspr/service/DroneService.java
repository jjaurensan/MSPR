package fr.epsi.mspr.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.repository.DroneRepository;

@Service
public class DroneService {
	
	@Autowired
	private DroneRepository droneRepository;

	@Transactional
	public Drone create(Drone drone) throws DroneDejaExistantException {
		if (droneRepository.existsById(drone.getId())) {
			throw new DroneDejaExistantException("Le drone avec l'id " + drone.getId() + " existe déjà");
		}
		return droneRepository.save(drone);
	}
}


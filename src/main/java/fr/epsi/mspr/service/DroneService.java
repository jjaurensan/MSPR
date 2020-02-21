package fr.epsi.mspr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.repository.DroneRepository;
import fr.epsi.mspr.service.exception.DeliveryNotExistException;
import fr.epsi.mspr.service.exception.DroneDejaExistantException;
import fr.epsi.mspr.service.exception.DroneNonExistantException;

@Service
public class DroneService {
	
	@Autowired
	private DroneRepository droneRepository;

	@Transactional
	public Drone create(Drone drone) throws DroneDejaExistantException {
		if (droneRepository.existsById(drone.getId()))
			throw new DroneDejaExistantException("Le drone avec l'id " + drone.getId() + " existe déjà");

		return droneRepository.save(drone);
	}

	public List<Drone> findAll() {
		return droneRepository.findAll(); 
	}

	public Optional<Drone> findById(long id) throws DroneNonExistantException {
		
		if (!droneRepository.existsById(id))
			throw new DroneNonExistantException("Le drone n'existe pas");

		return droneRepository.findById(id);
	}

	public List<Drone> findByNom(String nom) throws DroneNonExistantException {
		
		return droneRepository.findByNom(nom);
	}

	public Drone update(Drone droneToUpdate) throws DroneNonExistantException {
		if (!droneRepository.existsById(droneToUpdate.getId()))
			throw new DroneNonExistantException("Le drone n'existe pas");

		return droneRepository.save(droneToUpdate);
	}	
}


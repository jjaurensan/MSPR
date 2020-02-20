package fr.epsi.mspr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.epsi.mspr.entity.Drone;

public interface DroneRepository extends CrudRepository<Drone, Long> {

	List<Drone> findByNom(String nom);
	
	
}

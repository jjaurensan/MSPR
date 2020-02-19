package fr.epsi.mspr.repository;

import org.springframework.data.repository.CrudRepository;

import fr.epsi.mspr.entity.Drone;

public interface DroneRepository extends CrudRepository<Drone, Long> {

}

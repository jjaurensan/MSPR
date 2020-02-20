package fr.epsi.mspr.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epsi.mspr.entity.Customer;
import fr.epsi.mspr.entity.Delivery;
import fr.epsi.mspr.entity.Drone;
import fr.epsi.mspr.repository.DeliveryRepository;
import fr.epsi.mspr.service.exception.DeliveryNotExistException;

@Service
public class DeliveryService {

	@Autowired
	DeliveryRepository deliveryRepository;

	@Transactional
	public Delivery create(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Transactional
	public void erase(Delivery delivery) throws DeliveryNotExistException {
		if (!deliveryRepository.existsById(delivery.getId())) {
			throw new DeliveryNotExistException("This delivery is not found for delete");
		}
		deliveryRepository.delete(delivery);

	}

	@Transactional
	public Delivery update(Long id, Drone drone, Date dateDeLivraison, Customer customer)
			throws DeliveryNotExistException {
		if (!deliveryRepository.existsById(id)) {
			throw new DeliveryNotExistException("This delivery is not found for a update");
		}
		Delivery delivery = deliveryRepository.findById(id).get();
		delivery.setDrone(drone);
		delivery.setDateDeLivraison(dateDeLivraison);
		delivery.setCustomer(customer);

		return delivery;
	}

	public Iterable<Delivery> getAll() {
		return deliveryRepository.findAll();
	}

}

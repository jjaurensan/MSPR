package fr.epsi.mspr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epsi.mspr.entity.Delivery;
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

	public void erase(Delivery delivery) throws DeliveryNotExistException {	
		if(!deliveryRepository.existsById(delivery.getId())) {
			throw new DeliveryNotExistException("This delivery is not found");
		}
		
		
	}

}

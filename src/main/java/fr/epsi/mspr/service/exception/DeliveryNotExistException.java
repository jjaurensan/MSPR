package fr.epsi.mspr.service.exception;

public class DeliveryNotExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public DeliveryNotExistException(String message) {
		super(message);
	}
}
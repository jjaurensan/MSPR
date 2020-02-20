package fr.epsi.mspr.service.exception;

public class DroneNonExistantException extends Exception {
	private static final long serialVersionUID = 1L;

	public DroneNonExistantException (String message) {
		super(message);
	}
}

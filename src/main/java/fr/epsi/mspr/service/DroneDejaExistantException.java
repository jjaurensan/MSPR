package fr.epsi.mspr.service;

public class DroneDejaExistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public DroneDejaExistantException(String message) {
			super(message);
		}
}

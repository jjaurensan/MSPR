package fr.epsi.mspr.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Drone {

	@Id
	private long id;
	private String nom;
	private int posX;
	private int posY;
	private int posZ;
	private Etat etat;
	
	public Drone(String nom, int posX, int posY, int posZ, Etat etat) {
		this.nom = nom;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.etat = etat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosZ() {
		return posZ;
	}
	public void setPosZ(int posZ) {
		this.posZ = posZ;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	
}

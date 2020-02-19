package fr.epsi.mspr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private float posX;
	private float posY;
	private float posZ;
	private Etat etat;
	
	public Drone() {		
	}
	
	public Drone(String nom, float posX, float posY, float posZ, Etat etat) {
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
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public float getPosZ() {
		return posZ;
	}
	public void setPosZ(float posZ) {
		this.posZ = posZ;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
//		return "Drone [id=" + id + ", nom=" + nom + ", posX=" + posX + ", posY=" + posY + ", posZ=" + posZ + ", etat="
//				+ etat + "]";
		return nom;
	}

}

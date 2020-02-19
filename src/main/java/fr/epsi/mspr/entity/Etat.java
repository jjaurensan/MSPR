package fr.epsi.mspr.entity;

public enum Etat {
	ARRET(1), 
	CHARGE(2), 
	LIVRAISON(3), 
	MAINTENANCE(4);
	
	private int etatCourant;

	Etat(int e) {
		this.etatCourant = e;
	}

	public int getEtat() {
		return this.etatCourant;
	}
	
}
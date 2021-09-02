package com.models;

public class Pilote extends User {
	float salaire;
	int heuresDeVol;

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public int getHeuresDeVol() {
		return heuresDeVol;
	}

	public void setHeuresDeVol(int heuresDeVol) {
		this.heuresDeVol = heuresDeVol;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		Pilote vol2 =(Pilote) obj;
		return id.equals(vol2.getId());
	}
	
	@Override
	public String toString() {
		return prenom + " " + nom;
	}

}

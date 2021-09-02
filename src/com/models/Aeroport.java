package com.models;

public class Aeroport extends Model {
	String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		Aeroport vol2 =(Aeroport) obj;
		return id.equals(vol2.getId());
	}
}

package com.models;

public class User extends Model {

	protected String nom, prenom, email, mdp;

	public User() {
	}

	public User(Long id, String nom, String prenom, String login, String mdp, String avatar) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = login;
		this.mdp = mdp;
	}

	public User(String nom, String prenom, String login, String mdp, String avatar) {

		this.nom = nom;
		this.prenom = prenom;
		this.email = login;
		this.mdp = mdp;


	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		User vol2 =(User) obj;
		return id.equals(vol2.getId());
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + email + ", mdp=" + mdp + "]";
	}

}

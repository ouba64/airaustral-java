package com.models;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import com.utility.DBConnection;

public class Vol extends Model {

	Avion avion;
	private String nomVol;
	Aeroport depart;
	Aeroport destination;
	private Date heureDepart;
	private Date heureArrivee;
	private Pilote pilote;

	public Vol() {
		// TODO Auto-generated constructor stub
	}

	public Vol(String nomVol, String destination, Date heureDepart, Date heureArrivee, String nomPilote) {
		super();
		this.nomVol = nomVol;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public Vol(long id, String nomVol, String destination) {
		super();
		this.id = id;
		this.nomVol = nomVol;
	}



	public String getNomVol() {
		return nomVol;
	}

	public void setNomVol(String nomVol) {
		this.nomVol = nomVol;
	}

	public Aeroport getDestination() {
		return destination;
	}

	public void setDestination(Aeroport destination) {
		this.destination = destination;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}
	
	
	
	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}


	@Override
	public String toString() {
		return "Vol [id=" + id + ", nomVol=" + nomVol + ", destination=" + destination + ", heureDepart=" + heureDepart
				+ ", heureArrivee=" + heureArrivee + "]";
	}

}

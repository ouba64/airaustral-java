package com.app;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.controllers.ReservationController;
import com.controllers.VolController;
import com.models.Reservation;

public class Main {

	public static void main(String[] args) {
		
//		UserController userController = new UserController();
//		int id = 1;
//		try {
//			User user = new User();
//			user.setId(id);
//			user.setMdp("new password");
//			userController.modifier(user);
//			User u = userController.findById(id);
//			System.out.println(u);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		//test vol
		
		VolController volController = new VolController();
		//LocalDateTime heureDepart = LocalDateTime.now();
		LocalDateTime heureDarrivee = LocalDateTime.now();
		LocalDate dateVol = LocalDate.now();
		
		ReservationController uneReservation = new ReservationController();
		LocalTime heureDepart = LocalTime.now();
		LocalDate dateRes = LocalDate.now();
		
//		//test ajout vol
	/*	Reservation reservation = new Reservation("code3", "Raba", "business", "nom2", "prenom2 ", heureDepart,dateRes);
		try {
			uneReservation.ajouter(reservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//test update reservation
//		Reservation reservation = new Reservation("code1", "Paris", "economique", "nom1", " prenom ", heureDepart, dateRes);
//		reservation.setcodPassager("code1");
//		try {
//			ReservationController.modifier(reservation);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//test suppression reservation
		
//		Reservation reservation = new Reservation("code1", "Paris", "economique", "nom1", " prenom ", heureDepart, dateRes);
//		reservation.setcodPassager("code1");
//		try {
//			uneReservation.supprimer(reservation);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		//test ajout vol
//		Vol vol = new Vol("vol1", "destination", heureDepart, heureDarrivee, "Pilote 1", dateVol);
//		try {
//			volController.ajouter(vol);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//test update vol
//		Vol vol = new Vol("vol1", "Paris", heureDepart, heureDarrivee, "Pilote updated 1", dateVol);
//		vol.setId(1);
//		try {
//			volController.modifier(vol);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//test suppression vol
		
//		Vol vol = new Vol("vol1", "Paris", heureDepart, heureDarrivee, "Pilote updated 1", dateVol);
//		vol.setId(2);
//		try {
//			volController.supprimer(vol);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		//test find by destination
		
//		try {
//			ArrayList<Vol> reservations = volController.findByDestination("pARIs");
//			reservations.forEach(System.out::println);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//test find by date vol
		
//		try {
//			LocalDate date = LocalDate.of(2020, 02, 15);
//			ArrayList<Vol> reservations = volController.findByDateVol(date);
//			reservations.forEach(System.out::println);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}

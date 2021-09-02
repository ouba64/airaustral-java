package com.controllers;

import java.awt.event.ActionEvent;

import com.models.Reservation;
import com.models.dao.ReservationDao;
import com.views.ListeReservationsView;
import com.views.ListeVolsView;
import com.views.MonJButton;
import com.views.View;

public class ListeReservationsController extends Controller {
	View view;
	ReservationDao reservationDao;
	public ListeReservationsController() {
		reservationDao = new ReservationDao();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		gererActionsCommunes(panelView.getView(), action);
		switch (action) {

		case "Suppression":
			MonJButton<Reservation> button = (MonJButton<Reservation>) e.getSource();
			button = (MonJButton<Reservation>) e.getSource();
			Reservation reservation = button.getObject();
			try {
				reservationDao.supprimer(reservation);
				ListeReservationsView listeVolsView = (ListeReservationsView)panelView;
				listeVolsView.supprimerLigne(button.getPosition());
				panelView.getView().afficherSuppressionReservation(reservation);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
}

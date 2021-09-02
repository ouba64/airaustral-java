package com.controllers;

import java.awt.event.ActionEvent;
import java.util.List;

import com.models.CriteresReservation;
import com.models.CriteresVol;
import com.models.Reservation;
import com.models.Vol;
import com.models.dao.ReservationDao;

public class RechercheReservationControlleur extends Controller {
	ReservationDao reservationDao;

	public RechercheReservationControlleur() {
		reservationDao = new ReservationDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gererActionsCommunes(panelView.getView(), e.getActionCommand());
		List<Reservation> reservations = null;
		String action = e.getActionCommand();
		switch (action) {
			case "Rechercher":
				CriteresReservation criteresVol = (CriteresReservation) panelView
						.fillAndGetModel();
				try {
					reservations = reservationDao.chercher(criteresVol);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				panelView.getView().afficherListeReservations(reservations);
				break;
		}
	}
}

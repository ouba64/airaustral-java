package com.controllers;

import java.awt.event.ActionEvent;

import com.models.User;
import com.models.Vol;
import com.views.LoginView;
import com.views.View;

public class GeneralController extends Controller {
	View view;

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		gererActionsCommunes(view, action);
		switch (action) {
		case "GestionVol":
			view.afficherGestionVol(true);
			break;
		case "GestionReservations":
			view.afficherRechercheReservation();
			break;
		case "AjoutVol":
			view.afficherRepresentationVol(new Vol(), true);	
			break;
		case "ModificationSuppressionVol":
			view.afficherRechercheVols();
			break;

		/*case "RetourAListeReservations":
			view.afficherListeReservations(reservations);
			break;*/
		case "RetourAGestionView":
			view.afficherGestion();	
			break;
		case "Deconnexion":
			view.afficherLogin();	
			break;			
		}
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}

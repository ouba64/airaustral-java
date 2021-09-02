package com.controllers;

import java.awt.event.ActionEvent;

import com.models.Vol;
import com.models.dao.VolDao;
import com.views.ListeVolsView;
import com.views.MonJButton;
import com.views.View;

public class ListeVolsController extends Controller {
	View view;
	VolDao volDao;
	
	public ListeVolsController() {
		volDao = new VolDao();
	}
	
	public void supprimerVol(Vol vol, int position){
		try {
			volDao.supprimer(vol);
			ListeVolsView listeVolsView = (ListeVolsView)panelView;
			listeVolsView.supprimerLigne(position);
			view.afficherSuppressionVolView(vol);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		
		gererActionsCommunes(view, action);
		Vol vol;
		switch (action) {
		case "RetourALaRecherche":
			view.afficherRechercheVols();
			break;
		case "Modification":
			MonJButton<Vol> button = (MonJButton<Vol>) e.getSource();
			vol = button.getObject();
			boolean isAjout = false;
			view.afficherRepresentationVol(vol, isAjout);
			break;
		case "Suppression":
			button = (MonJButton<Vol>) e.getSource();
			vol = button.getObject();
			int position = button.getPosition();
			supprimerVol(vol, position);
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

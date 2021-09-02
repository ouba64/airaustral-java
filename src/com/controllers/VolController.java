package com.controllers;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import com.models.User;
import com.models.Vol;
import com.models.dao.VolDao;
import com.views.PanelView;
import com.views.RepresentationVolView;

public class VolController extends Controller{
	VolDao volDao;
	public VolController(PanelView panelView) {
		super(panelView);
		volDao = new VolDao();
	}

	public VolController() {
		volDao = new VolDao();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		gererActionsCommunes(panelView.getView(), action);
		RepresentationVolView representationVolView = (RepresentationVolView) panelView;
		Vol vol = (Vol) representationVolView.fillAndGetModel();
		boolean isAjout = representationVolView.isAjout();
		switch(action) {
		
		case "GererVol":
			// on fait de l'ajout
			if(isAjout) {
				try {
					volDao.enregistrer(vol);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelView.getView().afficherGestionVol(false);
			}
			// on fait de la modification
			else {
				try {
					volDao.modifier(vol);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelView.getView().afficherGestionVol(false);
			}
			break;
		}
	}

}

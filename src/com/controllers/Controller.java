package com.controllers;

import java.awt.event.ActionListener;

import com.models.dao.Dao;
import com.views.PanelView;
import com.views.View;

public abstract class Controller implements ActionListener {
	PanelView panelView;

	public Controller() {
		
	}

	public Controller(PanelView panelView) {
		this.panelView = panelView;
	}

	public PanelView getPanelView() {
		return panelView;
	}

	public void setPanelView(PanelView panelView) {
		this.panelView = panelView;
	}
	
	/**
	 * Actions a �ventuellement effectuer. Ces actions (logout, home) sont ger�es par tous les controlleurs.
	 * @param view
	 * @param action
	 */
	public void gererActionsCommunes(View view, String action) {
		switch (action) {
		case "Prev":
			view.afficherPrecedent();
			break;
		case "Logout":
			view.setUser(null);
			view.afficherLogin();
			break;
		case "Home":
			view.afficherGestion();
			break;
		}
	}
	
}

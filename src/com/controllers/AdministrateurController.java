
package com.controllers;

import java.awt.event.ActionEvent;

import com.models.Administrateur;
import com.models.User;
import com.models.dao.UserDao;
import com.views.LoginView;
import com.views.PanelView;


public class AdministrateurController extends Controller{
	UserDao userDao;
	
	public AdministrateurController(PanelView panelView) {
		userDao = new UserDao();
		this.panelView = panelView;
	}

	public AdministrateurController() {
		userDao = new UserDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();

		LoginView loginView = (LoginView) panelView;
		gererActionsCommunes(panelView.getView(), action);
		switch(action) {
		case "Login":
			Administrateur userCandidat = (Administrateur) panelView.fillAndGetModel();
			Administrateur userTrouve = userDao.find(userCandidat);
			// si ok
			if(userTrouve !=null){
				loginView.afficherMessageErreur(false);
				loginView.getView().setUser(userTrouve);
				loginView.getView().afficherGestion();
			}
			// si not ok
			else {
				loginView.afficherMessageErreur(true);
			}
			break;
		}	
	}
}

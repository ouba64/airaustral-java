package com.controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import com.models.CriteresVol;
import com.models.Vol;
import com.models.dao.UserDao;
import com.models.dao.VolDao;

public class RechercheVolControlleur extends Controller {
	VolDao volDao;
	public RechercheVolControlleur() {
		volDao = new VolDao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		gererActionsCommunes(panelView.getView(), action);
		switch (action) {
		case "RechercheVol":
			List<Vol> vols = null;
			CriteresVol criteresVol = (CriteresVol) panelView.fillAndGetModel();

			try {
				vols = volDao.chercher(criteresVol);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			panelView.getView().afficherListeVols(vols);
			break;

		}
	}
}

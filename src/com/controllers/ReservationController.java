package com.controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import com.models.Reservation;
import com.views.PanelView;

public class ReservationController extends Controller{
	
	public ReservationController(PanelView panelView) {
		super(panelView);
	}

	public ReservationController() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		gererActionsCommunes(panelView.getView(), action);
	}

}

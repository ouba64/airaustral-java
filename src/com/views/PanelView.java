package com.views;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.controllers.Controller;
import com.models.Model;

public abstract class PanelView extends JPanel {

	com.models.Model model;
	View view;
	Controller controller;

	PanelView panelViewPrec;
	
	
	public PanelView(Controller controller) {
		this.controller = controller;
	}

	public com.models.Model getModel() {
		return model;
	}

	public void setModel(com.models.Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}
	
	

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Elle lit les information de la fenetre et construit le modele correspondant.
	 * Par exemple, pour la page Login, elle lit le login et mdp et construit un
	 * utilisateur.
	 */
	public abstract Model fillAndGetModel();
	
	public abstract void displayModel(Model model);

	public java.util.Date convertirEnDate(LocalDateTime localDateTime) {
		if(localDateTime==null){
			return null;
		}

		LocalDateTime now = LocalDateTime.now();
		ZoneId zoneId =ZoneId.systemDefault();
		ZoneOffset zoneOffSet = zoneId.getRules().getOffset(now);
		Instant instant = localDateTime.toInstant(zoneOffSet);
	    Date date = Date.from(instant);
		return date;
	}
	
	public  LocalDateTime convertirEnLocalDateTime(java.util.Date date) {
		if(date==null){
			return null;
		}
		 Instant instant = Instant.ofEpochMilli(date.getTime());
		 ZoneId zoneId = ZoneId.systemDefault();
		 LocalDateTime ldt = LocalDateTime.ofInstant(instant, zoneId);
		 return ldt;
	}
	
	public static long obtenirDifferenceEnMinutes(java.util.Date d1, java.util.Date d2){
		long diff = d2.getTime() - d1.getTime();
		long diffMinutes = diff / (60 * 1000);
		return diffMinutes;
	}
	
	public static Date ajouterMinutes(java.util.Date d1, long minutes){
		long date = d1.getTime() + minutes * 60 * 1000;
		Date d2 = new Date(date);
		return d2;
	}
	
	
	public String transformerChaineVideEnNull(String s){
		if(s!=null && s.length()>0){
			return s;
		}
		return null;
	}

	public Long convertirEnLong(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public PanelView getPanelViewPrec() {
		return panelViewPrec;
	}

	public void setPanelViewPrec(PanelView panelViewPrec) {
		this.panelViewPrec = panelViewPrec;
	}

	public void afficherPrecedent() {
		JFrame frame = view.getFrame();
		view.getFrame().setContentPane(panelViewPrec);
		frame.pack();
	}
	
	

}

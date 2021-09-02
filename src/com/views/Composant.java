package com.views;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.controllers.Controller;

public class Composant extends JPanel {
	/**
	 * 0-> prev
	 * 1-> home
	 * 2-> logout
	 * @param controleur
	 * @param on
	 */
	public Composant(Controller controleur, boolean[] on) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(GestionVolView.class.getResource("/image/home-p.png")));
		btnHome.setActionCommand("Home");
		btnHome.addActionListener(controleur);
		
		JButton btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(GestionVolView.class.getResource("/image/logout-p.png")));
		btnLogout.setActionCommand("Logout");
		btnLogout.addActionListener(controleur);
		
		JButton btnPrev = new JButton("");
		btnPrev.setIcon(new ImageIcon(GestionVolView.class.getResource("/image/prev.png")));
		btnPrev.setActionCommand("Prev");
		btnPrev.addActionListener(controleur);
		
		add(btnPrev);
		add(btnHome);
		add(btnLogout);
		
		if(!on[0]){
			btnPrev.setVisible(false);
		}
		if(!on[1]){
			btnHome.setVisible(false);
		}
		if(!on[2]){
			btnLogout.setVisible(false);
		}

	}


}

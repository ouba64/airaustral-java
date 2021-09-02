package com.views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controllers.Controller;
import com.models.Model;
import com.models.Vol;

import java.awt.Color;

public class SuppressionVolView extends PanelView {
	JLabel lblMessage;
	/**
	 * Create the panel.
	 */
	public SuppressionVolView(Controller controlleur) {
		super(controlleur);
		lblMessage = new JLabel("");
		lblMessage.setBackground(Color.ORANGE);
		
		Composant composant = new Composant((Controller) controlleur, new boolean[] {true, true, true});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMessage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(composant, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(composant, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void afficherMessage(Vol vol){
		String message = "Le vol " +vol.getNomVol() + " a été supprimé.";
		lblMessage.setText(message);
	}

	@Override
	public Model fillAndGetModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayModel(Model model) {
		// TODO Auto-generated method stub
		
	}
}

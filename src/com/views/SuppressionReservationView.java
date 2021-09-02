package com.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controllers.Controller;
import com.models.Model;
import com.models.Reservation;

public class SuppressionReservationView extends PanelView {
	JLabel lblMessage;
	/**
	 * Create the panel.
	 */
	public SuppressionReservationView(Controller controller) {
		super(controller);
		lblMessage = new JLabel("New label");
		lblMessage.setBackground(Color.ORANGE);
		
		Composant composant = new Composant((Controller) controller, new boolean[] {true, true, true});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMessage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(composant, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(composant, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addGap(45))
		);
		setLayout(groupLayout);
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

	public void afficherMessage(Reservation reservation) {
		
		String prenomNom = reservation.getClient().getPrenom() + " " + reservation.getClient().getNom();
		lblMessage.setText("La réservation de " + prenomNom + " a été supprimée avec succès");
	}
}

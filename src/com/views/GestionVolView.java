package com.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controllers.Controller;
import com.models.Model;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class GestionVolView extends PanelView {

	/**
	 * Create the panel.
	 */
	public GestionVolView(Controller controleur) {
		// notre code
		super(controleur);
		
		
		// code WindowBuilder
		JButton btnAjoutVol = new JButton("Ajout Vol");
		
		JButton btnModifSupp = new JButton("Modification ou Suppression Vol");
		btnModifSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Composant composant = new Composant((Controller) controleur, new boolean[] {true, true, true});
		
		JLabel lblTitre = new JLabel("Gestion Vol");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(198)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnModifSupp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAjoutVol, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
							.addComponent(composant, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(composant, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addComponent(btnAjoutVol, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addComponent(btnModifSupp, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		

		

		// notre code
		btnAjoutVol.addActionListener(controleur);
		btnAjoutVol.setActionCommand("AjoutVol");
		
		btnModifSupp.addActionListener(controleur);
		btnModifSupp.setActionCommand("ModificationSuppressionVol");
		setLayout(groupLayout);
		

	}

	@Override
	public Model fillAndGetModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayModel(Model model) {

	}
}

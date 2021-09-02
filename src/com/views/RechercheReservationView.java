package com.views;

import javax.swing.JPanel;

import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.controllers.Controller;
import com.models.Aeroport;
import com.models.Model;
import com.models.Pilote;
import com.models.CriteresVol;
import com.models.CriteresReservation;
import com.models.User;
import com.models.Vol;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class RechercheReservationView extends PanelView {
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNomVol;

	JComboBox<Aeroport> cbDepart;

	JComboBox<Aeroport> cbArrivee;

	/**
	 * Create the panel.
	 * @param aeroports TODO
	 */
	public RechercheReservationView(Controller controler, Vector<Aeroport> aeroports) {
		super(controler);
		JLabel lblNomDuVol = new JLabel("Nom du vol");

		JLabel lblArrive = new JLabel("Destination");

		JLabel lblDpart = new JLabel("Départ");

		JLabel lblPrnomClient = new JLabel("Prénom client");

		JLabel lblTitre = new JLabel("Nom client");

		txtNom = new JTextField();
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);

		txtNomVol = new JTextField();
		txtNomVol.setColumns(10);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setActionCommand("Rechercher");

		Composant composant = new Composant((Controller) controler,
				new boolean[] { true, true, true });

		cbDepart = new JComboBox<>(aeroports);
		cbArrivee = new JComboBox<>(aeroports);
		
		JLabel lblRechercherUneRservation = new JLabel("Rechercher une réservation");
		lblRechercherUneRservation.setFont(new Font("Tahoma", Font.PLAIN, 22));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(102)
							.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(417)
							.addComponent(btnRechercher, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDpart, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbDepart, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPrnomClient, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblArrive, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cbArrivee, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNomDuVol, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblRechercherUneRservation, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
							.addComponent(composant, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(composant, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRechercherUneRservation, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTitre)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPrnomClient))
						.addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDpart)
						.addComponent(cbDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArrive)
						.addComponent(cbArrivee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNomDuVol))
						.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addComponent(btnRechercher)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		btnRechercher.addActionListener(controler);
	}

	@Override
	public Model fillAndGetModel() {
		CriteresReservation criteres = (CriteresReservation) model;
		if(criteres == null){
			criteres = new CriteresReservation();
			model = criteres;
		}
		// on creer un nouveau vol
		// String id = txtIdVol.getText();
		String nom = transformerChaineVideEnNull(txtNom.getText());
		String prenom = transformerChaineVideEnNull(txtPrenom.getText());

		Aeroport depart = (Aeroport) cbDepart.getSelectedItem();
		Aeroport arrivee = (Aeroport) cbArrivee.getSelectedItem();
		// java.sql.Date date = convertirEnDate(null);

		String nomVol = transformerChaineVideEnNull(txtNomVol.getText());

		User user = new User();
		Vol vol = new Vol();

		user.setPrenom(prenom);
		user.setNom(nom);
		vol.setDepart(depart);
		vol.setDestination(arrivee);
		vol.setNomVol(nomVol);

		criteres.setClient(user);
		criteres.setVol(vol);

		return criteres;
	}

	@Override
	public void displayModel(Model model) {
		// TODO Auto-generated method stub

	}
}

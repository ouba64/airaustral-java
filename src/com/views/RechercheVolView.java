package com.views;

import javax.swing.JLabel;
import javax.swing.JTextField;
import com.controllers.Controller;
import com.models.Aeroport;
import com.models.Model;
import com.models.Pilote;
import com.models.CriteresVol;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class RechercheVolView extends PanelView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDate;
	private JTextField txtNomVol;
	JComboBox<Aeroport> cbDepart;
	JComboBox<Aeroport> cdDestination;
	JComboBox<Pilote> cbPilote;
	
	/**
	 * Create the panel.
	 * @param aeroports 
	 * @param pilotes 
	 */
	public RechercheVolView(Controller controleur, Vector<Pilote> pilotes, Vector<Aeroport> aeroports) {
		super(controleur);
		
		JLabel label = new JLabel("Pilote");
		
		JLabel lblDate = new JLabel("Date");
		
		JLabel label_3 = new JLabel("Destination");
		
		JLabel label_4 = new JLabel("Depart");
		
		JLabel label_5 = new JLabel("Nom Vol");
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		
		txtNomVol = new JTextField();
		txtNomVol.setColumns(10);
		
		JButton btnRechercherVol = new JButton("Rechercher");
		
		
		btnRechercherVol.addActionListener(controleur);
		btnRechercherVol.setActionCommand("RechercheVol");
		
		cbDepart = new JComboBox<>(aeroports);
		
		cdDestination = new JComboBox<>(aeroports);
		
		cbPilote = new JComboBox<>(pilotes);
		
		Composant composant = new Composant((Controller) controleur, new boolean[] {true, true, true});
		
		JLabel lblTitre = new JLabel("Rechercher un vol");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRechercherVol, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(composant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(143)
							.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(cbDepart, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(cdDestination, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(cbPilote, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(composant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cdDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbPilote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnRechercherVol, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(76))
		);
		setLayout(groupLayout);

		model = new CriteresVol();
	}
	
	
	@Override
	public Model fillAndGetModel() {
		CriteresVol criteresVol = (CriteresVol) model;
		// on cre� un nouveau vol
		//String id = txtIdVol.getText();
		String nomVol = txtNomVol.getText();
		Pilote pilote = (Pilote) cbPilote.getSelectedItem();
		Aeroport depart = (Aeroport) cbDepart.getSelectedItem();
		Aeroport arrivee = (Aeroport) cdDestination.getSelectedItem();
		//java.sql.Date date = convertirEnDate(null);
		

		criteresVol.setNomVol(null);
		if(nomVol!=null && nomVol.length()>0){
			criteresVol.setNomVol(nomVol);
		}
		
		//regionVol.setHeureDepart(date);
		criteresVol.setPilote(pilote);
		criteresVol.setDepart(depart);
		criteresVol.setDestination(arrivee);
		
		return criteresVol;
	}


	@Override
	public void displayModel(Model model) {
		// TODO Auto-generated method stub
		
	}
}

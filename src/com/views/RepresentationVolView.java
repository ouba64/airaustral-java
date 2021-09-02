package com.views;

import javax.swing.JPanel;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Vector;

import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.controllers.Controller;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.models.Aeroport;
import com.models.Avion;
import com.models.Model;
import com.models.Pilote;
import com.models.Vol;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class RepresentationVolView extends PanelView {
	private JTextField txtNomVol;
	
    DateTimePicker dtDepart ;
    DateTimePicker dtArrivee ;
	JButton btnEnregistrer;
	JComboBox<Pilote> cbPilote;
	JComboBox<Avion> cbAvion;
	
	JComboBox<Aeroport> cbDepart;
	
	JComboBox<Aeroport> cbArrivee;
	private boolean isAjout;
	private JLabel lblTitre;
	private JLabel lblAvion;

	

	/**
	 * Create the panel.
	 * @param avions TODO
	 */
	public RepresentationVolView(Controller controller, Vector<Pilote> pilotes, Vector<Aeroport> aeroports, Vector<Avion> avions) {
		super(controller);
        // Create a DateTimePicker. (But don't add it to the form).
        dtDepart = new DateTimePicker();
        dtArrivee = new DateTimePicker();
		
		
		
		JLabel lblNomVol = new JLabel("Nom Vol");
		
		txtNomVol = new JTextField();
		txtNomVol.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		
		JLabel lblDate = new JLabel("Date et Heure Départ");
		
		//txtHeureDepart = new JTextField();
		//txtHeureDepart.setColumns(10);
		
		JLabel lblHeureDarrive = new JLabel("Date et Heure d'arrivée");
		
		//txtHeureArrivee = new JTextField();
		//txtHeureArrivee.setColumns(10);
		
		JLabel lblPilote = new JLabel("Pilote");
		
		btnEnregistrer = new JButton("Enregistrer");
		
		JLabel lblDepart = new JLabel("Depart");
		
		cbDepart = new JComboBox<>(aeroports);
		
		cbArrivee = new JComboBox<>(aeroports);
		
		cbPilote = new JComboBox<>(pilotes);
		
		Composant composant = new Composant(controller, new boolean[]{true, true, true});
		
		lblTitre = new JLabel("Vol");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));

		// notre code
		Vol vol = new Vol();
		this.model = vol;
		btnEnregistrer.addActionListener(controller);
		btnEnregistrer.setActionCommand("GererVol");
		
		lblAvion = new JLabel("Avion");
		
		cbAvion = new JComboBox<Avion>(avions);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addGap(242)
							.addComponent(composant, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNomVol)
							.addGap(178)
							.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDepart, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(cbDepart, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDestination, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(cbArrivee, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(dtDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHeureDarrive)
							.addGap(103)
							.addComponent(dtArrivee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPilote, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAvion, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(123)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(cbAvion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
									.addComponent(btnEnregistrer))
								.addComponent(cbPilote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(88)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomVol)
								.addComponent(txtNomVol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDepart))
								.addComponent(cbDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDestination))
								.addComponent(cbArrivee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblDate))
								.addComponent(dtDepart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHeureDarrive)
								.addComponent(dtArrivee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblPilote))
								.addComponent(cbPilote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(composant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEnregistrer)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(cbAvion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAvion)))
					.addGap(73))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public Model getModel() {
		return null;
	}

	@Override
	public Model fillAndGetModel() {
		Vol vol = (Vol) model;
		// on créé un nouveau vol
		//String id = txtIdVol.getText();
		String nomVol = txtNomVol.getText();

		
		Pilote pilote = (Pilote) cbPilote.getSelectedItem();
		//String pilote = txtPilote.getText();
		LocalDateTime  dateTimeStrict = dtDepart.getDateTimeStrict();
		LocalDateTime dateTime = dtDepart.getDateTimePermissive();
		java.util.Date heureDepart = convertirEnDate(dateTimeStrict);
		
		dateTimeStrict = dtArrivee.getDateTimeStrict();	
		java.util.Date heureArrivee = convertirEnDate(dateTimeStrict);
		//java.sql.Date heureArrivee =convertirEnDate(dtArrivee.getDateTimeStrict());
		
		Aeroport depart = (Aeroport) cbDepart.getSelectedItem();
		Aeroport arrivee = (Aeroport) cbArrivee.getSelectedItem();
		
		vol.setNomVol(nomVol);
		
		vol.setPilote(pilote);
		Avion avion = (Avion) cbAvion.getSelectedItem();
		vol.setAvion(avion);
		
		vol.setDepart(depart);
		vol.setDestination(arrivee);
		

		vol.setHeureDepart(heureDepart);
		vol.setHeureArrivee(heureArrivee);	
		return vol;
	}

	public static void setValue(JComboBox cb,Object v ){
        ComboBoxModel model = cb.getModel();
        int size = model.getSize();
        for(int i=0;i<size;i++) {
            Object element = model.getElementAt(i);
            if(element.equals(v)){
            	cb.setSelectedIndex(i);
            	break;
            }
        }
	}
	
	@Override
	public void displayModel(Model model) {
		Vol vol = (Vol)model;
		this.model = model;
		txtNomVol.setText(vol.getNomVol());

		setValue(cbDepart, vol.getDepart());
		setValue(cbArrivee,vol.getDestination());
		LocalDateTime ldt = convertirEnLocalDateTime(vol.getHeureDepart());
		dtDepart.setDateTimeStrict(ldt);
		
		ldt = convertirEnLocalDateTime(vol.getHeureArrivee());
		dtArrivee.setDateTimeStrict(ldt);
		
		cbPilote.setSelectedItem(vol.getPilote());
		cbAvion.setSelectedItem(vol.getAvion());
	}

	public void setTexte(String string) {
		lblTitre.setText(string);
	}

	public boolean isAjout() {
		return isAjout;
	}

	public void setAjout(boolean isAjout) {
		this.isAjout = isAjout;
		if(isAjout) {
			btnEnregistrer.setText("Enregistrer");
		}
		else {
			btnEnregistrer.setText("Modifier");
		}
	}
}

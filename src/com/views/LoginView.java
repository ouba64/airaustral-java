package com.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.controllers.AdministrateurController;
import com.models.Administrateur;
import com.models.Model;
import com.models.User;

public class LoginView extends PanelView {

	JButton btnConnexion;

	JTextField txtLogin;
	JPasswordField txtMdp;
	JLabel lblMessage;
	static String TEXTE_ERREUR = "Les informations entrées sont incorrectes";

	public LoginView(AdministrateurController controleur) {
		super(controleur);

		setLayout(null);
		setBounds(100, 100, 723, 520);
		setBackground(new Color(255, 255, 255));
		// setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblIdentifiant = new JLabel("");
		lblIdentifiant.setBounds(187, 209, 37, 28);
		lblIdentifiant.setIcon(new ImageIcon(LoginView.class.getResource("/image/user.png")));
		lblIdentifiant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblIdentifiant);

		JLabel lblMotDePasse = new JLabel("");
		lblMotDePasse.setBounds(187, 249, 37, 39);
		lblMotDePasse.setIcon(new ImageIcon(LoginView.class.getResource("/image/mdp.png")));
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblMotDePasse);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 180, 180);
		lblLogo.setIcon(new ImageIcon(LoginView.class.getResource("/image/logo.png")));
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblLogo);

		btnConnexion = new JButton("connexion");
		btnConnexion.setBounds(529, 309, 105, 34);
		btnConnexion.setBackground(new Color(230, 230, 250));
		btnConnexion.setForeground(new Color(0, 0, 0));
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(btnConnexion);
		btnConnexion.setActionCommand("Login");

		txtLogin = new JTextField();
		txtLogin.setBounds(242, 209, 232, 28);
		add(txtLogin);
		txtLogin.setColumns(10);

		txtMdp = new JPasswordField();
		txtMdp.setBounds(244, 260, 230, 28);
		add(txtMdp);

		JLabel id = new JLabel("Identifiez-vous");
		id.setBounds(268, 11, 139, 28);
		id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(id);

		lblMessage = new JLabel();
		lblMessage.setBounds(240, 350, 250, 28);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessage.setForeground(Color.RED);
		add(lblMessage);

		btnConnexion.addActionListener(controleur);

		// cr��r le mod�le associ�
		model = new Administrateur();
	}

	public static void main(String[] args) throws Exception {

	}

	@Override
	public com.models.Model fillAndGetModel() {
		String login = txtLogin.getText();
		String mdp = txtMdp.getText();
		Administrateur user = (Administrateur) model;
		user.setEmail(login);
		user.setMdp(mdp);
		return user;
	}

	@Override
	public void displayModel(Model model) {

	}

	public void afficherMessageErreur(boolean afficher) {
		String texte;
	
		if(afficher) {
			texte = TEXTE_ERREUR;
		}
		else {
			texte = "";
		}
		lblMessage.setText(texte);
	}

}
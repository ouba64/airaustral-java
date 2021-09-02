package com.views;

import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

import com.controllers.GeneralController;
import com.controllers.ListeReservationsController;
import com.controllers.ListeVolsController;
import com.controllers.RechercheReservationControlleur;
import com.controllers.RechercheVolControlleur;
import com.controllers.ReservationController;
import com.controllers.AdministrateurController;
import com.controllers.VolController;
import com.models.Aeroport;
import com.models.Avion;
import com.models.Pilote;
import com.models.Reservation;
import com.models.User;
import com.models.Vol;
import com.models.dao.AeroportDao;
import com.models.dao.AvionDao;
import com.models.dao.UserDao;

public class View {
	JFrame frame;
	GestionView gestionView;
	GestionVolView gestionVolView;
	RepresentationVolView representationVolView;
	LoginView loginView;
	RechercheVolView rechercheVolView;
	RechercheReservationView rechercheReservationView;
	ListeVolsView listeVolsView;
	SuppressionVolView suppressionVolView;
	ListeReservationsView listeReservationsView;
	SuppressionReservationView suppressionReservationView;

	ReservationController reservationController;
	AdministrateurController administrateurController;
	VolController volController;
	GeneralController generalController;

	/**
	 * L'utilisateur qui est connecté
	 */
	User user;

	public View() {

		ReservationController reservationController = new ReservationController();
		AdministrateurController administrateurController = new AdministrateurController();
		VolController volController = new VolController();
		GeneralController generalController = new GeneralController();
		RechercheVolControlleur rechercheVolController = new RechercheVolControlleur();
		ListeVolsController listeVolsController = new ListeVolsController();
		RechercheReservationControlleur rechercheReservationController = new RechercheReservationControlleur();
		ListeReservationsController listeReservationsController = new ListeReservationsController();

		this.reservationController = reservationController;
		this.administrateurController = administrateurController;
		this.volController = volController;
		this.generalController = generalController;
		generalController.setView(this);
		listeVolsController.setView(this);

		// Create and set up the window.
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cr�er tous les �lements de la Vue
		loginView = new LoginView(administrateurController);
		administrateurController.setPanelView(loginView);
		loginView.setView(this);

		gestionView = new GestionView(generalController);
		gestionView.setView(this);

		gestionVolView = new GestionVolView(generalController);
		gestionVolView.setView(this);

		UserDao userDao = new UserDao();
		List<Pilote> pilots = userDao.getTousLesPilotes();
		Vector<Pilote> pilotes = new Vector<Pilote>(pilots);

		AeroportDao dao = new AeroportDao();
		List<Aeroport> aeropors = dao.getTousLesAeroports();
		Vector<Aeroport> aeroports = new Vector<Aeroport>(aeropors);

		AvionDao avionDao = new AvionDao();
		List<Avion> avionsl = avionDao.getTousLesAvions();
		Vector<Avion> avions = new Vector<Avion>(avionsl);

		representationVolView = new RepresentationVolView(volController,
				pilotes, aeroports, avions);
		volController.setPanelView(representationVolView);
		representationVolView.setView(this);

		rechercheVolView = new RechercheVolView(rechercheVolController, pilotes,
				aeroports);
		rechercheVolController.setPanelView(rechercheVolView);
		rechercheVolView.setView(this);

		// panneau qui affiche la liste des reservations retrouv� apr�s la
		// recherche
		listeVolsView = new ListeVolsView(listeVolsController);
		listeVolsController.setPanelView(listeVolsView);
		listeVolsView.setView(this);

		suppressionVolView = new SuppressionVolView(generalController);

		rechercheReservationView = new RechercheReservationView(
				rechercheReservationController, aeroports);
		rechercheReservationController.setPanelView(rechercheReservationView);
		rechercheReservationView.setView(this);

		listeReservationsView = new ListeReservationsView(
				listeReservationsController);
		listeReservationsController.setPanelView(listeReservationsView);
		listeReservationsView.setView(this);

		suppressionReservationView = new SuppressionReservationView(
				generalController);
		suppressionReservationView.setView(this);

		// frame.setBounds(100, 100, 723, 520);
		// frame.setBackground(new Color(255, 255, 255));

		frame.setPreferredSize(new Dimension(900, 600));

		loginView.setOpaque(true); // content panes must be opaque

		frame.setContentPane(loginView);

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public GestionView getGestionView() {
		return gestionView;
	}

	public void setGestionView(GestionView gestion) {
		this.gestionView = gestion;
	}

	public GestionVolView getGestionVol() {
		return gestionVolView;
	}

	public void setGestionVol(GestionVolView gestionVol) {
		this.gestionVolView = gestionVol;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView login) {
		this.loginView = login;
	}

	public GestionVolView getGestionVolView() {
		return gestionVolView;
	}

	public void setGestionVolView(GestionVolView gestionVolView) {
		this.gestionVolView = gestionVolView;
	}

	public RepresentationVolView getAjoutVolView() {
		return representationVolView;
	}

	public void setAjoutVolView(RepresentationVolView representationVolView) {
		this.representationVolView = representationVolView;
	}

	private void stockerViewCourante(PanelView panelViewSuiv,
			boolean isStocker) {
		if (isStocker) {
			if (frame.getContentPane() instanceof PanelView) {
				PanelView panelViewPrec = (PanelView) frame.getContentPane();
				panelViewSuiv.setPanelViewPrec(panelViewPrec);
			}
		}
	}

	public void afficherPrecedent() {
		if (frame.getContentPane() instanceof PanelView) {
			PanelView panelView = (PanelView) frame.getContentPane();
			frame.setContentPane(panelView.getPanelViewPrec());
			frame.pack();
		}
	}

	public void afficherGestion() {
		stockerViewCourante(gestionView, true);
		frame.setContentPane(gestionView);
		frame.pack();
	}

	public void afficherGestionVol(boolean isStocker) {
		stockerViewCourante(gestionVolView, isStocker);
		frame.setContentPane(gestionVolView);
		frame.pack();
	}

	public void afficherRepresentationVol(Vol vol, boolean isAjout) {
		stockerViewCourante(representationVolView, true);
		representationVolView.setAjout(isAjout);
		representationVolView.displayModel(vol);
		representationVolView.setTexte("Ajouter un nouveau vol");
		frame.setContentPane(representationVolView);
		frame.pack();
	}

	public void afficherSuppressionVolView(Vol vol) {
		stockerViewCourante(suppressionVolView, true);
		suppressionVolView.afficherMessage(vol);
		frame.setContentPane(suppressionVolView);
		frame.pack();
	}

	public void afficherRechercheReservation() {
		stockerViewCourante(rechercheReservationView, true);
		frame.setContentPane(rechercheReservationView);
		frame.pack();
	}

	public void afficherRechercheVols() {
		stockerViewCourante(rechercheVolView, true);
		frame.setContentPane(rechercheVolView);
		frame.pack();
	}

	public void afficherLogin() {
		stockerViewCourante(loginView, true);
		frame.setContentPane(loginView);
		frame.pack();
	}

	public void afficherListeVols(List<Vol> vols) {
		stockerViewCourante(listeVolsView, true);
		if (vols != null) {
			listeVolsView.afficherListeVols(vols);
		}
		frame.setContentPane(listeVolsView);
		frame.pack();
	}

	public void afficherListeReservations(List<Reservation> reservations) {
		stockerViewCourante(listeReservationsView, true);
		if (reservations != null) {
			listeReservationsView.afficherListeReservations(reservations);
		}
		frame.setContentPane(listeReservationsView);
		frame.pack();
	}

	public void afficherSuppressionReservation(Reservation reservation) {
		stockerViewCourante(suppressionReservationView, true);
		suppressionReservationView.afficherMessage(reservation);
		frame.setContentPane(suppressionReservationView);
		frame.pack();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

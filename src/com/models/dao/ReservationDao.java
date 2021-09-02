package com.models.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.models.Aeroport;
import com.models.Avion;
import com.models.Pilote;
import com.models.CriteresVol;
import com.models.Reservation;
import com.models.CriteresReservation;
import com.models.User;
import com.models.Vol;
import com.mysql.fabric.xmlrpc.Client;
import com.utility.DBConnection;

public class ReservationDao {
	UserDao userDao;
	VolDao volDao;
	public ReservationDao() {
		userDao = new UserDao();
		volDao=new VolDao();
	}
	
	public List<Reservation> chercher(CriteresReservation criteresReservation){
		List<Reservation> reservations = null;
		try {
			reservations = findByVol(criteresReservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
	}
	
	public void supprimer(Reservation reservation) throws Exception {
		Long idVol =reservation.getVol().getId();
		Long idClient=reservation.getClient().getId();
        final String query = "DELETE FROM `reservation`"
        		+ "WHERE idVol = ? "
        		+ "AND idClient = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), query, idVol, idClient);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new Exception("Erreurs lors de la modification d'un vol");
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            throw new Exception("Erreurs lors de la modification d'un vol", e.getCause());
        } finally {
            DBConnection.closeStatement(preparedStatement);
        }		
	}
	
	
	public  List<Reservation> findByVol(CriteresReservation regionVol) throws Exception {
		
		String SQL = "SELECT DISTINCT `reservation`.`idClient` , `reservation`.`idVol` "
					+ "FROM `reservation` "
					+"INNER JOIN `personne` ON `personne`.`id` = `reservation`.`idClient` "
					+"INNER JOIN `vol` ON `reservation`.`idVol` = `vol`.`id` "
					+"WHERE ";

		ArrayList<String> whereClause = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object> ();
		
		if(regionVol.getClient()!=null){
			String nom = regionVol.getClient().getNom();
			if(nom!=null){
				whereClause.add("`personne`.`nom` LIKE ?");
				values.add("%" + nom +"%");
			}
		}
		if(regionVol.getClient().getPrenom()!=null){
			if(regionVol.getClient()!=null){
				String prenom = regionVol.getClient().getPrenom();
				if(prenom!=null){
					whereClause.add("`personne`.`prenom` LIKE ?");
					values.add("%" + prenom +"%");	
				}
			}
		}
		Aeroport ae;
		// on prend en compte le poit de d�part
		if(regionVol.getVol()!=null) {
			ae = regionVol.getVol().getDepart();
			if(ae!=null){
				whereClause.add("`vol`.`ae_depart` = ?");
				values.add(ae.getId());
			}
		}
		if(regionVol.getVol()!=null) {
			ae = regionVol.getVol().getDestination();
			if(ae!=null){
				whereClause.add("`vol`.`ae_arrivee` = ?");
				values.add(ae.getId());
			}
		}
		if(regionVol.getVol()!=null) {
			String nomVol = regionVol.getVol().getNomVol();
			if(nomVol!=null){
				whereClause.add("`vol`.`nom` LIKE ?");
				values.add("%" + nomVol +"%");
			}
		}

		
		if(values.size()>0){
			String part = String.join(" AND ", whereClause);
			SQL+=part;
		}
		List<Reservation> vols = find(SQL,  values);
		return vols;
	}
	
	private  List<Reservation> find(String sql, List<Object> objects) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Reservation> listVols = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objects);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listVols.add(mappingReservation(resultSet));
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listVols;
	}
	
	
	
	public Reservation mappingReservation(ResultSet resultSet) throws SQLException {

		Reservation reservation = new Reservation();
		try {
			Long idDepart = resultSet.getLong("idClient");
			User ae = userDao.getUserById(idDepart);
			reservation.setClient(ae);
			
			int idVol = resultSet.getInt("idVol");
			Vol vol = volDao.findById(idVol);
			reservation.setVol(vol);
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reservation;
	}
	
	
	public static void main(String[] args) {
		ReservationDao volDao = new ReservationDao();
		
		User user = new User();
		user.setNom("tim");
		int test = 2;
		
		
		
		Aeroport aed = new Aeroport();
		aed.setId(1L);
		
		Aeroport aea = new Aeroport();
		aea.setId(2L);

		Vol vol = new Vol();
		vol.setDepart(aed);
		
		vol.setDestination(aea);
		vol.setNomVol("VOL");

		CriteresReservation rr  =new CriteresReservation();
		rr.setVol(vol);
		rr.setClient(user);
		List<Reservation> reservations;
		try {
			reservations = volDao.findByVol(rr);
			System.out.println(reservations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

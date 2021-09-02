package com.models.dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.Main;
import com.models.Aeroport;
import com.models.Avion;
import com.models.Pilote;
import com.models.CriteresVol;
import com.models.User;
import com.models.Vol;
import com.utility.DBConnection;
import com.views.PanelView;

public class VolDao {
	AeroportDao aeroportDao ;
	UserDao userDao;
	AvionDao avionDao;
	public VolDao() {
		// TODO Auto-generated constructor stub
		aeroportDao = new AeroportDao();
		userDao = new UserDao();
		avionDao = new AvionDao();
	}
	public void enregistrer(Vol vol) throws Exception {
        final String SQL_INSERT = "INSERT INTO vol "
                + "(nom, idAvion, heure_depart, duree, ae_depart, ae_arrivee, idPilote) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
        	long duree = PanelView.obtenirDifferenceEnMinutes(vol.getHeureDepart(), vol.getHeureArrivee());
        	Long idAvion = vol.getAvion().getId();
            preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), SQL_INSERT,
            		vol.getNomVol(), idAvion, vol.getHeureDepart(), duree,
					vol.getDepart().getId(), vol.getDestination().getId(), vol.getPilote().getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new Exception("Erreurs lors de l'ajout d'un vol");
            }

        } catch (SQLException e) {
        	e.printStackTrace();
            throw new Exception("Erreurs lors de l'ajout d'un vol", e.getCause());
        } finally {
            DBConnection.closeStatement(preparedStatement);
        }
	}

	public List<Vol> chercher(CriteresVol criteresVol) {
		ArrayList<Vol> vols = null;
		try {
			vols = findByVol(criteresVol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vols;
	}
	
	public void supprimer(Vol vol) throws Exception {
        final String query = "DELETE FROM `vol` WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), query, vol.getId());
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

	public void modifier(Vol vol) throws Exception {
        final String query = "UPDATE `vol` SET `idAvion`=?,`heure_depart`=?,`duree`=?,`nom`=?,`ae_depart`=?,`ae_arrivee`=?,`idPilote`=? WHERE `id`=?";
        PreparedStatement preparedStatement = null;
        try {
        	// TODO
        	int duree = 0;

            preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), query,
            		vol.getAvion().getId(), vol.getHeureDepart(), duree,
					vol.getNomVol(), vol.getDepart().getId(), vol.getDestination().getId(), vol.getPilote().getId(), vol.getId());
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
	

	
	
	public void update(Vol vol) throws Exception {
		final String SQL_UPDATE = "UPDATE vol SET nomvol = ?, "
				+ "destination = ?, heureDepart = ?, heureArrivee = ?, "
				+ "nomPilot = ?, dateVol = ? WHERE idvol = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), SQL_UPDATE,
					vol.getNomVol(), vol.getDestination(), vol.getHeureDepart(),
					vol.getHeureArrivee(), null, vol.getId());
			int statut = preparedStatement.executeUpdate();
			if (statut == 0) {
				throw new Exception("Echec de la mise � jour du vol");
			}
		} catch (SQLException e) {
			throw new Exception("Erreurs lors de la mise � jour du vol ", e.getCause());
		} finally {
			DBConnection.closeStatement(preparedStatement);
		}
	}
	
	public void delete(Vol vol) throws Exception {
        final String SQL_DELETE_BY_ID = "DELETE FROM vol WHERE idvol = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), SQL_DELETE_BY_ID,
                    vol.getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new Exception("Echec de la suppression de l'usager");
            }
        } catch (SQLException e) {
            throw new Exception("Erreurs lors de la suppression de l'usager ", e.getCause());
        } finally {
            DBConnection.closeStatement(preparedStatement);
        }
    }
	
	private  ArrayList<Vol> find(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Vol> listVols = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listVols.add(mappingVol(resultSet));
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listVols;
	}
	
	
	
	private  ArrayList<Vol> find(String sql, List<Object> objects) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Vol> listVols = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objects);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listVols.add(mappingVol(resultSet));
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listVols;
	}
	

	public  Vol findById(int id) throws Exception {
		final String SQL = "SELECT * FROM vol WHERE id = ?";
		ArrayList<Vol> vols = find(SQL, id);
		return vols.size() == 0 ? null : vols.get(0);
	}
	
	public  ArrayList<Vol> findByDestination(String destination) throws Exception {
		final String SQL = "SELECT * FROM vol WHERE destination like ?";
		ArrayList<Vol> vols = find(SQL,  "%" + destination + "%");
		return vols;
	}
	
	public  ArrayList<Vol> findByDateVol(LocalDate date) throws Exception {
		final String SQL = "SELECT * FROM vol WHERE datevol = ?";
		ArrayList<Vol> vols = find(SQL,  date);
		return vols;
	}
	
	public  ArrayList<Vol> findByVol(CriteresVol criteresVol) throws Exception {
		
		String SQL = "SELECT * FROM vol WHERE ";
		ArrayList<String> whereClause = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object> ();
		if(criteresVol.getNomVol()!=null){
			whereClause.add("nom LIKE ?");
			values.add("%" + criteresVol.getNomVol()+"%");
		}
		// on prend en compte le poit de d�part
		if(criteresVol.getDepart()!=null) {
			whereClause.add("ae_depart = ?");
			values.add(criteresVol.getDepart().getId());
		}
		if(criteresVol.getDestination()!=null ) {
			whereClause.add("ae_arrivee = ?");
			values.add(criteresVol.getDestination().getId());
		}
		if(criteresVol.getDate()!=null) {
			whereClause.add("DATE(heureDepart)");
			values.add(criteresVol.getDate());
		}
		if(criteresVol.getPilote()!=null) {
			whereClause.add("idPilote = ?");
			values.add(criteresVol.getPilote().getId());
		}
		
		if(values.size()>0){
			String part = String.join(" AND ", whereClause);
			SQL+=part;
		}
		ArrayList<Vol> vols = find(SQL,  values);
		return vols;
	}

	public  Vol mappingVol(ResultSet resultSet) throws SQLException {

		Vol vol = new Vol();
		try {
			java.util.Date heureDepart = null;
			
			java.util.Date date;
			Timestamp timestamp = resultSet.getTimestamp("heure_depart");

			if (timestamp != null)
				heureDepart = new java.util.Date(timestamp.getTime());
			//Date d =
			vol.setHeureDepart(heureDepart);
			
			
			int dureemn = resultSet.getInt("duree");
			long dureems = dureemn * 60 * 1000;
			long ta = heureDepart.getTime() + dureems;
			Date heureArrivee = new Date(ta);
			vol.setHeureArrivee(heureArrivee);
			
//			System.out.println(heureDepart + " " + heureArrivee + " " + dateVol);
//			System.out.println(heureDepart.toLocalTime());
//			vol.setHeureDepart(heureDepart.toLocalTime());
			
			Long idDepart = resultSet.getLong("ae_depart");
			Aeroport ae = aeroportDao.getAeroportById(idDepart);
			vol.setDepart(ae);
			
			idDepart = resultSet.getLong("ae_arrivee");
			ae = aeroportDao.getAeroportById(idDepart);
			vol.setDestination(ae);
			
			vol.setId(resultSet.getLong("id"));
			vol.setNomVol(resultSet.getString("nom"));
			

			Long idPilote = resultSet.getLong("idPilote");
			Pilote pilote = userDao.getPiloteById(idPilote);
			vol.setPilote(pilote);
			
			Long idAvion = resultSet.getLong("idAvion");
			Avion avion = avionDao.getAvionById(idAvion);
			vol.setAvion(avion);
			
			
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vol;
	}

	public static void main(String[] args) {
		VolDao volDao = new VolDao();
		
		Aeroport ae = new Aeroport();
		ae.setId(1L);
		int test = 2;
		
		Avion avion = new Avion();
		avion.setId(1L);

		
		Pilote pilote = new Pilote();
		pilote.setId(7L);
		if(test == 1){

			CriteresVol criteresVol =new CriteresVol();
	
			
			criteresVol.setNomVol("VOL");
			//regionVol.setDepart(ae);
			//regionVol.setDestination(ae);
			criteresVol.setPilote(pilote);
			List<Vol> vols = volDao.chercher(criteresVol);
			System.out.println(vols);
		}
		else{
			Vol vol = new Vol();

			vol.setAvion(avion);
			vol.setDepart(ae);
			vol.setDestination(ae);
			vol.setPilote(pilote);
			Date heureArrivee;
			//vol.setHeureArrivee(heureArrivee);
			try {
				volDao.modifier(vol);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}

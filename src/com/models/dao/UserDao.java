package com.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Administrateur;
import com.models.Aeroport;
import com.models.Pilote;
import com.models.User;
import com.utility.DBConnection;

public class UserDao extends Dao {
	
	/**
	 * Create the panel.
	 */
	public UserDao() {

	}
	
	public Administrateur find(Administrateur user) {
		String email = user.getEmail();
		String mdp = user.getMdp();

		Administrateur userTrouve = null;
		ArrayList<Administrateur> administrateurs;
		if(email!=null && mdp!=null) {
			String sql = 
					"SELECT * FROM `personne` WHERE " + 
					"`type`= 3 " + 
					"AND email = ? "  + 
					"AND mdp = ? " ;
			try {
				List<Administrateur> users = findAdministrateurs(sql, user.getEmail(),  user.getMdp() );
					
				if(users!=null && users.size()>0) {
					userTrouve = users.get(0);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userTrouve;
	}
	
	public Pilote getPiloteById(Long idDepart) {
		String sql = 
				"SELECT * FROM `personne` where type=2 and id= ?";
		List<Pilote> aeroports;
		Pilote ae = null;
		try {
			aeroports = findPilotes(sql, idDepart);
			if(aeroports.size()>0){
				ae = aeroports.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ae;
	}
	
	
	public User getUserById(Long idDepart) {
		String sql = 
				"SELECT * FROM `personne` where id= ?";
		List<User> aeroports;
		User ae = null;
		try {
			aeroports = findUsers(sql, idDepart);
			if(aeroports.size()>0){
				ae = aeroports.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ae;
	}
	
	public List<Pilote> getTousLesPilotes(){
		String sql = 
				"SELECT * FROM `personne` WHERE " + 
				"`type`= ? ";
		List<Pilote> pilotes = null;
		try {
			pilotes = findPilotes(sql, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pilotes;
	}
	
	
	private static List<User> findUsers(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> listUsers = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listUsers.add(mappingUser(resultSet));
				
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listUsers;
	}
	
	
	private static List<Administrateur> findAdministrateurs(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Administrateur> listUsers = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listUsers.add(mappingAdministrateur(resultSet));
				
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listUsers;
	}
	
	private static List<Pilote> findPilotes(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Pilote> listUsers = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listUsers.add(mappingPilote(resultSet));
				
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listUsers;
	}
	

	public static void update(User user) throws Exception {
		final String SQL_UPDATE = "UPDATE user SET mdp = ? WHERE iduser = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), SQL_UPDATE,
					user.getMdp(), user.getId());
			int statut = preparedStatement.executeUpdate();
			if (statut == 0) {
				throw new Exception("Echec de la mise � jour de l'utilisateur");
			}
		} catch (SQLException e) {
			throw new Exception("Erreurs lors de la mise � jour de l'utilisateur ", e.getCause());
		} finally {
			DBConnection.closeStatement(preparedStatement);
		}
	}

	/**
	 * Chercher un user par id
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static User findById(int id) throws Exception {
		final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE iduser = ?";
		//List<User> users = find(SQL_SELECT_BY_ID, id);
		//return users.size() == 0 ? null : users.get(0);
		return null;
	}

	public static User mappingUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		try {
			user.setId(resultSet.getLong("id"));
			user.setNom(resultSet.getString("nom"));
			user.setPrenom(resultSet.getString("prenom"));
			user.setEmail(resultSet.getString("email"));
			user.setMdp(resultSet.getString("mdp"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public static Administrateur mappingAdministrateur(ResultSet resultSet) throws SQLException {
		Administrateur user = new Administrateur();
		try {
			user.setId(resultSet.getLong("id"));
			user.setNom(resultSet.getString("nom"));
			user.setPrenom(resultSet.getString("prenom"));
			user.setEmail(resultSet.getString("email"));
			user.setMdp(resultSet.getString("mdp"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public static Pilote mappingPilote(ResultSet resultSet) throws SQLException {
		Pilote user = new Pilote();
		try {
			user.setId(resultSet.getLong("id"));
			user.setNom(resultSet.getString("nom"));
			user.setPrenom(resultSet.getString("prenom"));
			user.setEmail(resultSet.getString("email"));
			user.setMdp(resultSet.getString("mdp"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	

	
	
	public static void main(String[] args) {
		Administrateur user = new Administrateur();
		user.setEmail("a");
		user.setMdp("a");
		UserDao userDao = new UserDao();
		user = userDao.find(user);
		
		List<Pilote> pilotes = userDao.getTousLesPilotes();
		System.out.println(pilotes);
	}
}

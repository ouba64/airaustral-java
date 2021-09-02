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

public class AeroportDao {

	public List<Aeroport> getTousLesAeroports(){
		String sql = 
				"SELECT * FROM `aeroport`";
		List<Aeroport> pilotes = null;
		try {
			pilotes = findAeroports(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pilotes;
	}
	
	public Aeroport getAeroportById(Long idDepart) {
		String sql = 
				"SELECT * FROM `aeroport` where id=?";
		List<Aeroport> aeroports;
		Aeroport ae = null;
		try {
			aeroports = findAeroports(sql, idDepart);
			if(aeroports.size()>0){
				ae = aeroports.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ae;
	}
	
	private static List<Aeroport> findAeroports(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Aeroport> listUsers = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listUsers.add(mappingAeroport(resultSet));
				
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listUsers;
	}
	
	
	public static Aeroport mappingAeroport(ResultSet resultSet) throws SQLException {
		Aeroport user = new Aeroport();
		try {
			user.setId(resultSet.getLong("id"));
			user.setNom(resultSet.getString("nom"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public static void main(String[] args) {
		AeroportDao dao =new AeroportDao();
		List<Aeroport> aes = dao.getTousLesAeroports();
		System.out.println(aes);
	}



}

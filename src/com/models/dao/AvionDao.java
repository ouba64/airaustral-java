package com.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Avion;
import com.utility.DBConnection;

public class AvionDao extends Dao {
	public List<Avion> getTousLesAvions(){
		String sql = 
				"SELECT * FROM `avion`";
		List<Avion> pilotes = null;
		try {
			pilotes = findAvions(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pilotes;
	}
	
	public Avion getAvionById(Long idDepart) {
		String sql = 
				"SELECT * FROM `avion` where id=?";
		List<Avion> avions;
		Avion ae = null;
		try {
			avions = findAvions(sql, idDepart);
			if(avions.size()>0){
				ae = avions.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ae;
	}
	
	private static List<Avion> findAvions(String sql, Object... objets) throws Exception {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Avion> listUsers = new ArrayList<>();

		try {
			preparedStatement = DBConnection.initialiseRequetePreparee(DBConnection.getConnection(), sql, objets);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listUsers.add(mappingAvion(resultSet));
				
			}
		} catch (SQLException e) {
			throw new Exception("Aucun enregistrement trouv� " + e.getMessage());
		} finally {
			DBConnection.closeStatementResultSet(preparedStatement, resultSet);
		}

		return listUsers;
	}
	
	
	public static Avion mappingAvion(ResultSet resultSet) throws SQLException {
		Avion user = new Avion();
		try {
			user.setId(resultSet.getLong("id"));
			user.setNom(resultSet.getString("nom"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public static void main(String[] args) {
		AvionDao dao =new AvionDao();
		List<Avion> aes = dao.getTousLesAvions();
		System.out.println(aes);
	}
}

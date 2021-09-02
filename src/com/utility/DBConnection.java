package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DBConnection {
	
	private static final String FICHIER_PROPERTIES = "com/utility/config.properties";
    private static final String PROPERTY_URL = "SGBD.URL";
    private static final String PROPERTY_DRIVER = "SGBD.DRIVER";
    private static final String PROPERTY_NOM_USER = "SGBD.USER";
    private static final String PROPERTY_PASSWORD = "SGBD.PASSWORD";
    
    
    /**
     * M�thode charg�e de r�cup�rer les informations de connexion � la base de
     * donn�es, charger le driver JDBC et retourner une instance connexion � la
     * base de donn�es
     *
     * @return
     * @throws SQLException
     * @throws BibalExceptions
     */
    public static Connection getConnection() throws SQLException, Exception {

        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

        if (null == fichierProperties) {
            throw new Exception("Le fichier properties '"
                    + FICHIER_PROPERTIES.toUpperCase() + "' est introuvable\n");
        }
        /**
         * Chargement du fichier de configuration de la BD
         */
        try {
            properties.load(fichierProperties);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            nomUtilisateur = properties.getProperty(PROPERTY_NOM_USER);
            motDePasse = properties.getProperty(PROPERTY_PASSWORD);
        } catch (IOException ex) {
            throw new Exception("Impossible de charger le fichier properties '"
                    + FICHIER_PROPERTIES.toUpperCase() + "'\n", ex.getCause());
        }
        /**
         * Chargement du Driver
         */
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new Exception("Le driver " + PROPERTY_DRIVER.toUpperCase()
                    + " est introuvable\n", e.getCause());
        }
        
        return DriverManager.getConnection(url, nomUtilisateur, motDePasse);
    }


	/**
     * Fermeture du ResultSet
     *
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Echec de la fermeture du ResultSet : " + e.getMessage());
            }
        }
    }

    /**
     * Fermeture du statement
     *
     * @param statement
     */
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Echec de la fermeture du Statement : " + e.getMessage());
            }
        }
    }

    /**
     * Fermeture de la connexion
     *
     * @param connexion
     */
    public static void closeConnection(Connection connexion) {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                System.out.println("Echec de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }

    /**
     *
     * @param statement
     * @param resultSet
     */
    public static void closeStatementResultSet(Statement statement, ResultSet resultSet) {
        closeStatement(statement);
        closeResultSet(resultSet);
    }
    
    public static void closeConnectionStatementResultSet(Connection connexion, Statement statement, ResultSet resultSet) {
        closeConnection(connexion);
        closeStatement(statement);
        closeResultSet(resultSet);
    }
    
    /**
     * Initialisation des requ�tes pr�par�es des objets
     *
     * @param connexion
     * @param sql
     * @param objets
     * @return
     * @throws SQLException
     */
    public static PreparedStatement initialiseRequetePreparee(Connection connexion, String sql, Object... objets) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        for (int i = 0; i < objets.length; i++) {
            preparedStatement.setObject(i + 1, objets[i]);
        }
        return preparedStatement;
    }
    
    public static PreparedStatement initialiseRequetePreparee(Connection connexion, String sql, List<Object> objets) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        for (int i = 0; i < objets.size(); i++) {
            preparedStatement.setObject(i + 1, objets.get(i));
        }
        return preparedStatement;
    }
}

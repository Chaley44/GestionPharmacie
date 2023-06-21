package gestionPharmacie.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreerConnexion {

	private Connection con;

	public CreerConnexion() {
		
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_pharmacie",
					"root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	public Connection getCon() {
		return con;
	}
}

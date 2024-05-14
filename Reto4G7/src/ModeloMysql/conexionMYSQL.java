package ModeloMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionMYSQL {

	public static Connection metodoConexion() throws SQLException {
/*
		String usuario = "mañana";
		String contraseña = "elorrieta";
		String host = "localhost:33060";

		return DriverManager.getConnection("jdbc:mysql://" + host + "/grupo7_reto4", usuario, contraseña);
*/
		
		  String SERVIDOR_DB = "jdbc:mysql://domainreto4.duckdns.org:3306/"; 		  
		  String NOMBRE_DB = "grupo7_reto4"; 
		  String USUARIO = "mikel"; 
		  String CONTRASEÑA ="123";
		 
		 return DriverManager.getConnection(SERVIDOR_DB+NOMBRE_DB,USUARIO,CONTRASEÑA);
		 
	}

	
}

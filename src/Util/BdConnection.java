package Util;


import java.sql.*;
 
public class BdConnection {
	// Definir la ruta de la base de datos
	private String dbUrl = "jdbc:mysql://localhost:3306/bd_biblioteca";
	 // Definir el nombre de usuario de la base de datos
	private String dbUser = "root";
	 // Definir la contraseña de la base de datos
	private String dbPassword = "misiontic2021";
	 // Definir controlador de carga
	private String jdbcName = "com.mysql.jdbc.Driver";
 
	 // Conéctate a la base de datos
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(jdbcName);
			System.out.println("Cargó el controlador");
		} catch (Exception e) {
			 System.out.println ("¡Error al cargar el controlador!");
		}
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("Conectado!!");
		} catch (SQLException ex) {
			 System.out.println ("¡Error al conectarse a la base de datos!");
		}
		return conn;
	}
 
	 // prueba
	/*
	public static void main(String[] args) {
		// System.out.println(new DBHelper().getConn());
		 System.out.println ("¡Conectado exitosamente a la base de datos!");
	}
	*/
 
}
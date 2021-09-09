package access;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.BdConnection;
import model.Libros;

public class LibrosDAO {
	public static BdConnection conexion = new BdConnection();
	public static Connection bd = conexion.getConn();
	
	public static ArrayList<Libros> consultaLibros(){
		
		ArrayList<Libros> libros = new ArrayList<Libros>();
		String query = "select * from tb_inventario";
	    try (Statement stmt = bd.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	    	int idLibro = rs.getInt("id");
	        String nombreLibro = rs.getString("nombreLibro");
	        String descripcion = rs.getString("descripcion");
	        boolean prestado = rs.getBoolean("prestado");
	        
	        libros.add(new Libros(idLibro, nombreLibro, descripcion, prestado));
	      }
	    } catch (SQLException e) {
	    	System.out.println("Error al consultar :(");
	    	//JDBCTutorialUtilities.printSQLException(e);
	    }
	    return libros;
	}
	
	public static void agregarLibro(String nombreLibro, String descripcion, Boolean prestado) {
		
	    try {
	    	String query = "insert into tb_inventario(nombreLibro,descripcion,prestado)"+" values(?,?,?)";
	    	PreparedStatement preparedStmt = bd.prepareStatement(query);
	        preparedStmt.setString (1, nombreLibro);
	        preparedStmt.setString (2, descripcion);
	        preparedStmt.setBoolean(3, prestado);
	    	preparedStmt.execute();

	    } catch (SQLException e) {
	    	System.out.println("Error al agregar dato :( :(");
	    	System.err.println(e.getMessage());
	    	//JDBCTutorialUtilities.printSQLException(e);
	    }
	}
	
	public static void modificarLibro(int id, String nombreLibro, String descripcion, Boolean prestado) {
		
	    try {
	    	String query = "update tb_inventario set nombreLibro=?,descripcion=?,prestado=? where id=?";
	    	PreparedStatement preparedStmt = bd.prepareStatement(query);
	        preparedStmt.setString (1, nombreLibro);
	        preparedStmt.setString (2, descripcion);
	        preparedStmt.setBoolean(3, prestado);
	        preparedStmt.setInt(4, id);
	    	preparedStmt.execute();

	    } catch (SQLException e) {
	    	System.out.println("Error al actualizar dato :( :(");
	    	System.err.println(e.getMessage());
	    	//JDBCTutorialUtilities.printSQLException(e);
	    }
	}
	
public static void eliminarLibro(int id) {
		
	    try {
	    	String query = "delete from tb_inventario where id=?";
	    	PreparedStatement preparedStmt = bd.prepareStatement(query);
	        preparedStmt.setInt (1, id);
	    	preparedStmt.execute();

	    } catch (SQLException e) {
	    	System.out.println("Error al actualizar dato :( :(");
	    	System.err.println(e.getMessage());
	    	//JDBCTutorialUtilities.printSQLException(e);
	    }
	}
}

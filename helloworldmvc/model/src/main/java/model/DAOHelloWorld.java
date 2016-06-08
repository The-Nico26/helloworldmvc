package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOHelloWorld {
    private static String URL = "jdbc:mysql://127.0.0.1:3388/javapetri?autoReconnect=true&useSSL=false";
    private static String LOGIN = "root";
    private static String PASSWORD = "";
    private Connection connection;
    private Statement statement;
    
    public DAOHelloWorld(){
    	this.connection = null;
    	this.statement = null;
    	System.out.println("Connection bdd : "+open());
    }

    public DAOHelloWorld getInstance(){
    	return this;
    }
    public String getQuerySelectFirstHelloWorld(){
    	return "";
    }
    protected boolean open() {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
    	    connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
    	    statement = connection.createStatement();
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	    return false;
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return true;
        }
        
    protected void close(){
		try {
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		System.out.println("Fermeture !");
    }
    
    protected ResultSet executeQuery(String query) throws SQLException{
    	return statement.executeQuery(query);
    }
    protected int executeUpdate(String query) throws SQLException{
		return statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    }
}

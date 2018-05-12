package pl.skrabcio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClass {

		public static final String DRIVER = "org.sqlite.JDBC";
		public static final String DB_URL = "jdbc:sqlite:db.db";

		protected Connection connect;
		protected Statement status;
		
		public DBClass() {
			try {
				Class.forName(DBClass.DRIVER);
			}
			catch(ClassNotFoundException e) {
				System.err.println("Brak sterownika bazy danych");
				e.printStackTrace();
			}
			
			try {
				connect = DriverManager.getConnection(DB_URL);
				status = connect.createStatement(); 
			}
			catch(SQLException e){
				System.err.println("B³¹d po³¹czenia");
				e.printStackTrace();
			}
			
			createTables();
		}
		
		public boolean createTables() {
	
			String createUsers = "CREATE TABLE IF NOT EXISTS Users (id_user INTEGER PRIMARY KEY AUTOINCREMENT, name_user VARCHAR(32), mail_user VARCHAR(50))";
			String createProducts = "CREATE TABLE IF NOT EXISTS Products (id_product INTEGER PRIMARY KEY AUTOINCREMENT, name_product VARCHAR(32))";
			String createPriviledges = "CREATE TABLE IF NOT EXISTS Priviledges (id_priviledge INTEGER PRIMARY KEY AUTOINCREMENT, name_priviledge VARCHAR(32))";
		
			try {
				status.execute(createUsers);
				status.executeQuery(createProducts);
				status.execute(createPriviledges);
			}
			catch(SQLException e) {
				System.err.println("B³¹d tworzenia tabeli");
				e.printStackTrace();
				return false;
			}
			return true;
		}
}

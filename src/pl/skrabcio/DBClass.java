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
				status.setQueryTimeout(30);
			}
			catch(SQLException e){
				System.err.println("B³¹d po³¹czenia");
				e.printStackTrace();
			}
			
			createTables();
		}
		
		public boolean createTables() {
	
			String createUsers = "CREATE TABLE IF NOT EXISTS Users (\r\n" + 
					"    id_user   INTEGER      PRIMARY KEY AUTOINCREMENT\r\n" + 
					"                           UNIQUE\r\n" + 
					"                           NOT NULL,\r\n" + 
					"    name_user VARCHAR (32) NOT NULL\r\n" + 
					"                           UNIQUE,\r\n" + 
					"    mail_user VARCHAR (50) NOT NULL,\r\n" + 
					"    isDeleted BOOLEAN      DEFAULT (0) \r\n" + 
					");";
			String createProducts = "CREATE TABLE IF NOT EXISTS Products (id_product INTEGER PRIMARY KEY AUTOINCREMENT, name_product VARCHAR(32), isDeleted BOOLEAN DEFAULT (0))";
			String createPriviledges = "CREATE TABLE IF NOT EXISTS Privileges (id_priviledge INTEGER PRIMARY KEY AUTOINCREMENT, name_priviledge VARCHAR(32), isDeleted BOOLEAN DEFAULT (0))";
		
			try {
				status.executeUpdate(createUsers);
				status.executeUpdate(createProducts);
				status.executeUpdate(createPriviledges);
			}
			catch(SQLException e) {
				System.err.println("B³¹d tworzenia tabeli");
				e.printStackTrace();
				return false;
			}
			return true;
		}
}

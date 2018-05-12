package pl.skrabcio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pl.skrabcio.UsersTable;

public class Users extends DBClass implements AppFactoryInterface {
	

	public boolean insert(String arg0, String...args) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("INSERT into Users values(NULL,?,?);");
			prepare.setString(1,arg0);
			prepare.setString(2,args[0]);
			prepare.execute();
		}
		catch(SQLException e) {
			System.err.println("B³¹d dodawania u¿ytkownika");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<UsersTable> select(){
		List<UsersTable> usersList = new LinkedList<UsersTable>();
		int id;
		String name, mail;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Users;");
			while(result.next()) {
				id = result.getInt("id_user");
				name = result.getString("name_user");
				mail = result.getString("mail_user");
				usersList.add(new UsersTable(id, name, mail));	
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return usersList;
		
	}
}

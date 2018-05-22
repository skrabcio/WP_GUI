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
			PreparedStatement prepare = connect.prepareStatement ("INSERT INTO Users values(NULL,?,?,0);");
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
		boolean isDeleted;
		String name, mail;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Users WHERE isDeleted IS NULL");
			while(result.next()) {
				id = result.getInt("id_user");
				name = result.getString("name_user");
				mail = result.getString("mail_user");
				isDeleted = result.getBoolean("isDeleted");
				usersList.add(new UsersTable(id, name, mail, isDeleted));
			}
		}
		catch(SQLException e) { 
			System.err.println("Select user b³ad");
			e.printStackTrace();
			return null;
		}
		return usersList;
		
	}

	
	public boolean delete(int id) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("UPDATE Users SET isDeleted = 1 WHERE id_user = ?");
			prepare.setInt(1,id);
			prepare.execute();
		}
		catch(SQLException e) {
			System.err.println("B³¹d usuwania u¿ytkownika");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

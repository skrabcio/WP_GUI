package pl.skrabcio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pl.skrabcio.PrivilegesTable;

public class Privileges extends DBClass implements AppFactoryInterface {
	

	public boolean insert(String arg0, String...args) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("INSERT INTO Privileges values(NULL,?,0);");
			prepare.setString(1,arg0);
			prepare.execute();
		}
		catch(SQLException e) {
			System.err.println("B³¹d dodawania u¿ytkownika");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<PrivilegesTable> select(){
		List<PrivilegesTable> privilegesList = new LinkedList<PrivilegesTable>();
		int id;
		boolean isDeleted;
		String name;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Privileges WHERE isDeleted IS NULL;");
			while(result.next()) {
				id = result.getInt("id_privilege");
				name = result.getString("name_privilege");
				isDeleted = result.getBoolean("isDeleted");
				privilegesList.add(new PrivilegesTable(id, name, isDeleted));	
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return privilegesList;
		
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("UPDATE Privileges SET isDeleted = 1 WHERE id_privilege = ?");
			prepare.setInt(1,id);
			prepare.execute();
		}
		catch(SQLException e) {
			System.err.println("B³¹d usuwania uprawnien");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

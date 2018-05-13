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
			PreparedStatement prepare = connect.prepareStatement ("INSERT into Privileges values(NULL,?);");
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
		String name;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Privileges;");
			while(result.next()) {
				id = result.getInt("id_privileges");
				name = result.getString("name_privileges");
				privilegesList.add(new PrivilegesTable(id, name));	
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return privilegesList;
		
	}
}

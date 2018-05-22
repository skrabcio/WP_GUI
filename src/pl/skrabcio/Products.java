package pl.skrabcio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pl.skrabcio.ProductsTable;

public class Products extends DBClass implements AppFactoryInterface {
	

	public boolean insert(String arg0, String...args) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("INSERT INTO Products values(NULL,?,0);");
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

	public List<ProductsTable> select(){
		List<ProductsTable> productsList = new LinkedList<ProductsTable>();
		int id;
		boolean isDeleted;
		String name;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Products WHERE isDeleted IS NULL");
			while(result.next()) {
				id = result.getInt("id_product"); 
				name = result.getString("name_product");
				isDeleted = result.getBoolean("isDeleted");
				productsList.add(new ProductsTable(id, name, isDeleted));
			}	
		}
		catch(SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return productsList;
		
	}

	public boolean delete(int id) {
		try {
			PreparedStatement prepare = connect.prepareStatement ("UPDATE Products SET isDeleted = 1 WHERE id_product = ?");
			prepare.setInt(1,id);
			prepare.execute();
		}
		catch(SQLException e) {
			System.err.println("B³¹d usuwania produktu");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

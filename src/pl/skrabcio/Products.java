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
			PreparedStatement prepare = connect.prepareStatement ("INSERT into Products values(NULL,?);");
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
		String name;
		try {
			ResultSet result = status.executeQuery("SELECT * FROM Products;");
			while(result.next()) {
				id = result.getInt("id_product");
				name = result.getString("name_product");
				productsList.add(new ProductsTable(id, name));	
			}
		}
		catch(SQLException e) { 
			e.printStackTrace();
			return null;
		}
		return productsList;
		
	}
}

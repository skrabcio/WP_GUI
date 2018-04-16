package pl.skrabcio;


public class ProductsTable{
	
	private int id_product;
    private String name_product;
 
    public int getId() {
        return id_product;
    }
    public void setId(int id_product) {
        this.id_product = id_product;
    }
    public String getName() {
        return name_product;
    }
    public void setName(String name_product) {
        this.name_product = name_product;
    }
  
 
    public ProductsTable() {}
    public ProductsTable(int id_product, String name_product) {
        this.id_product = id_product;
        this.name_product = name_product;
    }
 
    @Override
    public String toString() {
        return "["+id_product+"] - "+name_product;
    }

}

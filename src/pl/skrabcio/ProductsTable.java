package pl.skrabcio;


public class ProductsTable{
	
	private int id_product;
    private String name_product;
    private boolean isDeleted;
 
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
    public boolean isDeleted() {
        return isDeleted;
    }
    public void isDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
  
 
    public ProductsTable() {}
    public ProductsTable(int id_product, String name_product, boolean isDeleted) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.isDeleted = isDeleted;
    }
 
    @Override
    public String toString() {
        return "["+id_product+"] - "+name_product+" - "+isDeleted;
    }

}

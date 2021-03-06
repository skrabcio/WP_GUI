package pl.skrabcio;


public class PrivilegesTable{

	private int id_privileges;
    private String name_privileges;
    private boolean isDeleted;
    
    public int getId() {
        return id_privileges;
    }
    public void setId(int id_privileges) {
        this.id_privileges = id_privileges;
    }
    public String getName() {
        return name_privileges;
    }
    public void setName(String name_privileges) {
        this.name_privileges = name_privileges;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void isDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
  
 
    public PrivilegesTable() {}
    public PrivilegesTable(int id_privileges, String name_privileges, boolean isDeleted) {
        this.id_privileges = id_privileges;
        this.name_privileges = name_privileges;
        this.isDeleted = isDeleted;
    }
 
    @Override
    public String toString() {
        return "["+id_privileges+"] - "+name_privileges+" - "+isDeleted;
    }
	

}

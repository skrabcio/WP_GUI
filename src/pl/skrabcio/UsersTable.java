package pl.skrabcio;


public class UsersTable {

	private int id_user;
    private String name_user;
    private String mail_user;
    private boolean isDeleted;
 
    public int getId() {
        return id_user;
    }
    public void setId(int id_user) {
        this.id_user = id_user;
    }
    public String getName() {
        return name_user;
    }
    public void setName(String name_user) {
        this.name_user = name_user;
    }
    public String getMail() {
        return mail_user;
    }
    public void setMail(String mail_user) {
        this.mail_user = mail_user;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void isDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
 
    public UsersTable() {}
    public UsersTable(int id_user, String name_user, String mail_user, boolean isDeleted) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.mail_user = mail_user;
        this.isDeleted = isDeleted;
    }
 
    @Override
    public String toString() {
        return "["+id_user+"] - "+name_user+" - "+mail_user+" - "+isDeleted;
    }


}
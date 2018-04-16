package pl.skrabcio;

import java.util.ArrayList;

public interface AppFactoryInterface {
	
	public void addItem(String nameItem);
	public void deleteItem(int indexItem);
	public ArrayList<String> getItem();
	public void sortItem();

}

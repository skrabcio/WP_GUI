package pl.skrabcio;

import java.util.ArrayList;
import java.util.List;

public interface AppFactoryInterface {
	
	public boolean insert(String arg0, String...args);
	public List select();
	public boolean delete(int id);
	
	

}

package pl.skrabcio;

import java.util.ArrayList;

public class AppFactory {
	
	public enum FactoryType{
		Users,
		Products,
		Privileges
	}
	
	public static AppFactoryInterface createFactory(FactoryType factoryType) {
		
		switch (factoryType) {
			case Users: return new Users();
			case Privileges: return new Privileges();
			case Products: return new Products();
		}
		throw new IllegalArgumentException(" Nie znaleziono " + factoryType);
	}

}
package pl.skrabcio;
	
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.skrabcio.AppFactory.FactoryType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;



public class Main extends Application{
	
	AppFactoryInterface factoryUsers = (new AppFactory()).createFactory(FactoryType.Users);
	AppFactoryInterface factoryProducts = (new AppFactory()).createFactory(FactoryType.Products);
	AppFactoryInterface factoryPrivileges = (new AppFactory()).createFactory(FactoryType.Privileges);
	List<UsersTable> usersItem; 
	List<ProductsTable> productsItem; 
	List<PrivilegesTable> privilegesItem; 
	
	Stage window;
	Scene scene;
	Button addButton, delButton, getButton;
	ChoiceBox<String> tableChoiceBox;
	ListView<String> listView;
	 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start (Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Java GUI App");
		
		addButton = new Button("Add");
		delButton = new Button("Del");
		getButton = new Button("Get");
		tableChoiceBox = new ChoiceBox<>();
		
		tableChoiceBox.getItems().add("Users");
		tableChoiceBox.getItems().add("Products");
		tableChoiceBox.getItems().add("Privileges");
		tableChoiceBox.setValue("Users");
		
		listView = new ListView<>();
		listView.getItems().addAll(getList(tableChoiceBox));
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		getButton.setOnAction(e-> getList(tableChoiceBox));
		getButton.setOnAction(e-> refresh());
		tableChoiceBox.setOnAction(e-> getList(tableChoiceBox));
		tableChoiceBox.setOnAction(e-> refresh());
		delButton.setOnAction(e->deleteItem());
				
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, tableChoiceBox, addButton, delButton, getButton);
		scene = new Scene(layout, 640, 480);
		window.setScene(scene);
		window.show();
	}	
	
	private void refresh() {
		
		listView.getItems().clear();
		listView.getItems().addAll(getList(tableChoiceBox));
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	
	private List getList(ChoiceBox<String> tableChoiceBox) {
		
	switch (tableChoiceBox.getValue()) {
	case "Users":
		usersItem = factoryUsers.select();
		return factoryUsers.select();
	case "Products":
		productsItem = factoryProducts.select();
		return factoryProducts.select();
	case "Privileges":	
		privilegesItem = factoryPrivileges.select();
		return factoryPrivileges.select();
	default:
		usersItem = factoryUsers.select();
		System.out.println(usersItem);
		return factoryUsers.select();
	}
	}
	private boolean deleteItem() {
	
		switch (tableChoiceBox.getValue()) {
		case "Users":
			factoryUsers.delete((usersItem.get(listView.getSelectionModel().getSelectedIndex()).getId()));
			return true;
		case "Products":
			factoryProducts.delete((productsItem.get(listView.getSelectionModel().getSelectedIndex()).getId()));
			return true;
		case "Privileges":		
			factoryPrivileges.delete((privilegesItem.get(listView.getSelectionModel().getSelectedIndex()).getId()));
			return true;
	
		}
		return false;		
		
	}
}

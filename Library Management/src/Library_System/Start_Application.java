package Library_System;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Start_Application extends Application  {

	static public Stage stage;
	

	@Override
	public void start(Stage principal) throws Exception {
		
		stage=principal;
		
Parent Home_root = FXMLLoader.load(this.getClass().getResource("ManageBorrowers.fxml"));
		
		Scene Home =new Scene(Home_root);
		Home.getStylesheets().add(getClass().getResource("manageborrowers.css").toExternalForm());
		
		principal.setTitle("Library Mangement System");
		principal.setResizable(false);
		
		
		principal.setScene(Home);
		principal.show();
	}
	
	
     public static void main(String[] args) {
		
    	 launch(args);
	}

}

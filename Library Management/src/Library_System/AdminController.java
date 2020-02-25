package Library_System;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Library_System.Start_Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class AdminController implements Initializable {
	
	
	
	 @FXML
	    private JFXButton ManageStudent;

	    @FXML
	    private JFXButton ManageBook;

	    @FXML
	    private JFXButton SearchBook;

	    @FXML
	    private JFXButton ManageBorrowers;

	    @FXML
	    private JFXButton GeneraleRapport;

	    @FXML
	    private JFXButton LogOut;
	    
	    @FXML
	    private JFXButton BackAdmin;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ManageStudent.setId("managestudent");
		ManageBook.setId("managebook");
		ManageBorrowers.setId("boorowbook");
		SearchBook.setId("search");
		GeneraleRapport.setId("general");
		LogOut.setId("logout");
		
		GeneraleRapport.setOnAction(a->{
			
			try {
				Parent ManageS_root = FXMLLoader.load(this.getClass().getResource("GeneralRapport.fxml"));
				Scene Login =new Scene(ManageS_root);
				Login.getStylesheets().add(getClass().getResource("generalrapport.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});
		
		ManageStudent.setOnAction(a->{
			try {
				Parent ManageS_root = FXMLLoader.load(this.getClass().getResource("ManageStudent.fxml"));
				Scene Login =new Scene(ManageS_root);
				Login.getStylesheets().add(getClass().getResource("managestudent.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		});
		
		ManageBook.setOnAction(a->{
			
			try {
				Parent ManageB_root = FXMLLoader.load(this.getClass().getResource("ManageBook.fxml"));
				Scene Login =new Scene(ManageB_root);
				Login.getStylesheets().add(getClass().getResource("managebook.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		});
		
		SearchBook.setOnAction(a->{
			
			try {
				Parent ManageB_root = FXMLLoader.load(this.getClass().getResource("SearchBook.fxml"));
				Scene Login =new Scene(ManageB_root);
				Login.getStylesheets().add(getClass().getResource("search.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		});
		
		LogOut.setOnAction(a->{
			
			Parent Login_root;
			try {
				Login_root = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
				Scene login =new Scene(Login_root);
				login.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
				Start_Application.stage.setScene(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		ManageBorrowers.setOnAction(a->{
			
			Parent Login_root;
			try {
				Login_root = FXMLLoader.load(this.getClass().getResource("ManageBorrowers.fxml"));
				Scene login =new Scene(Login_root);
				login.getStylesheets().add(getClass().getResource("manageborrowers.css").toExternalForm());
				Start_Application.stage.setScene(login);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	
		
	}

}

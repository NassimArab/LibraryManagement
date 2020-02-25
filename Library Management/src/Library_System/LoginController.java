package Library_System;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.management.Notification;
import javax.naming.spi.DirStateFactory.Result;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Library_System.Start_Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

import java.sql.*;

public class LoginController implements Initializable {
	
	@FXML
    private JFXButton BackLogin;

    @FXML
    private JFXButton ForgotButton;

    @FXML
    private JFXTextField StudentUserLogin;

    @FXML
    private JFXPasswordField StudentPasswordLogin;

    @FXML
    private JFXButton LoginStudent;

    @FXML
    private JFXButton SignupStudent;

    @FXML
    private JFXTextField LibrianUserLogin;

    @FXML
    private JFXPasswordField LibrianPasswordLogin;
    @FXML
    private JFXButton LoginLibrian;

    @FXML
    private JFXButton CancelLibrian;
    
    @FXML
    private JFXTextField SuperAdminUserLogin;

    @FXML
    private JFXPasswordField SuperAdminPasswordLogin;

    @FXML
    private JFXButton SuperAdminLogin;

    @FXML
    private JFXButton CancelSuperAdmin;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 final  String user_id ;
		
SignupStudent.setOnAction(e->{
			
			try {
				Parent Signup_root = FXMLLoader.load(this.getClass().getResource("Signup.fxml"));
				Scene signup =new Scene(Signup_root);
				signup.getStylesheets().add(getClass().getResource("signup.css").toExternalForm());
				Start_Application.stage.setScene(signup);
				
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		
		ForgotButton.setOnAction(e->{
			
			
			try {
				Parent Forgot_root = FXMLLoader.load(this.getClass().getResource("ForgotPassword.fxml"));
				
				Scene forgot =new Scene(Forgot_root);
				forgot.getStylesheets().add(getClass().getResource("forgot.css").toExternalForm());
				

				Start_Application.stage.setScene(forgot);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
		});
		
		BackLogin.setOnAction(e->{
			
			try {
				Parent Home_root = FXMLLoader.load(this.getClass().getResource("HomePage.fxml"));
				Scene home =new Scene(Home_root);
				home.getStylesheets().add(getClass().getResource("lib.css").toExternalForm());
				Start_Application.stage.setScene(home);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		});
		
		CancelLibrian.setOnAction(a->{
			
			LibrianUserLogin.setText("");
			LibrianPasswordLogin.setText("");
			
		});
		
		CancelSuperAdmin.setOnAction(a->{
			
			SuperAdminUserLogin.setText("");
			SuperAdminPasswordLogin.setText("");
			
		});
		
		
		LoginStudent.setOnAction(a->{
			try {
				
				
				if(StudentUserLogin.getText().isEmpty() || StudentPasswordLogin.getText().isEmpty())
				{
					
					 Notifications n = Notifications.create();
			         n.title("Error");
			         n.text("Text Field Empty");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showError();
			         return;
			         
					/*Alert alert =new Alert(AlertType.ERROR);
		        	   alert.setContentText("field text empty");
		        	   alert.setHeaderText(null);
		        	   alert.showAndWait();
		        	   return;*/
					
					
				}
				Student s1 =new Student();
				
				s1.login(StudentUserLogin.getText(), StudentPasswordLogin.getText());
				//////////////
				BorrowBookController.UserId=StudentUserLogin.getText();
				/////////////////
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		LoginLibrian.setOnAction(a->{
			
			if(LibrianUserLogin.getText().isEmpty() || LibrianPasswordLogin.getText().isEmpty())
			{
				
				 Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("Text Field Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
				/*Alert alert =new Alert(AlertType.ERROR);
	        	   alert.setContentText("field text empty");
	        	   alert.setHeaderText(null);
	        	   alert.showAndWait();*/
	        	   return;
			}
			
			Librian l1 =new Librian();
			
			try {
				
				l1.login(LibrianUserLogin.getText(), LibrianPasswordLogin.getText());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		});
		
		SuperAdminLogin.setOnAction(a->{
			
			if(SuperAdminUserLogin.getText().isEmpty() || SuperAdminPasswordLogin.getText().isEmpty())
			{
				 Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("Text Field Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
				/*Alert alert =new Alert(AlertType.ERROR);
	        	   alert.setContentText("field text empty");
	        	   alert.setHeaderText(null);
	        	   alert.showAndWait();*/
	        	   return;
			}
			
                   SuperAdmin s1 =new SuperAdmin();
			
			try {
				
				s1.login(SuperAdminUserLogin.getText(), SuperAdminPasswordLogin.getText());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		
	
		

}}

package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Library_System.Start_Application;

import java.sql.*;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class ForgotPassword implements Initializable {
	
	@FXML
    private JFXButton BackForgotButton;
  @FXML
    private JFXTextField UserForgot;

    @FXML
    private JFXTextField AnswerForgot;

    @FXML
    private JFXTextField SequrityQuestion;

    @FXML
    private JFXTextField PasswordForgot;

    @FXML
    private JFXButton ConfirmIdForgot;

    @FXML
    private JFXButton ConfirmAnswerButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		SequrityQuestion.setVisible(false);
		AnswerForgot.setVisible(false);
		PasswordForgot.setVisible(false);
		ConfirmAnswerButton.setVisible(false);
		
		
		
		
		BackForgotButton.setOnAction(e->{
			try {
				Parent Back_root =FXMLLoader.load(this.getClass().getResource("Login.fxml"));
				Scene Back =new Scene(Back_root);
				Back.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
				
				Start_Application.stage.setScene(Back);
				
			} catch (IOException e1) {
								e1.printStackTrace();
			}
		});
		
		ConfirmIdForgot.setOnAction(a->{
			
			if( UserForgot.getText().isEmpty())
			{
				 Notifications n = Notifications.create();
  		         n.title("Error");
  		         n.text("field text empty");
  		         n.graphic(null);
  		         n.hideAfter(Duration.seconds(5));
  		         n.position(Pos.BOTTOM_RIGHT);
  		         n.showError();
  		         
				/*Alert alert =new Alert(AlertType.ERROR);
				alert.setContentText("field text empty");
	        	   alert.showAndWait();*/
	        	   return;
			}
			
			Student s1 =new Student();
			try {
				s1.forgot_password(UserForgot.getText(), SequrityQuestion, AnswerForgot, PasswordForgot, ConfirmIdForgot, ConfirmAnswerButton);
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		ConfirmAnswerButton.setOnAction(a->{
			
			Student s1 =new Student();
			
			
			if( AnswerForgot.getText().isEmpty())
			{
				
				 Notifications n = Notifications.create();
  		         n.title("Error");
  		         n.text("field text empty");
  		         n.graphic(null);
  		         n.hideAfter(Duration.seconds(5));
  		         n.position(Pos.BOTTOM_RIGHT);
  		         n.showError();
  		         
			/*	Alert alert =new Alert(AlertType.ERROR);
				alert.setContentText("field text empty");
	        	   alert.showAndWait();*/
	        	   return;
			}
			
			  Connection con;
			try {
				
				String id=s1.forgot_password(UserForgot.getText(), SequrityQuestion, AnswerForgot, PasswordForgot, ConfirmIdForgot, ConfirmAnswerButton);
				
				con = DBConnection.getconnection();
				PreparedStatement pst;
		          ResultSet res ;
		          String query=("select * from  student_login where student_id= ?  ");
		          
		          pst=(PreparedStatement) con.prepareStatement(query);
		          pst.setString(1,id );
		          res =pst.executeQuery();
		         
		          
		          if(res.next() && res.getString(4).equals(AnswerForgot.getText()))
		          {
		        	  PasswordForgot.setVisible(true);
		        	  PasswordForgot.setText(res.getString(2));
		          }
		          else
		          {
		        	  
		        	  Notifications n = Notifications.create();
		  		         n.title("Error");
		  		         n.text("Wrong Answer");
		  		         n.graphic(null);
		  		         n.hideAfter(Duration.seconds(5));
		  		         n.position(Pos.BOTTOM_RIGHT);
		  		         n.showError();
		  		         
		        	/*  Alert alert =new Alert(AlertType.ERROR);
						alert.setContentText("Wrong Answer");
			        	   alert.showAndWait();*/
		          }
		        	 
		        	  
		          
		         
		          
		          pst.close();
		          con.close();
		          
		         
		          
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          
	          
			
			
		});
		
		
	}

}

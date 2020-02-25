package Library_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import Library_System.Start_Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

import java.sql.*;

public class Student {
	
	private String student_id;
	private String pass_word;
	
	/////////////
	
	
	
	
	//////////////
	
	
	
	// begin void student login
	 void login(String StudentId,String PassWord) throws SQLException
	{
		
          Connection con =DBConnection.getconnection();
         
          PreparedStatement pst;
          ResultSet res ;
          String query=("select * from student_login where student_id= ? and pass_word=?");
          
           pst=(PreparedStatement) con.prepareStatement(query);
           pst.setString(1, StudentId);
           pst.setString(2, PassWord);
          
           res =pst.executeQuery();
           
           if(res.next())
           {
        	   try {
   				Parent Home_root = FXMLLoader.load(this.getClass().getResource("Student.fxml"));
   				Scene home =new Scene(Home_root);
   				home.getStylesheets().add(getClass().getResource("student.css").toExternalForm());
   				Start_Application.stage.setScene(home);
   			} catch (IOException e1) {
   				
   				e1.printStackTrace();
   			}
        	   
           }
           
           else {
        	   Alert alert =new Alert(AlertType.ERROR);
        	   alert.setContentText("user id or pass word incorrect");
        	   alert.setHeaderText(null);
        	   alert.showAndWait();
        	   
        	   
               }
           
        } // end void student login
	 
	     //begin signu up student
	 void sign_up (String StudentId ,String PassWord , String SecurityQuestion , String Answer) throws SQLException
	 {
		 
		 Connection con =DBConnection.getconnection();
		 
         PreparedStatement pst;
         ResultSet res ;
         String query=("select * from  student where StudentId= ? ");
         
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setString(1, StudentId);
         res =pst.executeQuery();
         
         if(res.next())
         {
        	 String query_insert=("INSERT INTO student_login (student_id, pass_word, security_question, answer) VALUES (?,?,?,?) ");
        	 PreparedStatement pst_insert = (PreparedStatement) con.prepareStatement(query_insert);
        	 
        	 pst_insert.setString(1, StudentId);
        	 pst_insert.setString(2, PassWord);
        	 pst_insert.setString(3, SecurityQuestion);
        	 pst_insert.setString(4, Answer);
        	 
        	 pst_insert.execute();
        	 
        	 Notifications n = Notifications.create();
			 n.title("confirmation");
	         n.text("Student Aded Sucssufly");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showConfirm();
        	 
        	 
         }
         else
         {
        	 Notifications n = Notifications.create();
			 n.title("Error");
	         n.text("You Should Aded By Librian");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showError();
        	 
         }
	 } //end void sign up student
         
        
         
         //begin void forgot pass word
   
	 
	 String forgot_password(String StudentId , JFXTextField SequrityQuestion ,JFXTextField AnswerForgot,JFXTextField PasswordForgot,JFXButton ConfirmIdForgot,JFXButton ConfirmAnswerButton) throws SQLException
     {
   	  
   	  Connection con =DBConnection.getconnection();
         PreparedStatement pst;
         ResultSet res ;
         String query=("select * from  student_login where student_id= ? ");
         
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setString(1, StudentId);
         res =pst.executeQuery();
         
         if(res.next())
         {
       	 
       	  SequrityQuestion.setVisible(true);
       	  AnswerForgot.setVisible(true);
       	  ConfirmAnswerButton.setVisible(true);
       	  SequrityQuestion.setText(res.getString(3));
       	  
       	  
       	  
       	  
         }
         
         else
         {
        	 
        	 Notifications n = Notifications.create();
			 n.title("Error");
	         n.text("Create compte");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showError();
	        	   
         }
         
         return StudentId;
   	 
   	  
   	  
     }
     
      
      
    
      //end void forgot pass word
       
         
         
         
		 
	 
	
}

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

public class SuperAdmin {
	
	private String student_id;
	private String pass_word;
	
	
	public void login(String StudentId,String PassWord) throws SQLException
	{

        Connection con =DBConnection.getconnection();
       
        PreparedStatement pst;
        ResultSet res ;
        String query=("select * from super_admin where UserName= ? and PassWord=?");
        
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setString(1, StudentId);
         pst.setString(2, PassWord);
        
         res =pst.executeQuery();
         
         if(res.next())
         {
      	   try {
 				Parent Home_root = FXMLLoader.load(this.getClass().getResource("SuperAdmin.fxml"));
 				Scene home =new Scene(Home_root);
 				home.getStylesheets().add(getClass().getResource("superadmin.css").toExternalForm());
 				Start_Application.stage.setScene(home);
 			} catch (IOException e1) {
 				
 				e1.printStackTrace();
 			}
      	   
         }
         
         else {
        	 Notifications n = Notifications.create();
			 n.title("Error");
	         n.text("User Id or Pass Word Incorrect");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showError();
      	   
      	   
             }
         
         
	}

}

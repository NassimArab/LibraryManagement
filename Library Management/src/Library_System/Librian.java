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

public class Librian {
	
	private String userid;
	private String password;
	private String firstname;
	private String lastname;
	private int phone;
	
	public Librian()
	{
		
	}
	public Librian(String userid, String password, String firstname, String lastname, int phone) {
		
		this.userid = userid;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}
	
	
	
	//////////////////////////


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void login(String user,String pass) throws SQLException
	{
		 Connection con =DBConnection.getconnection();
         
         PreparedStatement pst;
         ResultSet res ;
         String query=("select * from librian where  	UserId = ? and PassWord = ?");
         
          pst=(PreparedStatement) con.prepareStatement(query);
          pst.setString(1, user);
          pst.setString(2, pass);
         
          res =pst.executeQuery();
          
          if(res.next())
          {
        	  
        	  try {
     				Parent Home_root = FXMLLoader.load(this.getClass().getResource("Admin.fxml"));
     				Scene home =new Scene(Home_root);
     				home.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
     				Start_Application.stage.setScene(home);
     			} catch (IOException e1) {
     				
     				e1.printStackTrace();
     			}
          }
          
          else
          {
        	  Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("user id or pass word incorrect");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
        	  /*Alert alert =new Alert(AlertType.ERROR);
       	   alert.setContentText("user id or pass word incorrect");
       	   alert.showAndWait();*/
          }
		
	}
	
	

}

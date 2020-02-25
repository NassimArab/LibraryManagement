package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import Library_System.Start_Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;


public class SuperAdminController implements Initializable {
	
	@FXML
    private JFXTextField AddUserLibrian;

    @FXML
    private JFXTextField AddNameLibrian;

    @FXML
    private JFXTextField AddPhoneLibrian;

    @FXML
    private JFXPasswordField AddPasswordLibrian;

    @FXML
    private JFXButton AddNewLibrianSave;

    @FXML
    private JFXTextField DeleteLibrianUser;

    @FXML
    private JFXButton ConfirmDeleteLibrian;
    
    @FXML
    private JFXTextField AddLastNameLibrian;

    
    @FXML
    private JFXButton SuperAdminLogout;
    
    @FXML
    private TableView<Librian> TableView;

    @FXML
    private TableColumn<Librian, String> Id;

    @FXML
    private TableColumn<Librian, String> Pass;

    @FXML
    private TableColumn<Librian, String> FirstN;

    @FXML
    private TableColumn<Librian, String> LastN;

    @FXML
    private TableColumn<Librian, String> Phone;
    
    ObservableList<Librian> oblist = FXCollections.observableArrayList();

    @FXML
    private JFXButton Refrech;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Refrech.setOnAction(a->{
TableView.getItems().clear();
			
			
			try {
				Connection con;
				con = DBConnection.getconnection();
				PreparedStatement pst;
		         ResultSet res ;
		         String query=("select * from  librian  ");
		         
		          pst=(PreparedStatement) con.prepareStatement(query);
		          
		          res =pst.executeQuery();
		          
		          while(res.next())
		          {
		        	  oblist.add(new Librian(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
		          }
		          
		       
		          
		          
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Id.setCellValueFactory(new PropertyValueFactory<>("userid"));
			Pass.setCellValueFactory(new PropertyValueFactory<>("password"));
			FirstN.setCellValueFactory(new PropertyValueFactory<>("firstname"));
			LastN.setCellValueFactory(new PropertyValueFactory<>("lastname"));
			Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		  		
		  		TableView.setItems(oblist);
	         
		});
		
		ConfirmDeleteLibrian.setOnAction(a->{
			
			if(DeleteLibrianUser.getText().isEmpty())
			{
				 Notifications n = Notifications.create();
				 n.title("Error");
		         n.text("Field Text Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
		         
	        	   DeleteLibrianUser.setText("");
	        	   return;
				
			}
			
			Connection con2;
			try {
				con2 = DBConnection.getconnection();
				PreparedStatement pst2;
		        ResultSet res ;
		        String query=("select * from  librian where  	UserId= ? ");
		        
		         pst2=(PreparedStatement) con2.prepareStatement(query);
		         pst2.setString(1, DeleteLibrianUser.getText());
		         res =pst2.executeQuery();
		         
		         if(!res.next())
		         {
		        	 Notifications n = Notifications.create();
					 n.title("Error");
			         n.text("Librian not Exist");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showError();
		      	 DeleteLibrianUser.setText("");
		      	   return;
		         }
				
				/////////////////////////////////////
		          Connection con =DBConnection.getconnection();
				 
		         PreparedStatement pst;
		         String query_insert=("DELETE FROM librian where UserId = ? ");
		         pst=(PreparedStatement) con.prepareStatement(query_insert);
		         pst.setString(1, DeleteLibrianUser.getText());
		         pst.execute();
		         
		         Notifications n = Notifications.create();
				 n.title("confirmation");
		         n.text("Librian deleted Sucssufly");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showConfirm();
		    	 
		    	 DeleteLibrianUser.setText("");
		    	 
		    	 pst.close();
		    	 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
			
			
		});
		
		SuperAdminLogout.setOnAction(a->{
			
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
		
		AddNewLibrianSave.setOnAction(a->{
			if(AddLastNameLibrian.getText().isEmpty() || AddUserLibrian.getText().isEmpty() || AddNameLibrian.getText().isEmpty() || AddPhoneLibrian.getText().isEmpty() || AddPasswordLibrian.getText().isEmpty())
			{

				 Notifications n = Notifications.create();
				 n.title("Error");
		         n.text("Text Field Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
	        	   
	        	   AddUserLibrian.setText("");
			    	  AddPasswordLibrian.setText("");
			    	  AddNameLibrian.setText("");
			    	  AddLastNameLibrian.setText("");
			    	  AddPhoneLibrian.setText("");
	        	   return;
				
			}
			
			int phone=Integer.parseInt(AddPhoneLibrian.getText());
			Connection con;
			try {
				con = DBConnection.getconnection();
				 PreparedStatement pst;
		         String query_insert=("INSERT INTO librian (UserId, PassWord, FirstName, LastName , PhoneNumber) VALUES (?,?,?,?,?) ");
		         pst=(PreparedStatement) con.prepareStatement(query_insert);
		         
		        
		         pst.setString(1, AddUserLibrian.getText());
		    	 pst.setString(2, AddPasswordLibrian.getText());
		    	 pst.setString(3, AddNameLibrian.getText());
		    	 pst.setString(4, AddLastNameLibrian.getText());
		    	 pst.setInt(5, phone);
		    	
		    	 
		    	 
		    	  pst.execute();
		    	  
		    	  pst.close();
		    	  
		    	  AddUserLibrian.setText("");
		    	  AddPasswordLibrian.setText("");
		    	  AddNameLibrian.setText("");
		    	  AddLastNameLibrian.setText("");
		    	  AddPhoneLibrian.setText("");
		    		
		    	  Notifications n = Notifications.create();
					 n.title("confirmation");
			         n.text("Librian Aded Sucssufly");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showConfirm();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	        
			
			
		});
		
		
	}

}

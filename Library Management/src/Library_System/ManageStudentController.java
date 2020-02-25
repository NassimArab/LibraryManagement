package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.management.Notification;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import Library_System.Start_Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class ManageStudentController implements Initializable {
	
	
	

    @FXML
    private JFXTextField AddUserId;

    @FXML
    private JFXTextField AddName;

    @FXML
    private JFXTextField AddFamilyName;

    @FXML
    private JFXTextField AddBranch;

    @FXML
    private JFXTextField AddYear;

    @FXML
    private JFXButton AddStudentRegister;

    /*@FXML
    private JFXDatePicker AddDate;*/

    @FXML
    private JFXTextField DeleteId;

    @FXML
    private JFXButton DeletIdConfirm;

    @FXML
    private AnchorPane UserDetail;

    @FXML
    private JFXTextField DetailUser;

    @FXML
    private JFXTextField NameDetail;

    @FXML
    private JFXTextField FamilyNameDetail;

    @FXML
    private JFXTextField BranchDetail;

    @FXML
    private JFXTextField YearDetail;

    @FXML
    private JFXButton BackManageStudent;
    
    @FXML
    private JFXButton GetInfo;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		NameDetail.setVisible(false);
		FamilyNameDetail.setVisible(false);
		BranchDetail.setVisible(false);
		YearDetail.setVisible(false);
		
		
		
		GetInfo.setOnAction(a->{
			
			if(DetailUser.getText().isEmpty())
			{
				 Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("Text Field Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
		         return;
		         
				
				
			}
			
			Connection con;
			try {
				con = DBConnection.getconnection();
				
				 PreparedStatement pst;
		         ResultSet res ;
		         String query=("select * from  student where StudentId= ? ");
		         
		          pst=(PreparedStatement) con.prepareStatement(query);
		          pst.setString(1, DetailUser.getText());
		          res =pst.executeQuery();
		          
		          if(res.next())
		          {
		        	  NameDetail.setVisible(true);
		        	  FamilyNameDetail.setVisible(true);
		        	  BranchDetail.setVisible(true);
		        	  YearDetail.setVisible(true);
		        	  
		        	  NameDetail.setText("Name : "+res.getString(3));
		        	  FamilyNameDetail.setText("F Name : "+res.getString(2));
		        	  BranchDetail.setText("Branch : "+res.getString(4));
		        	  YearDetail.setText("Year :"+res.getString(5));
		          }
		          else
		          {
		        	  
		        	  Notifications n = Notifications.create();
				         n.title("Error");
				         n.text("Student does not existe");
				         n.graphic(null);
				         n.hideAfter(Duration.seconds(5));
				         n.position(Pos.BOTTOM_RIGHT);
				         n.showError();
				         
		        	 
		          }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	        
			
		});
		
		DeletIdConfirm.setOnAction(a->{
			
			if(DeleteId.getText().isEmpty())
			{
				Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("Text Field Empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
		         
		      	 
		      	   return; 
				
			}
			 Connection con2;
			try {
				con2 = DBConnection.getconnection();
				
				PreparedStatement pst2;
		        ResultSet res ;
		        String query=("select * from   student where  	StudentId= ? ");
		        
		         pst2=(PreparedStatement) con2.prepareStatement(query);
		         pst2.setString(1, DeleteId.getText());
		         res =pst2.executeQuery();
		         
		         if(!res.next())
		         {
		        	 Notifications n = Notifications.create();
			         n.title("Error");
			         n.text("Wrong Student User");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showError();
		        	
		      	 DeleteId.setText("");
		      	   return;
		         }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
				/////////////////////////////////////
		          Connection con;
				try {
					con = DBConnection.getconnection();
					 PreparedStatement pst;
			         String query_insert=("DELETE FROM student WHERE StudentId = ? ");
			         pst=(PreparedStatement) con.prepareStatement(query_insert);
			         pst.setString(1, DeleteId.getText());
			         pst.execute();
			         
			         Notifications n = Notifications.create();
			         n.title("Confirmation");
			         n.text("Student deleted successfully");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showConfirm();
			         
			         
			    	 
			    	 DeleteId.setText("");
			    	 
			    	 pst.close();
			    	 con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
		        
				
		});
		
BackManageStudent.setOnAction(a->{
			
			try {
				Parent admin_root = FXMLLoader.load(this.getClass().getResource("Admin.fxml"));
				Scene Login =new Scene(admin_root);
				Login.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});

AddStudentRegister.setOnAction(a->{
	
	if(AddUserId.getText().isEmpty() || AddName.getText().isEmpty() || AddFamilyName.getText().isEmpty() || AddBranch.getText().isEmpty() || AddYear.getText().isEmpty() )
	{
		 Notifications n = Notifications.create();
         n.title("Error");
         n.text("Field Text Empty");
         n.graphic(null);
         n.hideAfter(Duration.seconds(5));
         n.position(Pos.BOTTOM_RIGHT);
         n.showError();
    	   
    	   AddUserId.setText("");
    	   AddName.setText("");
    	   AddFamilyName.setText("");
    	   AddBranch.setText("");
    	   AddYear.setText("");
    	 
    	 
    	 
    	   
    	  
    	   return;
		
	}
	
	
	
	
	Connection con;
	try {
		con = DBConnection.getconnection();
		 PreparedStatement pst;
         //String query_insert=("INSERT INTO student (StudentId, FirstName,  	LastName,  	DateOfBearth , Branch,Year) VALUES (?,?,?,?,?,?) ");
		 String query_insert=("INSERT INTO student (StudentId, FirstName,  	LastName , Branch,Year) VALUES (?,?,?,?,?) ");
         
         pst=(PreparedStatement) con.prepareStatement(query_insert);
        
        
         pst.setString(1, AddUserId.getText());
    	 pst.setString(2, AddName.getText());
    	 pst.setString(3, AddFamilyName.getText());
    	 
    	// pst.setString(4, AddDate.getValue().toString());
    	 pst.setString(4, AddBranch.getText());
    	 pst.setInt(5, Integer.parseInt(AddYear.getText()));
    	// pst.setString(5, AddBranch.getText());
    	 //pst.setInt(6, Integer.parseInt(AddYear.getText()));
    	
    	 
    	 
    	  pst.execute();
    	  
    	  pst.close();
    	  
    	  AddUserId.setText("");
    	  AddName.setText("");
    	  AddFamilyName.setText("");
    	 // AddDate.setValue(null);
    	  AddBranch.setText("");
    	  AddYear.setText("");
    		
    	  Notifications n = Notifications.create();
          n.title("Confirmation");
          n.text("Student Aded Sucssufly");
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

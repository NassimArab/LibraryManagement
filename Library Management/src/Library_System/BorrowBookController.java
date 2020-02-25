package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class BorrowBookController implements Initializable {
	
	 @FXML
	    private JFXTextField BookId;

	    @FXML
	    private Label BookName;

	    @FXML
	    private Label BookAuthor;

	    @FXML
	    private JFXTextField StudentId;

	    @FXML
	    private Label StudentName;

	    @FXML
	    private JFXButton IssueBook;

	    @FXML
	    private JFXButton BackButton;
	    
	    static String UserId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		IssueBook.setOnAction(a->{
			
			if(BookId.getText().isEmpty())
			{
				
				Notifications n = Notifications.create();
		         n.title("Error");
		         n.text("text field empty");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
		         
				/* Alert alert=new Alert(Alert.AlertType.ERROR);
	          	 alert.setContentText("text field empty");
	          	alert.setHeaderText(null);
	          	 alert.showAndWait();*/
	          	 return;
			}
			
			 
			try {
				Connection con;
				con = DBConnection.getconnection();
				

		          PreparedStatement pst;
		          ResultSet res ;
		          String query=("select * from examplaire where  	 	id = ? ");
		          
		          int bookid=Integer.parseInt(BookId.getText());
		          
		           pst=(PreparedStatement) con.prepareStatement(query);
		           pst.setInt(1, bookid);
		           
		          
		           res =pst.executeQuery();
		           
		           if(res.next())
		           {
		        	   if(res.getInt(6) == 0)
		        	   {
		        		   
		        		   Notifications n = Notifications.create();
		  		         n.title("Error");
		  		         n.text("Book Not Avaible");
		  		         n.graphic(null);
		  		         n.hideAfter(Duration.seconds(5));
		  		         n.position(Pos.BOTTOM_RIGHT);
		  		         n.showError();
		  		         
		        		  /* Alert alert=new Alert(Alert.AlertType.ERROR);
		  	          	 alert.setContentText("Book Not Avaible");
		  	          	alert.setHeaderText(null);
		  	          	 alert.showAndWait();*/
		  	          	 return;
		        		   
		        	   }
		        	 String query_insert=("INSERT INTO reservation (student_id, book_id) VALUES (?,?) ");
		          	 PreparedStatement pst_insert = (PreparedStatement) con.prepareStatement(query_insert);
		          	 
		          	 pst_insert.setString(1, UserId);
		          	 pst_insert.setInt(2, bookid);
		          	 
		          	 
		          	 pst_insert.execute();
		          	 
		          	 Notifications n = Notifications.create();
	  		         n.title("confirmation");
	  		         n.text("Book successfully reserved , contact librian");
	  		         n.graphic(null);
	  		         n.hideAfter(Duration.seconds(5));
	  		         n.position(Pos.BOTTOM_RIGHT);
	  		         n.showConfirm();
	  		         
		          	/* Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
		          	 alert.setContentText("Book successfully reserved , contact librian");
		          	alert.setHeaderText(null);
		          	 alert.showAndWait();*/
		          	 
		          	BookId.setText("");
		        	   
		           }
		           
		           else
		           {
		        	   Notifications n = Notifications.create();
		  		         n.title("Error");
		  		         n.text("Book not existed");
		  		         n.graphic(null);
		  		         n.hideAfter(Duration.seconds(5));
		  		         n.position(Pos.BOTTOM_RIGHT);
		  		         n.showError();
		  		         
		          	/* Alert alert=new Alert(Alert.AlertType.ERROR);
		          	 alert.setContentText("Book not existed");
		          	alert.setHeaderText(null);
		          	 alert.showAndWait();*/
		          	 
		          	BookId.setText("");
		          	 
		           }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	           
	           
	           
		});
		
		BackButton.setOnAction(a->{
			
			 Parent List_root;
				try {
					List_root = FXMLLoader.load(this.getClass().getResource("Student.fxml"));
					Scene list =new Scene(List_root);
					list.getStylesheets().add(getClass().getResource("student.css").toExternalForm());
					Start_Application.stage.setScene(list);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});
		
	}

}

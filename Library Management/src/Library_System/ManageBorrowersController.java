package Library_System;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class ManageBorrowersController implements Initializable {
	
	

	@FXML
    private TableView<Reservation> TableView;
	
	  @FXML
	    private TableView<IssueBook> TableViewI;

	
	   @FXML
	    private TableColumn<IssueBook,String> BookIdI;

	    @FXML
	    private TableColumn<IssueBook,String> StudentIdI;

	    @FXML
	    private TableColumn<IssueBook,String> DateP;

	    @FXML
	    private TableColumn<IssueBook,String> DateB;

	    @FXML
	    private TableColumn<Reservation, String> StudentIdR;

	    @FXML
	    private TableColumn<Reservation, String> BookIdR;
	    
	    ObservableList<Reservation> oblist = FXCollections.observableArrayList();
	    
	    ObservableList<IssueBook> list = FXCollections.observableArrayList();

	    @FXML
	    private JFXButton ConfirmReserve;
	    
	    @FXML
	    private JFXButton refrech;
	    
	    @FXML
	    private JFXButton rRefrechIssue;

	    @FXML
	    private JFXButton Back;
	    
	    @FXML
	    private JFXButton DeleteIssue;
	    
	    
	    
	    static int val1=0;
	    static String val2="";
	    static int val3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ConfirmReserve.setOnAction(a->{
			
			if(val1==0 && val2=="")
			{
				Notifications n = Notifications.create();
				 n.title("Error");
		         n.text("Not Book Selected");
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
		         //String query_insert=("INSERT INTO borrowed_book (num, student_id, book_id, date_of_borrow, date_back) VALUES (?,?,?,?,?	) ");
				 String query_insert=("INSERT INTO borrowed_book ( student_id, book_id, date_of_borrow, date_back)  VALUES (?,?,?,?) ");
		         //pst=(PreparedStatement) con.prepareStatement(query_insert);
		         pst=(PreparedStatement) con.prepareStatement(query_insert);
		         
		        // pst.setInt(1, 152);
		    	 pst.setString(1, val2);
		         pst.setInt(2, val1);
		         pst.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
		         pst.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now().plusMonths(2)));
		    	
		    	 
		    	 
		    	 
		    	  pst.execute();
		    	  
		    	  pst.close();
		     	  //con.close();
		     	  
		     	  /////////////////////////////////////////////////////////
		     	 Connection con1 =DBConnection.getconnection();
		 		 
		          PreparedStatement pst1;
		          String query_insert1=("DELETE FROM reservation WHERE book_id= ?  ");
		          pst1=(PreparedStatement) con.prepareStatement(query_insert1);
		          
		         // pst.setString(1, BookId);
		          pst1.setInt(1, val1);
		          
		     	 
		     	 
		     	  pst1.execute();
		     	  
		     	 pst1.close();
		     	 
		     	Reservation selectedItem = TableView.getSelectionModel().getSelectedItem();
		     	 TableView.getItems().remove(selectedItem);
		    	 //con1.close();
		     	 //////////////////////////////////////
		     	 
		     	Connection con2 =DBConnection.getconnection();
		 		 
		          PreparedStatement pst2;
		          String query_insert2=("UPDATE examplaire SET qte = qte-1 where id=? ");
		          pst2=(PreparedStatement) con2.prepareStatement(query_insert2);
		          
		         // pst.setString(1, BookId);
		          pst2.setInt(1, val1);
		          pst2.execute();
		         
		          
		     	 
		     	 
		     	 
		    	 
		     	  
		     	  
		     	  
		     	  /////////////////////////////////////////
		     	  

		          Notifications n = Notifications.create();
					 n.title("confirmation");
			         n.text("Book Issued Sucssefly");
			         n.graphic(null);
			         n.hideAfter(Duration.seconds(5));
			         n.position(Pos.BOTTOM_RIGHT);
			         n.showConfirm();	           
			         val1=0;
	            	 val2="";
	            	 
	            	
	            	 
	            	 
		     	  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	
			
			
			
		});
		
         DeleteIssue.setOnAction(a->{
        	 
        	 if(val3==0 )
 			{
        		 Notifications n = Notifications.create();
				 n.title("Error");
		         n.text("Not Book Selected");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showError();
            	 return;
 				
 			}
        	 
        	 
        	 
        	 Connection con1;
			try {
				con1 = DBConnection.getconnection();
				
				 PreparedStatement pst1;
		          String query_insert1=("DELETE FROM borrowed_book WHERE book_id= ?  ");
		          pst1=(PreparedStatement) con1.prepareStatement(query_insert1);
		          
		         // pst.setString(1, BookId);
		          pst1.setInt(1, val3);
		     	 
		     	 
		     	  pst1.execute();
		     	  
		     	 IssueBook selectedItem = TableViewI.getSelectionModel().getSelectedItem();
		     	 TableViewI.getItems().remove(selectedItem);
		     	  
		     	 pst1.close();
		     	 
		     	Notifications n = Notifications.create();
				 n.title("confirmation");
		         n.text("Issued Book Deleted");
		         n.graphic(null);
		         n.hideAfter(Duration.seconds(5));
		         n.position(Pos.BOTTOM_RIGHT);
		         n.showConfirm();
           	 
           	Connection con2 =DBConnection.getconnection();
	 		 
	          PreparedStatement pst2;
	          String query_insert2=("UPDATE examplaire SET qte = qte+1 where id=? ");
	          pst2=(PreparedStatement) con2.prepareStatement(query_insert2);
	          
	         // pst.setString(1, BookId);
	          pst2.setInt(1, val3);
	          pst2.execute();
           	 
           	 val3=0;
           	 
           	con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		 
	         
			
		});
		
		TableView.setRowFactory(tv -> {
		    TableRow<Reservation> row = new TableRow<>();
		        row.setOnMouseClicked(event -> {
		            if (!row.isEmpty()) {
		            	
		            	int BookIdR = row.getItem().getBook_id();
		            	String StudentId = row.getItem().getStudent_id();
		            	
		            	
		            	val1 = BookIdR;
		            	val2=StudentId;
		                   
		                }
		           
		            
		            
		            });
		        return row;
		});
		
		TableViewI.setRowFactory(tv -> {
		    TableRow<IssueBook> row = new TableRow<>();
	        row.setOnMouseClicked(event -> {
	            if (!row.isEmpty()) {
	            	
	            	//int BookIdR = row.getItem().getBook_id();
	            	int BookIdI=row.getItem().getBook_id();
	            	
	            	val3=BookIdI;
	            	
	            	
	                   
	                }
	           
	            
	            
	            });
	        return row;
	});
		
		
		refrech.setOnAction(a->{
			
			TableView.getItems().clear();
			
			
			
			try {
				Connection con;
				con = DBConnection.getconnection();
				PreparedStatement pst;
		         ResultSet res ;
		         String query=("select * from  reservation  ");
		         
		          pst=(PreparedStatement) con.prepareStatement(query);
		          
		          res =pst.executeQuery();
		          
		          while(res.next())
		          {
		        	  oblist.add(new Reservation(res.getString(2), res.getInt(3)));
		          }
		          
		   	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			StudentIdR.setCellValueFactory(new PropertyValueFactory<>("student_id"));
			BookIdR.setCellValueFactory(new PropertyValueFactory<>("book_id"));
			
			TableView.setItems(oblist);
		  		
		});
		
		rRefrechIssue.setOnAction(a->{
			
			TableViewI.getItems().clear();
			
			
			try {
				Connection con;
				con = DBConnection.getconnection();
				PreparedStatement pst;
		         ResultSet res ;
		         String query=("select * from  borrowed_book  ");
		         
		          pst=(PreparedStatement) con.prepareStatement(query);
		          
		          res =pst.executeQuery();
		          
		          while(res.next())
		          {
		        	  list.add(new IssueBook(res.getString(2), res.getInt(3), res.getDate(4), res.getDate(5)));
		          }
		          
		   	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
			BookIdI.setCellValueFactory(new PropertyValueFactory<>("student_id"));
			StudentIdI.setCellValueFactory(new PropertyValueFactory<>("book_id"));
			DateP.setCellValueFactory(new PropertyValueFactory<>("first"));
			DateB.setCellValueFactory(new PropertyValueFactory<>("last"));
			
			TableViewI.setItems(list);
			
		});
		
		Back.setOnAction(a->{
			try {
				Parent Home_root = FXMLLoader.load(this.getClass().getResource("Admin.fxml"));
				Scene home =new Scene(Home_root);
				home.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
				Start_Application.stage.setScene(home);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		
		
		
		
	}

}

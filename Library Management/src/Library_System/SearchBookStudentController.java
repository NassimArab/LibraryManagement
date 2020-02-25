package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import Library_System.Start_Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchBookStudentController implements Initializable {
	
	 @FXML
	    private JFXTextField ById;

	    @FXML
	    private TableView<Book> TableView;

	    @FXML
	    private TableColumn<Book, String> BookId;

	    @FXML
	    private TableColumn<Book, String> BookTitle;

	    @FXML
	    private TableColumn<Book, String> BookAuthor;

	    @FXML
	    private TableColumn<Book, String> BookTheme;

	    @FXML
	    private TableColumn<Book, String> BookPage;
	    
	    ObservableList<Book> oblist = FXCollections.observableArrayList();

	    @FXML
	    private JFXTextField ByTitle;

	    @FXML
	    private JFXTextField ByTheme;

	    @FXML
	    private JFXButton GetById;

	    @FXML
	    private JFXButton GetByTitle;

	    @FXML
	    private JFXButton GetByTheme;

	    @FXML
	    private Tab ByName;

	    @FXML
	    private Label sname;

	    @FXML
	    private Tab ByType;

	    @FXML
	    private Label stype;

	    @FXML
	    private JFXButton ReturnButt;

	    
	    

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
			ById.setOnKeyReleased(a->{
				TableView.getItems().clear();
				
				if(ById.getText().equals("") )
				{
					
					return;
				}
				
					
				int idd=Integer.parseInt(ById.getText());
				try {
					Connection con;
					con = DBConnection.getconnection();
					PreparedStatement pst;
			         ResultSet res ;
			         String query=("select * from  book where  book_id=?  ");
			         
			          pst=(PreparedStatement) con.prepareStatement(query);
			          pst.setInt(1, Integer.parseInt(ById.getText()));
			          
			          res =pst.executeQuery();
			          
			          while(res.next())
			          {
			        	  oblist.add(new Book(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
			          }
			          
			       
			          
			          
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				BookId.setCellValueFactory(new PropertyValueFactory<>("bookid"));
				BookTitle.setCellValueFactory(new PropertyValueFactory<>("booktitle"));
				BookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
				BookTheme.setCellValueFactory(new PropertyValueFactory<>("booktheme"));
				BookPage.setCellValueFactory(new PropertyValueFactory<>("bookpage"));
			  		
				TableView.setItems(oblist);
				return;
		         
		         
				
			});
			
			ByTitle.setOnKeyReleased(a->{
				
				TableView.getItems().clear();
				
				String tit=ByTitle.getText();
				
				try {
					Connection con;
					con = DBConnection.getconnection();
					PreparedStatement pst;
			         ResultSet res ;
			         String query=("select * from  book where   	title LIKE '%"+ByTitle.getText()+"%'              " );
			         		
			         		
			         
			          pst=(PreparedStatement) con.prepareStatement(query);
			          //pst.setString(1,tit );
			          
			          res =pst.executeQuery();
			          
			          while(res.next())
			          {
			        	  oblist.add(new Book(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
			          }
			          
			       
			          
			          
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				BookId.setCellValueFactory(new PropertyValueFactory<>("bookid"));
				BookTitle.setCellValueFactory(new PropertyValueFactory<>("booktitle"));
				BookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
				BookTheme.setCellValueFactory(new PropertyValueFactory<>("booktheme"));
				BookPage.setCellValueFactory(new PropertyValueFactory<>("bookpage"));
			  		
				TableView.setItems(oblist);
		         
				
			});
			
			ByTheme.setOnKeyReleased(a->{
				
TableView.getItems().clear();
				
				String tit=ByTitle.getText();
				
				try {
					Connection con;
					con = DBConnection.getconnection();
					PreparedStatement pst;
			         ResultSet res ;
			         String query=("select * from  book where   	 	theme LIKE '%"+ByTheme.getText()+"%'              " );
			         		
			         		
			         
			          pst=(PreparedStatement) con.prepareStatement(query);
			          //pst.setString(1,tit );
			          
			          res =pst.executeQuery();
			          
			          while(res.next())
			          {
			        	  oblist.add(new Book(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
			          }
			          
			       
			          
			          
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				BookId.setCellValueFactory(new PropertyValueFactory<>("bookid"));
				BookTitle.setCellValueFactory(new PropertyValueFactory<>("booktitle"));
				BookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
				BookTheme.setCellValueFactory(new PropertyValueFactory<>("booktheme"));
				BookPage.setCellValueFactory(new PropertyValueFactory<>("bookpage"));
			  		
				TableView.setItems(oblist);
				
			});
			
			ReturnButt.setOnAction(a->{
				
				
				try {
					Parent Student_root;
					Student_root = FXMLLoader.load(this.getClass().getResource("Student.fxml"));
					Scene Student =new Scene(Student_root);
					Student.getStylesheets().add(getClass().getResource("student.css").toExternalForm());
					
					Start_Application.stage.setScene(Student);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			});
			
			
		}

}

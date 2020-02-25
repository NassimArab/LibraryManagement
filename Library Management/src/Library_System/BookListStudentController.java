package Library_System;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.PreparedStatement;

import Library_System.Start_Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableView;

public class BookListStudentController implements Initializable {
	
	
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

	    @FXML
	    private JFXButton BackButton;

	    @FXML
	    private JFXButton RefrechButton;
	    
	    ObservableList<Book> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		BackButton.setOnAction(a->{
			
			 Parent Student_root;
				try {
					Student_root = FXMLLoader.load(this.getClass().getResource("Student.fxml"));
					Scene Student =new Scene(Student_root);
					Student.getStylesheets().add(getClass().getResource("student.css").toExternalForm());
					Start_Application.stage.setScene(Student);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});
		
		RefrechButton.setOnAction(a->{
			
			TableView.getItems().clear();
			
			
			try {
				Connection con;
				con = DBConnection.getconnection();
				PreparedStatement pst;
		         ResultSet res ;
		         String query=("select * from  book  ");
		         
		          pst=(PreparedStatement) con.prepareStatement(query);
		          
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
		
	}

}

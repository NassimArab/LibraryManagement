package Library_System;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import Library_System.Start_Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;

public class StudentController implements Initializable {
	
	 @FXML
	    private TitledPane tp;

	    @FXML
	    private JFXButton BookList;

	    @FXML
	    private JFXButton SearchBook;

	    @FXML
	    private JFXButton BorrowBook;

	    @FXML
	    private JFXButton LogOut;
	    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
     SearchBook.setOnAction(a->{
			
			try {
				Parent Search_root = FXMLLoader.load(this.getClass().getResource("SearchBookStudent.fxml"));
				Scene Search =new Scene(Search_root);
				Search.getStylesheets().add(getClass().getResource("search.css").toExternalForm());
				
				Start_Application.stage.setScene(Search);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});
     
     LogOut.setOnAction(a->{
    	 
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
     
     BookList.setOnAction(a->{
    	 
    	 Parent List_root;
			try {
				List_root = FXMLLoader.load(this.getClass().getResource("BookListStudent.fxml"));
				Scene list =new Scene(List_root);
				list.getStylesheets().add(getClass().getResource("bookliststudent.css").toExternalForm());
				Start_Application.stage.setScene(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	 
    	 
     });
     
     BorrowBook.setOnAction(a->{
    	 
    	 Parent List_root;
			try {
				List_root = FXMLLoader.load(this.getClass().getResource("BorrowBook.fxml"));
				Scene list =new Scene(List_root);
				list.getStylesheets().add(getClass().getResource("borrowbook.css").toExternalForm());
				Start_Application.stage.setScene(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 
     });
		
	}

}

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



public class ManageBookController implements Initializable {
	
	@FXML
    private JFXTextField BookId;

    @FXML
    private JFXTextField BookTitle;

    @FXML
    private JFXTextField BookAuthor;

    @FXML
    private JFXTextField BookTheme;
    
    @FXML
    private JFXTextField BookPage;
    
    @FXML
    private JFXTextField BookQte;

    @FXML
    private JFXTextField BookRow;

    @FXML
    private JFXTextField BookColone;

    @FXML
    private JFXButton AddBookConfirm;

    @FXML
    private JFXTextField BookIdDelete;

    @FXML
    private JFXButton ConfirmDeleteBook;

    @FXML
    private JFXButton BookManageBack;
    
    @FXML
    private JFXTextField GetBookId;

    @FXML
    private JFXButton GetBookInfo;

    @FXML
    private JFXTextField TitleBookInfo;

    @FXML
    private JFXTextField AuthorBookInfo;

    @FXML
    private JFXTextField ThemeBookInfo;
    
    @FXML
    private TableView<Book> TableViewBook;

    @FXML
    private TableColumn<Book, String> BookIdColomn;

    @FXML
    private TableColumn<Book, String> BookIdTitle;

    @FXML
    private TableColumn<Book, String> BookIdAuthor;

    @FXML
    private TableColumn<Book, String> BookIdTheme;

    @FXML
    private TableColumn<Book,String> BookIdPage;
    
    ObservableList<Book> oblist = FXCollections.observableArrayList();
    
    @FXML
    private JFXButton Refrech;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TitleBookInfo.setVisible(false);
		AuthorBookInfo.setVisible(false);
		ThemeBookInfo.setVisible(false);
		
		////////////////////
		
		
		
		
		Refrech.setOnAction(a->{
			
			TableViewBook.getItems().clear();
			
			
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
			
			    BookIdColomn.setCellValueFactory(new PropertyValueFactory<>("bookid"));
		  		BookIdTitle.setCellValueFactory(new PropertyValueFactory<>("booktitle"));
		  		BookIdAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
		  		BookIdTheme.setCellValueFactory(new PropertyValueFactory<>("booktheme"));
		  		BookIdPage.setCellValueFactory(new PropertyValueFactory<>("bookpage"));
		  		
		  		TableViewBook.setItems(oblist);
	         
	         
			
			
			
		});

		
		
		//////////////////
		
BookManageBack.setOnAction(a->{
			
			try {
				Parent Admin_root = FXMLLoader.load(this.getClass().getResource("Admin.fxml"));
				Scene Login =new Scene(Admin_root);
				Login.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});

AddBookConfirm.setOnAction(a->{
	
	
	if(BookId.getText().isEmpty() || BookTitle.getText().isEmpty() || BookAuthor.getText().isEmpty() || BookTheme.getText().isEmpty() || BookPage.getText().isEmpty() || BookQte.getText().isEmpty())
	{
		
		Notifications n = Notifications.create();
	         n.title("Error");
	         n.text("field text empty");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showError();
	         
		   /*Alert alert =new Alert(AlertType.ERROR);
    	   alert.setContentText("field text empty");
    	   alert.setHeaderText(null);
    	   alert.showAndWait();*/
    	   return;
	}
	
	try {
		
	Book b1 =new Book();
	
	int bookid=Integer.parseInt(BookId.getText().toString());
	int bookpage=Integer.parseInt(BookPage.getText().toString());
	int bookqte=Integer.parseInt(BookQte.getText().toString());
	
   // b1.AddBook(BookId, BookTitle.getText(), BookAuthor.getText(), BookTheme.getText(), bookpage);
	b1.AddBook(bookid, BookTitle.getText(), BookAuthor.getText(), BookTheme.getText(), bookpage,bookqte);
	 
	BookId.setText("");
	BookTitle.setText("");
	BookAuthor.setText("");
	BookTheme.setText("");
	BookPage.setText("");
	BookQte.setText("");
	
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
});

ConfirmDeleteBook.setOnAction(a->{
	if(BookIdDelete.getText().isEmpty())
	{
		Notifications n = Notifications.create();
		 n.title("Error");
         n.text("field text empty");
         n.graphic(null);
         n.hideAfter(Duration.seconds(5));
         n.position(Pos.BOTTOM_RIGHT);
         n.showError();
         
		/*Alert alert =new Alert(AlertType.ERROR);
 	   alert.setContentText("field text empty");
 	  alert.setHeaderText(null);
 	   alert.showAndWait();*/
 	   return;
		
	}
	
	Book b1 =new Book();
	int bookid =Integer.parseInt(BookIdDelete.getText().toString());
	try {
		
		b1.DeleteBook(bookid);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
});

GetBookInfo.setOnAction(a->{
	
	if(GetBookId.getText().isEmpty())
	{
		Notifications n = Notifications.create();
		 n.title("Error");
        n.text("field text empty");
        n.graphic(null);
        n.hideAfter(Duration.seconds(5));
        n.position(Pos.BOTTOM_RIGHT);
        n.showError();
 	   return;
		
	}
	
	TitleBookInfo.setVisible(true);
	AuthorBookInfo.setVisible(true);
	ThemeBookInfo.setVisible(true);
	
	Book b1 =new Book();
	int bookid =Integer.parseInt(GetBookId.getText().toString());
	try {
		
		b1.BookInfo(bookid, TitleBookInfo, AuthorBookInfo, ThemeBookInfo);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
});




		
		
	}

}

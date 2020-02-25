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

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

import java.sql.*;

public class Book {
	
	//////////////////////////////////////
	 int bookid;
	 String booktitle;
	 String author;
	 String booktheme;
	 int bookpage;
	
	 public Book()
	 {
		 
	 }
	
	
	public Book(int bookid, String booktitle, String author, String booktheme, int bookpage) {
		
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.author = author;
		this.booktheme = booktheme;
		this.bookpage = bookpage;
	}
	
	
	
	

	public int getBookid() {
		return bookid;
	}



	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public String getBooktitle() {
		return booktitle;
	}



	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getBooktheme() {
		return booktheme;
	}



	public void setBooktheme(String booktheme) {
		this.booktheme = booktheme;
	}



	public int getBookpage() {
		return bookpage;
	}



	public void setBookpage(int bookpage) {
		this.bookpage = bookpage;
	}
	
/////////////////////////////////



	/*public void AddBook(int BookId , String BookTitle,String BookAuthor,String BookTheme,int BookPage) throws SQLException
	{
         Connection con =DBConnection.getconnection();
		 
         PreparedStatement pst;
         String query_insert=("INSERT INTO book (book_id, title, author, theme , page) VALUES (?,?,?,?,?) ");
         pst=(PreparedStatement) con.prepareStatement(query_insert);
         
        // pst.setString(1, BookId);
         pst.setInt(1, BookId);
    	 pst.setString(2, BookTitle);
    	 pst.setString(3, BookAuthor);
    	 pst.setString(4, BookTheme);
    	 pst.setInt(5, BookPage);
    	 //pst.setString(5, BookPage);
    	 
    	  pst.execute();
    	 
        	 
        		 Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            	 alert.setContentText("Book Aded successfully");
            	 alert.showAndWait();
            	 
            	 pst.close();
            	 con.close();
    		  
    	  
   }*/
	
	public void AddBook(int BookId , String BookTitle,String BookAuthor,String BookTheme,int BookPage,int BookQte) throws SQLException
	{
		Connection con2 =DBConnection.getconnection();
        
        PreparedStatement pst2;
        ResultSet res ;
        String query=("select * from  book where book_id= ? ");
        
         pst2=(PreparedStatement) con2.prepareStatement(query);
         pst2.setInt(1, BookId);
         res =pst2.executeQuery();
         
         if(res.next())
         {
        	 Notifications n = Notifications.create();
	         n.title("Error");
	         n.text("book id existed");
	         n.graphic(null);
	         n.hideAfter(Duration.seconds(5));
	         n.position(Pos.BOTTOM_RIGHT);
	         n.showError();
        	/* Alert alert =new Alert(AlertType.ERROR);
      	   alert.setContentText("book id existed ");
      	 alert.setHeaderText(null);
      	   alert.showAndWait();*/
      	   return;
         }
				
		/////////////////////////////////////////////////
         Connection con =DBConnection.getconnection();
		 
         PreparedStatement pst;
         String query_insert=("INSERT INTO book (book_id, title, author, theme , page) VALUES (?,?,?,?,?) ");
         pst=(PreparedStatement) con.prepareStatement(query_insert);
         
        // pst.setString(1, BookId);
         pst.setInt(1, BookId);
    	 pst.setString(2, BookTitle);
    	 pst.setString(3, BookAuthor);
    	 pst.setString(4, BookTheme);
    	 pst.setInt(5, BookPage);
    	 //pst.setString(5, BookPage);
    	 
    	  pst.execute();
    	  
    	  pst.close();
     	// con.close();
    	  
    	  
    	  Connection con1 =DBConnection.getconnection();
 		 
          PreparedStatement pst1;
          String query_insert1=("INSERT INTO examplaire (id,  	title, author, theme , page,qte) VALUES (?,?,?,?,?,?) ");
          pst1=(PreparedStatement) con.prepareStatement(query_insert1);
          
         // pst.setString(1, BookId);
          pst1.setInt(1, BookId);
     	 pst1.setString(2, BookTitle);
     	 pst1.setString(3, BookAuthor);
     	 pst1.setString(4, BookTheme);
     	 pst1.setInt(5, BookPage);
     	 pst1.setInt(6, BookQte);
     	 
     	  pst1.execute();
     	  
     	 pst1.close();
    	 con1.close();
    	 
        	 
    	 Notifications n = Notifications.create();
         n.title("confirmation");
         n.text("Book Aded successfully");
         n.graphic(null);
         n.hideAfter(Duration.seconds(5));
         n.position(Pos.BOTTOM_RIGHT);
         n.showConfirm();
        		/* Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            	 alert.setContentText("Book Aded successfully");
            	 alert.setHeaderText(null);
            	 alert.showAndWait();*/
            	 
            	
	}
	
	public void DeleteBook(int BookId) throws SQLException
	{
		
         Connection con2 =DBConnection.getconnection();
        
        PreparedStatement pst2;
        ResultSet res ;
        String query=("select * from  book where  	book_id= ? ");
        
         pst2=(PreparedStatement) con2.prepareStatement(query);
         pst2.setInt(1, BookId);
         res =pst2.executeQuery();
         
         if(!res.next())
         {
        	 Notifications n = Notifications.create();
             n.title("Error");
             n.text("book id not existed");
             n.graphic(null);
             n.hideAfter(Duration.seconds(5));
             n.position(Pos.BOTTOM_RIGHT);
             n.showError();
        	/* Alert alert =new Alert(AlertType.ERROR);
      	   alert.setContentText("book id not existed ");
      	 alert.setHeaderText(null);
      	   alert.showAndWait();*/
      	   return;
         }
		
		/////////////////////////////////////
          Connection con =DBConnection.getconnection();
		 
         PreparedStatement pst;
         String query_insert=("DELETE FROM book WHERE book_id = ? ");
         pst=(PreparedStatement) con.prepareStatement(query_insert);
         pst.setInt(1, BookId);
         pst.execute();
         
         Notifications n = Notifications.create();
         n.title("confirmation");
         n.text("Book deleted successfully");
         n.graphic(null);
         n.hideAfter(Duration.seconds(5));
         n.position(Pos.BOTTOM_RIGHT);
         n.showConfirm();
         
        /* Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    	 alert.setContentText("Book deleted successfully");
    	 alert.setHeaderText(null);
    	 alert.showAndWait();*/
    	 
    	 pst.close();
    	 con.close();
		
	}
	
	public void BookInfo(int BookId,JFXTextField TitleBookInfo,JFXTextField AuthorBookInfo,JFXTextField ThemeBookInfo) throws SQLException
	{
		 Connection con =DBConnection.getconnection();
         
         PreparedStatement pst;
         ResultSet res ;
         String query=("select * from  book where book_id= ? ");
         
          pst=(PreparedStatement) con.prepareStatement(query);
          pst.setInt(1, BookId);
          res =pst.executeQuery();
          
          if(res.next())
          {
        	  TitleBookInfo.setText("Book title : "+res.getString(2));
        	  AuthorBookInfo.setText("Book author : "+res.getString(3));
        	  ThemeBookInfo.setText("Book theme : "+res.getString(4));
          }
          else
          {
        	  
        	  Notifications n = Notifications.create();
              n.title("Error");
              n.text("book does not existe");
              n.graphic(null);
              n.hideAfter(Duration.seconds(5));
              n.position(Pos.BOTTOM_RIGHT);
              n.showError();
        	 /* Alert alert=new Alert(Alert.AlertType.ERROR);
         	 alert.setContentText("book does not existe");
         	alert.setHeaderText(null);
         	 alert.showAndWait();*/
          }
          
          
	}
	
	

}

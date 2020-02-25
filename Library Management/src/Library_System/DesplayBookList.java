package Library_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class DesplayBookList {
	
	 int bookid;
	 String booktitle;
	 String author;
	 String booktheme;
	 int bookpage;
	 ObservableList<DesplayBookList> data;
	
	
	
	public void SetCell(TableColumn<?, ?> BookIdColomn,TableColumn<?, ?> BookIdTitle,TableColumn<?, ?> BookIdAuthor,TableColumn<?, ?> BookIdTheme,TableColumn<?, ?> BookIdPage) throws SQLException
	{
		
         
		
	}
	
	

}

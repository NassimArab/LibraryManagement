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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;

public class GeneralRapportController implements Initializable {
	
	@FXML
    private BarChart<?, ?> barchar;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private JFXButton back;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		int count1=0;
		int count2=0;
		int count3=0;
       Connection con2;
	try {
		con2 = DBConnection.getconnection();
		  PreparedStatement pst2;
	        ResultSet res ;
	        String query=("select * from  examplaire ");
	        
	         pst2=(PreparedStatement) con2.prepareStatement(query);
	        
	         res =pst2.executeQuery();
	         
	         while(res.next())
	         {
	        	 count1++;
	         }
	         
	         ///////////////////////////
	         PreparedStatement pst1;
		        ResultSet res1 ;
		        String query1=("select * from  student ");
		        
		         pst1=(PreparedStatement) con2.prepareStatement(query1);
		        
		         res1 =pst1.executeQuery();
		         
		         while(res1.next())
		         {
		        	 count2++;
		         }
	         
	        ///////////////////////////////// 
		         
		         PreparedStatement pst3;
			        ResultSet res3 ;
			        String query3=("select * from  examplaire ");
			        
			         pst3=(PreparedStatement) con2.prepareStatement(query3);
			        
			         res3 =pst3.executeQuery();
			         
			         while(res3.next())
			         {
			        	 count3=count3+res3.getInt(6);
			         }
	         
	         
			XYChart.Series set1 =new XYChart.Series<>();
			XYChart.Series set2 =new XYChart.Series<>();
			XYChart.Series set3 =new XYChart.Series<>();
			set1.getData().add(new XYChart.Data("Number of Book",count1));
			set2.getData().add(new XYChart.Data("Number of Students",count2));
			set3.getData().add(new XYChart.Data("Number of Examplair",count3));
			
			barchar.getData().addAll(set1,set2,set3);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        
      
		
		back.setOnAction(a->{
			try {
				Parent ManageS_root = FXMLLoader.load(this.getClass().getResource("Admin.fxml"));
				Scene Login =new Scene(ManageS_root);
				Login.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		});
		
	}

}

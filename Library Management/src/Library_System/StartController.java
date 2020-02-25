package Library_System;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;

import Library_System.Start_Application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class StartController implements Initializable {

        @FXML
	
	private JFXButton StartButton;
        
        @FXML
        private JFXProgressBar progress;
        
        @FXML
        private Label lab;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		progress.setVisible(false);
		lab.setVisible(false);
		
		StartButton.setOnAction(a-> 
		{
			StartButton.setVisible(false);
			
			progress.setVisible(true);
			lab.setVisible(true);
			PauseTransition pt =new PauseTransition();
			pt.setDuration(Duration.seconds(5));
			
			pt.setOnFinished(ab->{
				
			
			try {
				Parent Login_root = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
				Scene Login =new Scene(Login_root);
				Login.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
				
				Start_Application.stage.setScene(Login);
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		});  pt.play();  }); 
		
	}

	
}

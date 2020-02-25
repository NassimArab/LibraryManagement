package Library_System;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Library_System.Start_Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class SignUpController implements Initializable {
	
	@FXML
    private JFXComboBox<String> ComboBoxQuestion;
  
    @FXML
    private JFXButton CreatButton;

    @FXML
    private JFXButton BackSignup;
    
    @FXML
    private JFXTextField UserSignup;

    @FXML
    private JFXPasswordField PasswordSignup;

    
    @FXML
    private JFXTextField AnswerSignup;

    @FXML
    private JFXButton CancelSignup;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ComboBoxQuestion.getItems().add("your nick name ?");
		ComboBoxQuestion.getItems().add("your prefered car");
		ComboBoxQuestion.getItems().add("your best freind");
		
		
		
		
		 BackSignup.setOnAction(e->{
			 
			 try {
				Parent Back_root =FXMLLoader.load(this.getClass().getResource("Login.fxml"));
				Scene Back =new Scene(Back_root);
				Back.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
				Start_Application.stage.setScene(Back);
				
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
		 });
		 
		 CreatButton.setOnAction(a->{
			 
			 try {
					
					
					if(UserSignup.getText().isEmpty() || PasswordSignup.getText().isEmpty()  || ComboBoxQuestion.getValue().isEmpty() || AnswerSignup.getText().isEmpty())
					{
						Notifications n = Notifications.create();
						 n.title("Error");
				         n.text("Text Field Empty");
				         n.graphic(null);
				         n.hideAfter(Duration.seconds(5));
				         n.position(Pos.BOTTOM_RIGHT);
				         n.showError();
			        	   return;
					}
					
					Student s1 =new Student();
					s1.sign_up(UserSignup.getText(), PasswordSignup.getText(),ComboBoxQuestion.getValue(),AnswerSignup.getText());
					UserSignup.setText("");
					PasswordSignup.setText("");
					ComboBoxQuestion.setValue("");
					AnswerSignup.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 
		 });
		 
		 CancelSignup.setOnAction(a->{
			 
			 PasswordSignup.setText("");
			 
			 AnswerSignup.setText("");
			 UserSignup.setText("");
			 ComboBoxQuestion.setValue("");
			 
		 });
		
		
	}

}

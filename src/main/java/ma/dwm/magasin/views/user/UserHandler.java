package ma.dwm.magasin.views.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.stage.Stage;
import ma.dwm.magasin.MainApplication;
import ma.dwm.magasin.entities.Client;
import ma.dwm.magasin.entities.User;
import ma.dwm.magasin.repositories.IUserRepository;
import ma.dwm.magasin.views.application.ListeClients;

public class UserHandler {

	MainApplication mainApplication=null; 
	@Autowired
	IUserRepository udao;
	ListeClients listClient;

public UserHandler(MainApplication mainApplication) { 
	this.mainApplication = mainApplication; 
}


public void login(Stage window) { 
	User l =new User(); 
	List<Client> list = new ArrayList<Client>(); 
	String username = mainApplication.userInput.getText(); 
	String password = mainApplication.passwordInput.getText(); 
	User user = udao.findByUsernameAndPassword(username, password).get(0);
	
	if(true) { // TODO l.isLogin
		listClient=new ListeClients(); 
		window.close(); 
	} else {
		mainApplication.lblError.setText("Information incorrect !"); 
	}


}

}

package ma.dwm.magasin.views.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.stage.Stage;
import ma.dwm.magasin.Main;
import ma.dwm.magasin.entities.Client;
import ma.dwm.magasin.entities.User;
import ma.dwm.magasin.repositories.IUserRepository;
import ma.dwm.magasin.views.application.ListeClients;

public class UserHandler {

	Main main=null; 
	@Autowired
	IUserRepository udao;
	ListeClients listClient;

public UserHandler(Main main) { 
	this.main = main; 
}


public void login(Stage window) { 
	User l =new User(); 
	List<Client> list = new ArrayList<Client>(); 
	String username = main.userInput.getText(); 
	String password = main.passwordInput.getText(); 
	User user = udao.findByUsernameAndPassword(username, password).get(0);
	
	if(l.isLogin) { 
		listClient=new ListeClients(); 
		window.close(); 
	} else {
		main.lblError.setText("Information incorrect !"); 
	}


}

}

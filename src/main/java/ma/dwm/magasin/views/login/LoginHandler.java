/*
 * package ma.dwm.magasin.views.login;
 * 
 * import java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.util.ArrayList; import java.util.List;
 * 
 * import javafx.stage.Stage; import
 * ma.dwm.magasin.views.application.ListeClients; import
 * ma.dwm.magasin.views.application.Main; import
 * ma.dwm.magasin.views.client.Client;
 * 
 * public class LoginHandler {
 * 
 * Main main=null; LoginDaoImpl pdao=new LoginDaoImpl(); ListeClients
 * listClient;
 * 
 * public LoginHandler(Main main) { this.main=main; }
 * 
 * 
 * public void login(Stage window) { User l =new User(); List<Client> list =new
 * ArrayList<Client>(); String user=main.userInput.getText(); String
 * password=main.passwordInput.getText(); pdao.getOne(user, password);
 * if(l.isLogin) { listClient=new ListeClients(); window.close(); } else {
 * main.lblError.setText("Information incorrect !"); }
 * 
 * 
 * }
 * 
 * }
 */
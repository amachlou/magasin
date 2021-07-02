package ma.dwm.magasin.views.application;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import ma.dwm.magasin.MagasinApplication;
import ma.dwm.magasin.entities.User;
import ma.dwm.magasin.repositories.IUserRepository;
import ma.dwm.magasin.views.user.UserHandler;

public class MainApplication extends Application{
	
	@Autowired
	IUserRepository udao;
	
	ListeProduits listProduit;
	ListeClients listClient;
	UserHandler handler = new UserHandler(this);// TODO ToCompleyte
	
	/*
	 * @Autowired public MainApplication() { // TODO Auto-generated constructor stub
	 * }
	 */
	
	MenuBar menuBar;
	
	Menu produitsMenu;
	Menu clientsMenu;
	Menu ventesMenu;
	Menu paimentsMenu;
	Menu helpMenu;
	
	Label Produits;
	Label Clients;
	Label Ventes;
	Label Paiments;
	Label Help;
	
	public Label lblError;
	
//	MenuItem newProduit;
//	MenuItem listProduits;	
//	MenuItem newClient;
//	MenuItem listClients;
	MenuItem newVente;
	MenuItem listVentes;
	MenuItem newPaiement;
	MenuItem listPaiements;
	MenuItem helpItem;
	
	VBox root = new VBox();
	private StackPane stack=new StackPane();
	private Scene scene =new Scene(root);
	Label usernameLabel=new Label("Username");
	public TextField userInput=new TextField("jihane");
	Label passwordLabel=new Label("Password");
	public PasswordField passwordInput=new PasswordField();
	Button loginBtn = new Button("Login");
//	Image img = new Image("/css/magasin_logo.jpg");
//	//Image img = new Image("css/magasin_logo.jpg");
//	ImageView view = new ImageView(img);
	Font font;
	
	Label lblTitle;
	
	private void addNodesToWindow() {
		// view properties
//	    view.setFitWidth(1100);
//	    view.setFitHeight(700);
//	    view.fitWidthProperty().bind(root.widthProperty());
//	    view.fitHeightProperty().bind(root.heightProperty());
	    
	    lblError=new Label("");
	    
	    // labeluser properties
		usernameLabel.setMaxWidth(350);
		usernameLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 20);
	    usernameLabel.setFont(font);
		usernameLabel.setTextFill(Color.DEEPSKYBLUE);
		usernameLabel.setTranslateX(30);
		usernameLabel.setTranslateY(120);
		
		// inputuser properties
		userInput.setMaxWidth(350);
		font = Font.font("Brush Script MT", FontPosture.REGULAR, 20);
		userInput.setFont(font);
		userInput.setPromptText("Username");
		userInput.setTranslateX(30);
		userInput.setTranslateY(160);
		
		// labeluser properties
		passwordLabel.setMaxWidth(350);
		passwordLabel.setMaxHeight(50);
		font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 20);
		passwordLabel.setFont(font);
		passwordLabel.setTextFill(Color.DEEPSKYBLUE);
		passwordLabel.setTranslateX(30);
		passwordLabel.setTranslateY(200);
				
		// inputpass properties
		passwordInput.setMaxWidth(350);
		font = Font.font("Brush Script MT",
		FontPosture.REGULAR, 20);
		passwordInput.setFont(font);
		passwordInput.setPromptText("Password");
		passwordInput.setTranslateX(30);
		passwordInput.setTranslateY(240);
		
		// buttonlogin properties
		loginBtn.setMaxWidth(350);
		loginBtn.setMaxHeight(40);
		font = Font.font("Brush Script MT", FontWeight.BOLD,
		FontPosture.REGULAR, 20);
		loginBtn.setFont(font);
		loginBtn.setTextFill(Color.WHITE);
		loginBtn.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, null, null)));
		loginBtn.setTranslateX(30);
		loginBtn.setTranslateY(300);
		
		lblError.setMaxWidth(350);
		lblError.setTranslateX(30);
		lblError.setTranslateY(340);
		
		lblTitle=new Label("User Login");
		font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 40);
		lblTitle.setFont(font);
		lblTitle.setTextFill(Color.DEEPSKYBLUE);
		lblTitle.setTranslateX(30);
		lblTitle.setTranslateY(70);
		
		menuBar=new MenuBar();
		
		Produits= new Label("Produits");
		Clients= new Label("Clients");
		Ventes= new Label("Ventes");
		Paiments= new Label("Paiments");
		Help= new Label("Help");
		
		produitsMenu=new Menu("");
		clientsMenu=new Menu("");
		ventesMenu=new Menu("");
		paimentsMenu=new Menu("");
		helpMenu=new Menu("");
		
		produitsMenu.setGraphic(Produits);
		clientsMenu.setGraphic(Clients);
		ventesMenu.setGraphic(Ventes);
		paimentsMenu.setGraphic(Paiments);
		helpMenu.setGraphic(Help);
		

		menuBar.getMenus().addAll(clientsMenu,produitsMenu,ventesMenu
				,paimentsMenu,helpMenu);
		
//		newProduit=new MenuItem("Nouveau");
//		listProduits=new MenuItem("Liste");
//		
//		newClient=new MenuItem("Nouveau");
//		listClients=new MenuItem("Liste");

		newPaiement=new MenuItem("Nouveau");
		listPaiements=new MenuItem("Liste");


		newVente=new MenuItem("Nouveau");
		listVentes=new MenuItem("Liste");

		helpItem=new MenuItem("?");
		
		
//		produitsMenu.getItems().addAll(newProduit,listProduits);
//		clientsMenu.getItems().addAll(newClient,listClients);

		ventesMenu.getItems().addAll(newVente,listVentes);
			
		paimentsMenu.getItems().addAll(newPaiement,listPaiements);

		helpMenu.getItems().addAll(helpItem);
		
		
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().addAll(
//	            view,
				lblTitle,usernameLabel,userInput,passwordInput,passwordLabel,loginBtn,lblError);
		root.getChildren().addAll(menuBar,stack);
	
	}
	
	private void addStyleToNodes(){
//		scene.getStylesheets().add("css/application.css");TODO ToComplete
		root.getStyleClass().add("Main");
		usernameLabel.getStyleClass().add("labelTitle");
		loginBtn.getStyleClass().add("cursor");
		
		menuBar.getStyleClass().add("menuStyle");
		
		Produits.getStyleClass().addAll("textWhite","cursor");
		Clients.getStyleClass().addAll("textWhite","cursor");
		Ventes.getStyleClass().addAll("textWhite","cursor");
		Paiments.getStyleClass().addAll("textWhite","cursor");
		Help.getStyleClass().addAll("textWhite","cursor");
		
//		newProduit.getStyleClass().addAll("cursor");
//		listProduits.getStyleClass().addAll("cursor");
//		
//		newClient.getStyleClass().addAll("cursor");
//		listClients.getStyleClass().addAll("cursor");
		
		newVente.getStyleClass().addAll("cursor");
		listVentes.getStyleClass().addAll("cursor");
		
		newPaiement.getStyleClass().addAll("cursor");
		listPaiements.getStyleClass().addAll("cursor");			

		helpItem.getStyleClass().addAll("cursor");
		
		lblError.getStyleClass().addAll("fontListe","error");
	}
	
	
	
	private void addEvent(Stage window) {
		loginBtn.setOnAction(event ->
		{
			
			handler.login(window);	//TODO ToCompleyte
			
		});
	
		Clients.setOnMouseClicked((mouseEvent) -> {
			User u = new User();
			if(User.isLogin) {
//				listClient=new ListeClients(); TODO ToCompleyte
				window.close();
			}
			else {
				lblError.setText("Information incorrect !");
			}
	    });

		
		Clients.setOnMouseClicked((mouseEvent) -> {
			if(User.isLogin) {
//				listProduit= new ListeProduits(); TODO ToCompleyte
				window.close();
			}
			else {
				lblError.setText("Information incorrect !");
			}
			
		});
//		newVente.setOnAction(event ->{
//			   nouveauVente=new NouveauVente();
//			   window.close();
//			});
//			
//			listVentes.setOnAction(event ->{
//				
//
//			});
//			newPaiement.setOnAction(event ->{
//				nouveauPaiement=new NouveauPaiement();
//				window.close();
//
//			});
//			listPaiements.setOnAction(event ->{
//				
//
//			});
			
		
	}
	
	@Override
	public void start(Stage window) {
			addNodesToWindow();
			addStyleToNodes();
			addEvent(window);
			window.setScene(scene);
			window.setWidth(1100);
			window.setHeight(700);
			window.setResizable(false);
			window.setTitle("Gestion de Magasin");
//			window.getIcons().add(/*new Image("css/logo_icon.png")*/);
			window.show();
		
	}
	
	private ConfigurableApplicationContext applicationContext;
	
    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(MagasinApplication.class).run();
    }
//    @Override
//    public void start(Stage stage) {
//        applicationContext.publishEvent(new StageReadyEvent(stage));
//    }
    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }
    
//    static class StageReadyEvent extends ApplicationEvent {
//        public StageReadyEvent(Stage stage) {
//            super(stage);
//        }
//    }
}

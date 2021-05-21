package ma.dwm.magasin.views;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MagasinView extends Application {
	
	private BorderPane borderPane = new BorderPane();
	private Scene scene = new Scene(borderPane);
	private MenuBar menuBar = new MenuBar();
//	private MenuBar menuBar = new MenuBar();
	
	MenuItem itemNouveauProduit = new MenuItem("Nouveau");
	MenuItem itemListeProduit = new MenuItem("Liste");
	MenuItem itemNouveauClient = new MenuItem("Nouveau");
	MenuItem itemListeClient = new MenuItem("Liste");
	MenuItem itemHelp = new MenuItem("?");
	
	public static void launch(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(scene);
		addEvents();
//		addStyle();
		createMenu();
//		root.setTop(root);
		
		stage.setWidth(1000);
		stage.setHeight(700);
		stage.setTitle("Gestion de magasin");
//		window.getIcons().add("file:icon.png");
		stage.show();
	}
	
	private void addStyle() {
		scene.getStylesheets().add("css/style.css");
		borderPane.getStyleClass().add(STYLESHEET_CASPIAN /* normally "MagasinView" */); 
	}
	
	private void createMenu() {
		Menu menuProduit = new Menu("Produit");
		Menu menuClient = new Menu("Client");
		Menu menuVente = new Menu("Vente");
		Menu menuReglement = new Menu("Reglement");
		Menu menuInventaire = new Menu("Inventaire");
		Menu menuHelp = new Menu("Help");
		
		menuHelp.getItems().add(itemHelp);
		
		menuProduit.getItems().addAll(itemNouveauProduit, itemListeProduit);
		menuClient.getItems().addAll(itemNouveauClient, itemListeClient);
		menuBar.getMenus().addAll(menuProduit, menuClient, menuVente, menuReglement, menuInventaire, menuHelp);
		borderPane.setTop(menuBar);
	}
	
	private void addEvents() {
		itemNouveauProduit.setOnAction(event->{
			new FormProduitView();
		});
		
		itemListeProduit.setOnAction(event->{
			new ProduitListView();
			
		});
	}
	
}

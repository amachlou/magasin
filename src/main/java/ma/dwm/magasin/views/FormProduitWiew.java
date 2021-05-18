package ma.dwm.magasin.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormProduitWiew {
	VBox vBoxRoot = new VBox();
	Scene scene = new Scene(vBoxRoot);
	Stage stage = new Stage();
	Label titleLabel = new Label("Nouveau produit");
	
	private void initStage() {
		stage.setScene(scene);
		stage.setWidth(1000);
		stage.setHeight(600);
		stage.setTitle("Nouveau produit");
		stage.getIcons().add(new Image("file:icon.png"));
		stage.show();
	}
	
	private void addNodesToStage Stage() {
//		addVide
	}

	private void addStyle() {
		scene.getStylesheets().add("css/style.css");
//		borderPane.getStyleClass().add(STYLESHEET_CASPIAN /* normally "MagasinView" */); 
	}
	
	
	private void addEvents() {
//		itemNouveauProduit.setOnAction(event->{
//			new FormProduitWiew();
//		});
	}
	
	public FormProduitWiew() {
		addStyle();
		addEvents();
		initStage();
	}
}

package ma.dwm.magasin.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormProduitView {
	private VBox vBoxRoot = new VBox();
	private HBox hBoxButtons = new HBox();
	private Scene scene = new Scene(vBoxRoot);
	private Stage stage = new Stage();
	
	private Label labelTitle = new Label("Nouveau produit");
	private Label labelDesignation = new Label("Designation:");
	private Label labelPrix = new Label("Prix:");
	private Label labelQuantite = new Label("Quantite:");
	private Label labelDateSaisie = new Label("Date saisie:");

	private TextField textFieldDesignation = new TextField();
	private TextField textFieldPrix = new TextField();
	private TextField textFieldQuantite = new TextField();
	private DatePicker datePickerDateSaisie = new DatePicker();

	private Button buttonAdd = new Button("Ajouter");
	private Button buttonCancel = new Button("Annuler");
	
	private void initStage() {
		stage.setScene(scene);
		stage.setWidth(1000);
		stage.setHeight(600);
		stage.setTitle("Nouveau produit");
//		stage.getIcons().add(new Image("file:icon.png"));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
	private void addNodesToStage() {
		vBoxRoot.getChildren().addAll(labelTitle);
		vBoxRoot.getChildren().addAll(labelDesignation,textFieldDesignation);
		vBoxRoot.getChildren().addAll(labelPrix,textFieldPrix);
		vBoxRoot.getChildren().addAll(labelQuantite,textFieldQuantite);
		vBoxRoot.getChildren().addAll(labelDateSaisie,datePickerDateSaisie);
		
		hBoxButtons.getChildren().addAll(buttonAdd,buttonCancel);
		vBoxRoot.getChildren().add(hBoxButtons);
	}

	private void addStyle() {
		scene.getStylesheets().add("css/style.css");
//		borderPane.getStyleClass().add(STYLESHEET_CASPIAN /* normally "MagasinView" */); 
//		titleLabel.getStyleClass().add("css/style.css");
		labelTitle.setMinWidth(stage.getWidth());
		labelTitle.setMinHeight(stage.getHeight());
		
		vBoxRoot.setSpacing(15);
		hBoxButtons.setSpacing(50);
	}
	
	
	private void addEvents() {
//		itemNouveauProduit.setOnAction(event->{
//			new FormProduitWiew();
//		});
		
		buttonAdd.setOnAction(event->{
			System.out.println("Process adding new produit!");
		});
		
		stage.setOnCloseRequest(event->{
			event.consume();
		});
	}
	
	public FormProduitView() {
		addStyle();
		addEvents();
		initStage();
		addNodesToStage();
	}
}

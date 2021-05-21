package ma.dwm.magasin.views;

import java.util.Date;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.dwm.magasin.entities.Produit;

public class ProduitListView {
	
	Stage stage = new Stage();
	VBox vBoxRoot = new VBox();
	Scene scene = new Scene(vBoxRoot);
	Label labelTitle = new Label("Liste des produits");
	HBox hboxTotal = new HBox();
	Label labelTotal = new Label("Total");
	Label labelTotalValue = new Label();

	TableColumn<Produit, Long> columnId = new TableColumn<>("ID");
	TableColumn<Produit, String> columnDesignation = new TableColumn<>("DESIGNATION");
	TableColumn<Produit, Double> columnPrix = new TableColumn<>("PRIX");
	TableColumn<Produit, Integer> columnQuantite = new TableColumn<>("QUANTITE");
	TableColumn<Produit, Date> columnDate = new TableColumn<>("DATE");
	
	TableView<Produit> tableViewProduit = new TableView<>();
	
	public ProduitListView() {
		initStage();
		updateColumns();
		addColumnToTableView();
		addNodesToPane();
		stage.show();
	}
	
	private void initStage() {
		stage.setWidth(1000);
		stage.setHeight(650);
		stage.setScene(scene);
	}
	
	private void addColumnToTableView() {
		tableViewProduit.getColumns().addAll(columnId,columnDesignation,columnPrix,columnQuantite,columnDate);
	}
	
	private void updateColumns() {
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnId.setPrefWidth(100);
		
		columnDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
		columnDesignation.setPrefWidth(300);
		
		columnPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		columnPrix.setPrefWidth(100);
		
		columnQuantite.setCellValueFactory(new PropertyValueFactory<>("qte"));
		columnQuantite.setPrefWidth(100);
		
		columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		columnDate.setPrefWidth(300);
	}
	
	private void addNodesToPane() {
		hboxTotal.getChildren().addAll(labelTotal,labelTotalValue);
		vBoxRoot.getChildren().addAll(labelTitle,tableViewProduit,hboxTotal);
	}
	
	private void addStylesToNode() {
		labelTitle.getStyleClass().add("labelTitle");
		labelTotal.getStyleClass().add("labelTotal");
		labelTotalValue.getStyleClass().add("labelTotalValue");
		
		hboxTotal.getStyleClass().add("boxTotal");
		hboxTotal.setSpacing(15);
		
		tableViewProduit.getStyleClass().add("table-row-cell");
		tableViewProduit.setMinWidth(stage.getWidth());
	}
	
}

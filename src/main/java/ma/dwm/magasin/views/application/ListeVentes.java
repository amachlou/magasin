package ma.dwm.magasin.views.application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import lombok.launch.PatchFixesHider.Val;
import ma.dwm.magasin.entities.Vente;
//import produit.Produit;
//import vente.LigneCommande;
//import vente.Vente;
//import vente.VenteHandler;
import ma.dwm.magasin.views.vente.VenteHandler;

public class ListeVentes {

	
	ListeProduits listProduit;
	ListeClients listClient;
	NouveauVente nouveauVente;
	VenteHandler handler = new VenteHandler(this);
		
		VBox root =new VBox();
		HBox hboxCenter=new HBox();
		VBox vboxLeft = new VBox();
		VBox vboxRight = new VBox();
		VBox vboxR1 = new VBox();
		VBox vboxR2 = new VBox();
		HBox hboxTop=new HBox();
		HBox hboxBtn = new HBox();
		HBox hboxBottom=new HBox();
		GridPane grid1 = new GridPane();
		Scene scene = new Scene(root);
		Stage window =new Stage();
	
		
		TableColumn<Vente, Long> idVenteColumn=new TableColumn<>("Nun");
		TableColumn<Vente, String> NomClientColumn=new TableColumn<>("Person");
		TableColumn<Vente, LocalDate> DateColumn=new TableColumn<>("Date");
		TableColumn<Vente, Double> TotalColumn=new TableColumn<>("Total");
		TableColumn<Vente, Double> TotalPayeColumn=new TableColumn<>("Paye");
		TableColumn<Vente, Double> ResteColumn=new TableColumn<>("Reste");
		TableColumn<Vente, Long> ClientColumn=new TableColumn<>("Id_client");



		public TableView <Vente> VenteList=new TableView<>();
		
		public ObservableList<Vente> VenteObservableList= FXCollections.observableArrayList();
		

		
		MenuBar menuBar;
		Menu produitsMenu;
		Menu clientsMenu;
		Menu ventesMenu;
		Menu paimentsMenu;
		Menu helpMenu;
		
		MenuItem newVente;
		MenuItem listVentes;
		MenuItem newPaiement;
		MenuItem listPaiements;
		MenuItem helpItem;

		
		Label Produits;
		Label Clients;
		Label Ventes;
		Label Paiments;
		Label Help;
		Screen screen;
		
		Label lblTitle;
		Label lblCopyright;

		Label lblTotal;
		Label lblTotalPaye;
		Label lblReste;
		
		public Label lblTotalVal;
		public Label lblTotalPayeVal;
		public Label lblResteVal;
		
		Label lblDate1;
		Label lblDate2;
		Label lblNom;
		Label lblNumVente;
	
		
		public DatePicker Date1Input;
		public DatePicker Date2Input;
		public TextField NomInput;
		public TextField NumVenteInput;

		Button rechercherBtn;

		
		
		Font font;
		
		private void createCompnents() {
			
			
			hboxCenter.setSpacing(5);

			vboxLeft.setPrefWidth(1400);
			vboxLeft.setPrefHeight(800);
			vboxLeft.setSpacing(20);
			
			vboxRight.setPrefWidth(450);
			vboxRight.setPrefHeight(800);
			vboxRight.setSpacing(20);
				
			vboxR1.setSpacing(15);
			vboxR2.setSpacing(15);
			
			hboxBtn.setPrefHeight(100);
			hboxBtn.setSpacing(200);
			
			hboxTop.setSpacing(650);
			hboxBottom.setPrefHeight(50);
			

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
			
			menuBar.getMenus().addAll(produitsMenu,clientsMenu,ventesMenu,paimentsMenu,helpMenu);
			
			
//			newProduit=new MenuItem("Nouveau");
//			listProduits=new MenuItem("Liste");
//			
//			newClient=new MenuItem("Nouveau");
//			listClients=new MenuItem("Liste");
			;
			newVente=new MenuItem("Nouveau");
			listVentes=new MenuItem("Liste");
			
			newPaiement=new MenuItem("Nouveau");
			listPaiements=new MenuItem("Liste");
			
			helpItem=new MenuItem("?");
			
//			produitsMenu.getItems().addAll(newProduit,listProduits);
//			clientsMenu.getItems().addAll(newClient,listClients);

			ventesMenu.getItems().addAll(newVente,listVentes);
			paimentsMenu.getItems().addAll(newPaiement,listPaiements);
			
			helpMenu.getItems().addAll(helpItem);
			
			
			lblTitle = new Label("Liste des Ventes");
			
			lblCopyright= new Label("Copyright � 2021, Gestion Magasin");
			
			font = Font.font("Brush Script MT",
			FontPosture.REGULAR, 12);
			lblCopyright.setFont(font);
			lblCopyright.setTranslateX(900);
			
			

			lblTotal= new Label("Total: ");
			lblTotalPaye= new Label("Paye: ");
			lblReste= new Label("Reste: ");
			

			lblTotalVal= new Label("");
			lblTotalPayeVal= new Label("0");
			lblResteVal= new Label("0");
			
			
			lblDate1=new Label("Date 1: ");
			lblDate2=new Label("Date 2: ");
			lblNom=new Label("Person: ");
			lblNumVente=new Label("Nun Vente: ");
	
			
			Date1Input= new DatePicker();
			Date2Input= new DatePicker();
			NomInput= new TextField();
			NumVenteInput= new TextField();
	
			
			rechercherBtn = new Button("Rechercher");

	
			idVenteColumn.setPrefWidth(100);
			NomClientColumn.setPrefWidth(400);
			DateColumn.setPrefWidth(200);
			TotalColumn.setPrefWidth(140);
			TotalPayeColumn.setPrefWidth(100);
			ResteColumn.setPrefWidth(240);

			
			VenteList=new TableView<>();
			VenteList.setPrefSize( 0, 800);			
			VenteList.getColumns().addAll(idVenteColumn,NomClientColumn,DateColumn,TotalColumn,TotalPayeColumn,ResteColumn,ClientColumn);
			
			VenteList.setItems(VenteObservableList);
			
			idVenteColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,Long>("id_vente")
				);
			NomClientColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,String>("nom_client")
				);
//			NomClientColumn.setCellValueFactory(
//				    new PropertyValueFactory<Vente,String>("prenom")
//				);
			DateColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,LocalDate>("date")
				);
			TotalColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,Double>("total")
				);
			TotalPayeColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,Double>("total_paye")
				);
			ResteColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,Double>("reste")
				);
			ClientColumn.setCellValueFactory(
				    new PropertyValueFactory<Vente,Long>("id_client")
				);
	
		    grid1.add(lblTotal, 0, 0);
		    grid1.add(lblTotalVal, 1, 0);
		    grid1.add(lblTotalPaye, 0, 1);
		    grid1.add(lblTotalPayeVal, 1, 1);
		    grid1.add(lblReste, 0, 2);
		    grid1.add(lblResteVal, 2, 2);
		    grid1.setVgap(10);
		     
			
		}
		
		private void addNodestoPane() {
					      
			hboxBottom.getChildren().addAll(lblCopyright);
			hboxTop.getChildren().addAll(lblTitle);
			hboxCenter.getChildren().addAll(vboxLeft,vboxRight);	
			vboxRight.getChildren().addAll(vboxR1,vboxR2,rechercherBtn,grid1);
			vboxR1.getChildren().addAll(lblDate1,Date1Input,lblDate2,Date2Input,lblNom,NomInput,lblNumVente,NumVenteInput);
			vboxLeft.getChildren().addAll(VenteList);
			
			root.getChildren().addAll(menuBar,hboxTop,hboxCenter,hboxBtn,hboxBottom);
			
		}
		
		
		public void initWindow(){
			
			window.setScene(scene);
			window.setTitle("Gestion de Magasin  -  Acceuil");
			window.getIcons().add(new Image("css/logo_icon.png"));
			window.setMaximized(true);
			window.show();
			
		}
		
		private void addStyleToNodes(){
			scene.getStylesheets().add("css/application.css");
			hboxTop.getStyleClass().addAll("hbox","padding");
			hboxBottom.getStyleClass().addAll("menuStyle","padding");
			
//			hboxBtn.setAlignment(Pos.CENTER_LEFT);
//			hboxBtn.getStyleClass().add("padding2");
			vboxLeft.getStyleClass().add("padding");
			vboxRight.getStyleClass().add("padding");
			vboxR2.getStyleClass().add("border");
			hboxBtn.setAlignment(Pos.CENTER_LEFT);
			hboxBtn.getStyleClass().add("padding2");
			menuBar.getStyleClass().add("menuStyle");
			
			Produits.getStyleClass().addAll("textWhite","cursor");
			Clients.getStyleClass().addAll("textWhite","cursor");
			Ventes.getStyleClass().addAll("textWhite","cursor");
			Paiments.getStyleClass().addAll("textWhite","cursor");
			Help.getStyleClass().addAll("textWhite","cursor");
			
//			newProduit.getStyleClass().addAll("cursor");
//			listProduits.getStyleClass().addAll("cursor");
//			
//			newClient.getStyleClass().addAll("cursor");
//			listClients.getStyleClass().addAll("cursor");
			
			newVente.getStyleClass().addAll("cursor");
			listVentes.getStyleClass().addAll("cursor");
			
			newPaiement.getStyleClass().addAll("cursor");
			listPaiements.getStyleClass().addAll("cursor");			
	
			
			helpItem.getStyleClass().addAll("cursor");
			
			lblTitle.getStyleClass().add("titleFont");
			lblCopyright.getStyleClass().add("textWhite");
			

			lblTotal.getStyleClass().addAll("fontListe","inputFont");
			lblTotalPaye.getStyleClass().addAll("fontListe","inputFont");
			lblReste.getStyleClass().addAll("fontListe","inputFont");
			

			lblTotalVal.getStyleClass().addAll("fontListe","inputFont");
			lblTotalPayeVal.getStyleClass().addAll("fontListe","inputFont");
			lblResteVal.getStyleClass().addAll("fontListe","inputFont");
			
			lblDate1.getStyleClass().add("fontListe");
			lblDate2.getStyleClass().add("fontListe");
			lblNom.getStyleClass().add("fontListe");
			lblNumVente.getStyleClass().add("fontListe");
	
			
			
			Date1Input.getStyleClass().addAll("fontListe","inputFont");
			Date2Input.getStyleClass().addAll("fontListe","inputFont");
			NomInput.getStyleClass().addAll("fontListe","inputFont");
			NumVenteInput.getStyleClass().addAll("fontListe","inputFont");
	
			
			
			rechercherBtn.getStyleClass().addAll("fontListe","textWhite","btn","cursor");
			
		}
		
		private void addEvent() {
		
			Produits.setOnMouseClicked((mouseEvent) -> {
				listProduit= new ListeProduits();
				window.close();
		    });
			Clients.setOnMouseClicked((mouseEvent) -> {
				listClient= new ListeClients();
				window.close();
		    });
			newVente.setOnAction(event ->{
				   nouveauVente=new NouveauVente();
				   window.close();
			});
				
			listVentes.setOnAction(event ->{
					

			});
			listPaiements.setOnAction(event ->{
				

			});
			
			VenteList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
				handler.selectItemVente();
			});
			
		}
		
		
		public ListeVentes(){
			
			initWindow();
			createCompnents();
			handler.updateListVente();
			addNodestoPane();
			addStyleToNodes();
			addEvent();
			
		
		}
		
		
		
	}




	
	
	


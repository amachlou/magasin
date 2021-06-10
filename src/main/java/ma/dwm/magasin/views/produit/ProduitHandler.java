package ma.dwm.magasin.views.produit;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.dwm.magasin.entities.Produit;
import ma.dwm.magasin.repositories.IProduitRepository;
import ma.dwm.magasin.views.application.ListeProduits;
import ma.dwm.magasin.views.application.NouveauVente;

public class ProduitHandler {
	
	@Autowired
	private IProduitRepository produitRepository;
	
	ListeProduits listProduit=null;
	NouveauVente gestionVente=null;
//	IProduitDAO pdao=new ProduitDaoImpl();

	public ProduitHandler(ListeProduits listProduit) {
		this.listProduit=listProduit;
	}
	public ProduitHandler(NouveauVente gestionVente) {
		this.gestionVente=gestionVente;
	}
	

	public void updateListProduits() {
		
		List<Produit> list = produitRepository.findAll();
		listProduit.produitObservableList.addAll(list);
		calculerTotal();
	}
	
	public void updateListProduitVente() {
		List list=produitRepository.findAll();
		gestionVente.produitObservableList.addAll(list);
		
	}
	
	

	public void calculerTotal() {
	
		double total=0;
		for(Produit p:listProduit.produitObservableList) {
			total+=p.getPrix();	
		}
		System.out.println(total);		
		listProduit.lblNumTotal.setText(total+"");
		
	}
	
	public void addClick() {
		
		String designation=listProduit.designationInput.getText();
		int qte=Integer.valueOf(listProduit.qteInput.getText());
		double prix=Double.valueOf(listProduit.prixInput.getText());
		LocalDate date=listProduit.dateInput.getValue();	
		Produit p=new Produit(null, designation, qte, prix, null, null);
//		Produit(0,designation,qte,prix,date);
		produitRepository.save(p);
		updateListProduits();
	}
	
	public void remove() {
	
	Produit p = listProduit.produitList.getSelectionModel().getSelectedItem();
	long id=p.getId_produit();
	produitRepository.deleteById(id);
	updateListProduits();

	}

	public void selectItem() {
		Produit p = listProduit.produitList.getSelectionModel().getSelectedItem();
		long id=p.getId_produit();
		String designation = p.getDesignation();
		int qte = p.getQte();
		double prix = p.getPrix();
		LocalDate date = p.getDate().toLocalDate();
		
		listProduit.titleInput.setText(id+"");
		listProduit.designationInput.setText(designation);
		listProduit.qteInput.setText(qte+"");
		listProduit.prixInput.setText(prix+"");
		listProduit.dateInput.setValue(date);
		
	}
	
	public void selectItemVente() {
		Produit p = gestionVente.produitList.getSelectionModel().getSelectedItem();
		long id_produit=p.getId_produit();
		String designation = p.getDesignation();
		double prix = p.getPrix();
		
		gestionVente.id_produit.setText(id_produit+"");
		gestionVente.designationInput.setText(designation);
		gestionVente.prixInput.setText(prix+"");
		gestionVente.id_produit.setText(id_produit+"");
	}
	
	public void modify() {
		
		long id=Integer.valueOf(listProduit.titleInput.getText());
		String designation=listProduit.designationInput.getText();
		int qte=Integer.valueOf(listProduit.qteInput.getText());
		double prix=Double.valueOf(listProduit.prixInput.getText());
		LocalDate date=listProduit.dateInput.getValue();	
//		TODO To Complete
//		Produit p = new Produit(null, designation, qte, prix, date, null);
//		produitRepository.save(p);
//		updateListProduits(); 
		
	}
	
	public void search() {
		
		String designation=listProduit.rechercheInput.getText();
		List<Produit> list=produitRepository.findByDesignationContains(designation);
		listProduit.produitObservableList.addAll(list);
		calculerTotal();
	}
	

}

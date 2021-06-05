package ma.dwm.magasin.views.vente;

public class LigneCommande {
	
	private long id_commande;
	private String designation;
	private double prix;
	private int qte;
	private double sous_total;
	private long id_produit;
	private long id_vente;

	
	public Long getId_commande() {
		return id_commande;
	}
	public void setId_commande(Long id_commande) {
		this.id_commande = id_commande;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public double getSous_total() {
		return sous_total;
	}
	public void setSous_total(double sous_total) {
		this.sous_total = sous_total;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public long getId_produit() {
		return id_produit;
	}
	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}
	public long getId_vente() {
		return id_vente;
	}
	public void setId_vente(long id_vente) {
		this.id_vente = id_vente;
	}
	public LigneCommande(long id_commande, String designation, double prix, int qte, double sous_total, long id_produit,long id_vente) {
		super();
		this.id_commande = id_commande;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
		this.sous_total = sous_total;
		this.id_produit = id_produit;
		this.id_vente = id_vente;
	}
	
	public LigneCommande(long id_commande, String designation, double prix, int qte, double sous_total, long id_produit) {
		super();
		this.id_commande = id_commande;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
		this.sous_total = sous_total;
		this.id_produit = id_produit;
	}

	
	@Override
	public String toString() {
		return  id_commande + designation + prix+ qte + sous_total + id_produit + id_vente ;
	}


	
	
	
	
	

}

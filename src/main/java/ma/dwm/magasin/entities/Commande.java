package ma.dwm.magasin.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COMMANDES")
@Data @NoArgsConstructor @AllArgsConstructor
public class Commande implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commande;
	private double qte;
	private double sous_total;
	
	@ManyToOne
	@JoinColumn(name = "vente_id", referencedColumnName = "id_vente", nullable = false)
	private Vente vente;
	@OneToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id_commande", nullable = false)
	private Produit produit;
	
	public double getSous_total(){
		return qte*produit.getPrix();
	}
}

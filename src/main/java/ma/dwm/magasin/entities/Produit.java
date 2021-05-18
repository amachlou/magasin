package ma.dwm.magasin.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUITS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String designation;
	private int qte;
	private double prix;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany
	@JoinColumn(name = "commande_id", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
	private Set<Commande> list_commandes;
}

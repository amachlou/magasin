package ma.dwm.magasin.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VENTES")
@Data @NoArgsConstructor @AllArgsConstructor
public class Vente implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vente;
	@Temporal(TemporalType.DATE)
	private Date date;
	//liste des lignes de commandes
	private double total;
	public static boolean isAdded=false;
	
	@OneToMany
	@JoinColumn(name = "vente_id", referencedColumnName = "id_vente", nullable = false, insertable = false, updatable = false)
	private Set<Commande> list_commandes;
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client", nullable = false)
	private Client client;
	@OneToMany
	@JoinColumn(name = "vente_id", referencedColumnName = "id_vente")
	private Set<Reglement> list_reglements;
	
	public double getTotal() {
		double tempTotal = 0L;
		for (Commande commande : list_commandes) {
			tempTotal += commande.getSous_total();
		}
		return tempTotal;
	}
}

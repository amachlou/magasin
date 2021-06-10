package ma.dwm.magasin.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REGLEMENTS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Reglement implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_regelement;
	private String mode_paiement; //comptant, trait
	
	@OneToOne
	@JoinColumn(name = "vente_id", referencedColumnName = "id_vente", nullable = false)
	private Vente vente;
	@OneToMany
	@JoinColumn(name = "reglement_id", referencedColumnName = "id_regelement", nullable = false, insertable = false, updatable = false)
	private Set<Paiement> list_paiements;
	
}

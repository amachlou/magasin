package ma.dwm.magasin.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Client implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String adresse;
	@OneToMany
	@JoinColumn(name = "client_id", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
	private Set<Vente> list_ventes;
}

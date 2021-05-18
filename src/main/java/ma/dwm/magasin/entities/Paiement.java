package ma.dwm.magasin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAIEMENTS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Paiement implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private double mtt_paiement;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "reglement_id", referencedColumnName = "code", nullable = false)
	private Reglement reglement;
	
}

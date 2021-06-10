package ma.dwm.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Vente;
import ma.dwm.magasin.views.vente.LigneCommande;

@Repository
public interface ICommandeRepository extends JpaRepository<Vente, Long>{

	@Query("from Commande c where c.vente.id_vente = :id_vente")
	List<LigneCommande> findByVenteId(@Param("id_vente") long id_vente);

}

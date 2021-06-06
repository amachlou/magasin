package ma.dwm.magasin.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Vente;

@Repository
public interface IVenteRepository extends JpaRepository<Vente, Long>{

	@Query("from vente v where v.id_vente=id_vente and v.client.nom=:nom and date between :date1 and :date2")
	void searchVente(@Param("id_vente") long id_vente,@Param("nom") String nom,@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);
	
}

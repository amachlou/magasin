package ma.dwm.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Produit;

@Repository
public interface IProduitRepository extends JpaRepository<Produit, Long>{
	
	List<Produit> findByDesignationContains(String designation);

}

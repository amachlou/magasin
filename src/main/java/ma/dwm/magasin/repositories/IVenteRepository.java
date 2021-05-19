package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Commande;

@Repository
public interface IVenteRepository extends JpaRepository<Commande, Long>{

}

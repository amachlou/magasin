package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Vente;

@Repository
public interface ICommandeRepository extends JpaRepository<Vente, Long>{

}

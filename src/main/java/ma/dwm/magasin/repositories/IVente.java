package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dwm.magasin.entities.Commande;

public interface IVente extends JpaRepository<Commande, Long>{

}

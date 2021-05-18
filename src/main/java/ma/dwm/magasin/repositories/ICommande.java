package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dwm.magasin.entities.Vente;

public interface ICommande extends JpaRepository<Vente, Long>{

}

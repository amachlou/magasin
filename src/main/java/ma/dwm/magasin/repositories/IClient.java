package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dwm.magasin.entities.Produit;

public interface IClient extends JpaRepository<Produit, Long>{

}

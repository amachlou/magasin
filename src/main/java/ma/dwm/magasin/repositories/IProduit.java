package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dwm.magasin.entities.Client;

public interface IProduit extends JpaRepository<Client, Long>{

}

package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{
	
}

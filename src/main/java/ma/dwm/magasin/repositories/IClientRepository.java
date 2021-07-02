package ma.dwm.magasin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.Client;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long>{
	
	List<Client> findByNomContains(String nomOrPresnom);
	
}

package ma.dwm.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.dwm.magasin.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	@Query("from user u where username=:username and password=:password")
	void findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
}

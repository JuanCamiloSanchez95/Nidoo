package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.User;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer>{

	public User findByEmail(String email);
	
	@Query("select u from User u where u.id = ?1")
	public User findByID(Integer id);
	
}

package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO;


import org.springframework.transaction.annotation.Transactional;

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.User;

@Transactional
public interface UserDAO extends UserBaseDAO<User>{

	
}

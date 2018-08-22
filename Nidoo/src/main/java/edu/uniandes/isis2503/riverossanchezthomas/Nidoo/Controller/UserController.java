package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.UserDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.User;

@Controller
public class UserController {

	
	  /**
	   * GET /create  --> Create a new user and save it in the database.
	   */
	  @RequestMapping("/create")
	  @ResponseBody
	  public String create(String name, String password, String nickName, String email) {
	    String userId = "";
	    try {
	      User user = new User(name, password, nickName, email);
	      userDao.save(user);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  
	  /**
	   * GET /delete  --> Delete the user having the passed id.
	   */
	  @RequestMapping("/delete")
	  @ResponseBody
	  public String delete(Integer id) {
	    try {
	      User user = new User(id);
	      userDao.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	      User user = userDao.findByEmail(email);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  /**
	   * GET /update  --> Update the email and the name for the user in the 
	   * database having the passed id.
	   */
	  @RequestMapping("/update")
	  @ResponseBody
	  public String updateUser(Integer id, String email, String name) {
	    try {
	      User user = userDao.findByID(id);
	      user.setEmail(email);
	      user.setName(name);
	      userDao.save(user);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }

	  // Private fields

	  @Autowired
	  private UserDAO userDao;
}

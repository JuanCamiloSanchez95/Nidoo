package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingConsumerDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingProviderDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.UserDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingConsumer;

@Controller
public class UserController {

	
		@Autowired
		private UserDAO userDAO;
		
		@Autowired
		private ParkingConsumerDAO parkingConsumerDAO;
		
		@Autowired
		private ParkingProviderDAO parkingProviderDAO;
	
		/**
		   * /user/create/parkingconsumer?name=[name]&password=[password]&nickName=[nickName]&email=[email]-> create a new 
		   * person user and save it in the database.
		   * 
		   * @param email The parkingconsumer email
		   * @param firstName The person's first name
		   * @return a string describing if the person is succesfully created or not.
		   */
		  @RequestMapping("/user/create/parkingconsumer")
		  @ResponseBody
		  public String createParkingconsumer(String name, String password, String nickName, String email) {
		    try {
		      ParkingConsumer parkingConsumer = new ParkingConsumer();
		      parkingConsumer.setName(name);
		      parkingConsumer.setPassword(password);
		      parkingConsumer.setNickName(nickName);
		      parkingConsumer.setEmail(email);
		      parkingConsumerDAO.save(parkingConsumer);
		    }
		    catch (Exception ex) {
		      return "Error creating the person: " + ex.toString();
		    }
		    return "Person succesfully created!";
		  }
		  
		  /**
		   * /user/delete/parkingconsumer?id=[id] -> delete the person user having the passed id.
		   * 
		   * @param id The id for the person to delete
		   * @return A string describing if the person is succesfully deleted or not.
		   */
		  @RequestMapping("/user/delete/parkingconsumer")
		  @ResponseBody
		  public String deleteParkingconsumer(long id) {
		    try {
		    	parkingConsumerDAO.delete(new ParkingConsumer(id));
		    }
		    catch (Exception ex) {
		      return "Error deleting the user:" + ex.toString();
		    }
		    return "User succesfully deleted!";
		}

}

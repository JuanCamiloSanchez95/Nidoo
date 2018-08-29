package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingConsumerDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingProviderDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.UserDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingConsumer;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingProvider;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ParkingConsumerDAO parkingConsumerDAO;

	@Autowired
	private ParkingProviderDAO parkingProviderDAO;

	/*
	 * =============================================Start
	 * USER=========================================================================
	 * ==================
	 */

	/**
	 * /user/get/id?id=[id] -> return the user having the passed id.
	 * 
	 * @param id
	 *            The id to search in the database.
	 * @return The user or a message error if the user is not found.
	 */
	@GetMapping("/user/get/id")
	@ResponseBody
	public User getUserID(long id) {
		try {
			User user = userDAO.findByID(id);
			if (user instanceof ParkingConsumer) {
				ParkingConsumer parkingConsumer = (ParkingConsumer) user;
				return parkingConsumer;
			}

			if (user instanceof ParkingProvider) {
				ParkingProvider parkingProvider = (ParkingProvider) user;
				return parkingProvider;
			}

			return user;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * /user/get/id?email=[email] -> return the user having the passed id.
	 * 
	 * @param email
	 *            The email to search in the database.
	 * @return The user or a message error if the user is not found.
	 */
	@GetMapping("/user/get")
	@ResponseBody
	public User getUserEmail(String email) {
		try {
			User user = userDAO.findByEmail(email);

			if (user instanceof ParkingConsumer) {
				ParkingConsumer parkingConsumer = (ParkingConsumer) user;
				return parkingConsumer;
			}

			if (user instanceof ParkingProvider) {
				ParkingProvider parkingProvider = (ParkingProvider) user;
				return parkingProvider;
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	/**
	 * /user/update -> get the user with passed
	 * 
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@PostMapping("/user/update")
	@ResponseBody
	public User update(@RequestBody @Valid User user) {
		try {
			User oldUser = userDAO.findByID(user.getId());
			oldUser.setName(user.getName());
			oldUser.setNickName(user.getNickName());
			oldUser.setPassword(user.getPassword());
			oldUser.setEmail(user.getEmail());

			userDAO.save(oldUser);
			
			return oldUser;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}

	/**
	 * /user/delete?id=[id] -> delete the user having the passed id.
	 * 
	 * @param id
	 *            The id for the user to delete
	 * @return A string describing if the user is succesfully deleted or not.
	 */
	@DeleteMapping("/user/delete")
	@ResponseBody
	public String deleteUser(long id) {
		try {
			userDAO.delete(userDAO.findByID(id));
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	/*
	 * ====================================================End
	 * User=========================================================================
	 * ==============
	 */

	/**
	 * /user/create/parkingconsumer]->
	 * 
	 * create a new person user and save it in the database.
	 * 
	 * @return a string describing if the person is succesfully created or not.
	 */
	@PutMapping("/user/create/parkingconsumer")
	@ResponseBody
	public String createParkingConsumer(@RequestBody @Valid ParkingConsumer parkingConsumer) {
		try {
			parkingConsumerDAO.save(parkingConsumer);
		} catch (Exception ex) {
			return "Error creating the ParkingConsumer: " + ex.toString();
		}
		return "Parking Consumer succesfully created!";
	}

	/**
	 * /user/create/parkingprovider]->
	 * 
	 * create a new person user and save it in the database.
	 * 
	 * @return a string describing if the person is succesfully created or not.
	 */
	@PutMapping("/user/create/parkingprovider")
	@ResponseBody
	public String createParkingProvider(@RequestBody @Valid ParkingProvider parkingProvider) {
		try {
			parkingProviderDAO.save(parkingProvider);
		} catch (Exception ex) {
			return "Error creating the ParkingProvider: " + ex.toString();
		}
		return "Parking Provider succesfully created!";
	}

	/**
	 * /user/update/parkingconsumer -> get the user with passed
	 * 
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@PostMapping("/user/update/parkingconsumer")
	@ResponseBody
	public ParkingConsumer updateParkingConsumer(@RequestBody @Valid ParkingConsumer parkingConsumer) {
		try {
			
			User userUpdate = this.update((User) parkingConsumer);			
			ParkingConsumer oldParkingConsumer = (ParkingConsumer) userUpdate;
			oldParkingConsumer.setCreditCard(parkingConsumer.getCreditCard());
			
			parkingConsumerDAO.save(oldParkingConsumer);
			return oldParkingConsumer;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}
	
	
	/**
	 * /user/update/parkingprovider -> get the user with passed
	 * 
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@PostMapping("/user/update/parkingprovider")
	@ResponseBody
	public ParkingProvider updateParkingProvider(@RequestBody @Valid ParkingProvider parkingProvider) {
		try {
			
			User userUpdate = this.update((User) parkingProvider);			
			ParkingProvider oldParkingProvider = (ParkingProvider) userUpdate;
			oldParkingProvider.setAccountNumber(parkingProvider.getAccountNumber());
			
			parkingProviderDAO.save(oldParkingProvider);
			return oldParkingProvider;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}

	/**
	 * /user/delete/parkingconsumer?id=[id] -> delete the person user having the
	 * passed id.
	 * 
	 * @param id
	 *            The id for the person to delete
	 * @return A string describing if the person is succesfully deleted or not.
	 */
	@DeleteMapping("/user/delete/parkingconsumer")
	@ResponseBody
	public String deleteParkingConsumer(long id) {
		try {
			parkingConsumerDAO.delete(new ParkingConsumer(id));
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * /user/delete/parkingprovider?id=[id] -> delete the person user having the
	 * passed id.
	 * 
	 * @param id
	 *            The id for the person to delete
	 * @return A string describing if the person is succesfully deleted or not.
	 */
	@DeleteMapping("/user/delete/parkingprovider")
	@ResponseBody
	public String deleteParkingProvider(long id) {
		try {
			parkingProviderDAO.delete(new ParkingProvider(id));
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

}

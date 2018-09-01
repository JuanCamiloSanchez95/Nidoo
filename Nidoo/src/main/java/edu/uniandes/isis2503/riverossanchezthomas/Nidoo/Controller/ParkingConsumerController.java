package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingConsumerDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.VehicleDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingConsumer;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingProvider;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.User;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.Vehicle;

@Controller
@RequestMapping("/parkingconsumers")
public class ParkingConsumerController extends UserController{

	@Autowired
	private ParkingConsumerDAO parkingConsumerDAO;
	
	@Autowired
	private VehicleDAO vehicleDAO;
	
	/**
	 * /parkingconsumers/create -> create a new parkingconsumer user and save it in the database.
	 * 
	 * @return a string describing if the person is succesfully created or not.
	 */
	@PutMapping("/create")
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
	 * /user/update/parkingconsumer -> updated the parkingconsumer with passed
	 * 
	 * @return A parkingconsumer describing if the user is succesfully updated or not.
	 */
	@PostMapping("/update")
	@ResponseBody
	public ParkingConsumer updateParkingConsumer(@RequestBody @Valid ParkingConsumer parkingConsumer) {
		try {
			
			ParkingConsumer oldParkingConsumer = parkingConsumerDAO.findParkingConsumerByID(parkingConsumer.getId());
			oldParkingConsumer.setName(parkingConsumer.getName());
			oldParkingConsumer.setNickName(parkingConsumer.getNickName());
			oldParkingConsumer.setPassword(parkingConsumer.getPassword());
			oldParkingConsumer.setEmail(parkingConsumer.getEmail());
			oldParkingConsumer.setCreditCard(parkingConsumer.getCreditCard());
			
			parkingConsumerDAO.save(oldParkingConsumer);
			return oldParkingConsumer;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}
	
	/**
	 * /parkingconsumers/allParkingConsumers -> return all the ParkingConsumers..
	 * @return a empty list.
	 */
	@ResponseBody
	@GetMapping("/allparkingconsumers")
	public List<ParkingConsumer> getParkingConsumer() {
		try {
			List<ParkingConsumer> parkingConsumers = parkingConsumerDAO.getAllParkingConsumer();
			return parkingConsumers;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * /parkingconsumers/delete/{id} -> delete the parkingconsumer user having the
	 * passed id.
	 * 
	 * @param id
	 *            The id for the person to delete
	 * @return A string describing if the parkingconsumer is succesfully deleted or not.
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteParkingConsumer(@PathVariable("id") long id) {
		try {
			parkingConsumerDAO.delete(new ParkingConsumer(id));
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	/* Start the methods for relationships*/
	
	@PutMapping("/create/{id}/getvehicle")
	@ResponseBody
	public String createParkingConsumerVehicle(@PathVariable("id") long id, @RequestBody @Valid Vehicle vehicle) {
		try {
			User user = parkingConsumerDAO.findUserByID(id);
			if(user instanceof ParkingProvider) {
				return "Error the user need to be a Parking Consumer";
			}
			ParkingConsumer parkingConsumer = (ParkingConsumer) user;
			vehicle.setParkingConsumer(parkingConsumer);
			
			vehicleDAO.save(vehicle);
			
		}catch(Exception ex) {
			return "Error creating Vehicle  related with the ParkingConsumer with id: " + id;
		}
		return "Vehicle succesfully created! linked to Parking Consumer with id: " + id;
	}
	
}

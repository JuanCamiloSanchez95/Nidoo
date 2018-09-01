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

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.VehicleDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.Vehicle;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	
	@Autowired
	private VehicleDAO vehicleDAO;
	
	/**
	 * /vehicles/create ->  create a new vehicles user and save it in the database.
	 * 
	 * @return a string describing if the person is succesfully created or not.
	 */
	@PutMapping("/create")
	@ResponseBody
	public String createVehicle(@RequestBody @Valid Vehicle vehicle) {
		try {
			vehicleDAO.save(vehicle);
		} catch (Exception ex) {
			return "Error creating the Vehicle: " + ex.toString();
		}
		return "Vehicle succesfully created!";
	}
	
	
	/**
	 * /vehicles/update -> updated the vehicles with passed
	 * 
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@PostMapping("/update")
	@ResponseBody
	public Vehicle updateVehicle(@RequestBody @Valid Vehicle vehicle) {
		try {
			
			Vehicle oldVehicle = vehicleDAO.findVehicleByID(vehicle.getId());
			oldVehicle.setLincensePlate(vehicle.getLincensePlate());
			oldVehicle.setCarModel(vehicle.getCarModel());
			oldVehicle.setCarBrand(vehicle.getCarBrand());
			
			vehicleDAO.save(oldVehicle);
			return oldVehicle;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}
	
	/**
	 * /vehicles/getbyid/{id} -> return the user having the passed id.
	 * 
	 * @param id
	 *            The id to search in the database.
	 * @return The user or a message error if the user is not found.
	 */
	@GetMapping("/getbyid/{id}")
	@ResponseBody
	public Vehicle getVehicleID(@PathVariable("id") long id) {
		try {
			Vehicle vehicle = vehicleDAO.findVehicleByID(id);

			return vehicle;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * /vehicles/allvehicless -> return all the vehicles..
	 * @return a empty list.
	 */
	@ResponseBody
	@GetMapping("/allvehicles")
	public List<Vehicle> getVehicles() {
		try {
			List<Vehicle> vehicles = vehicleDAO.getAllVehicle();
			return vehicles;
		} catch (Exception ex) {
			return null;
		}
	}

	
	/**
	 * /vehicles/delete/{id} -> delete the vehicles user having the
	 * passed id.
	 * 
	 * @param id
	 *            The id for the vehicles to delete
	 * @return A string describing if the person is succesfully deleted or not.
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteVehicle(@PathVariable("id") long id) {
		try {
			vehicleDAO.delete(new Vehicle(id));
		} catch (Exception ex) {
			return "Error deleting the vehicle:" + ex.toString();
		}
		return "Vehicle succesfully deleted!";
	}
	
	
}

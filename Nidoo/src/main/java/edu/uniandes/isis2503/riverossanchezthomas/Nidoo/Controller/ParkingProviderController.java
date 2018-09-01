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

import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.DAO.ParkingProviderDAO;
import edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity.ParkingProvider;

@Controller
@RequestMapping("/parkingproviders")
public class ParkingProviderController extends UserController{

	
	@Autowired
	private ParkingProviderDAO parkingProviderDAO;
	

	/**
	 * /parkingproviders/create ->  create a new parkingprovider user and save it in the database.
	 * 
	 * @return a string describing if the person is succesfully created or not.
	 */
	@PutMapping("/create")
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
	 * /parkingproviders/update -> updated the parkingprovider with passed
	 * 
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@PostMapping("/update")
	@ResponseBody
	public ParkingProvider updateParkingProvider(@RequestBody @Valid ParkingProvider parkingProvider) {
		try {
			
			ParkingProvider oldParkingProvider = parkingProviderDAO.findParkingProviderByID(parkingProvider.getId());
			oldParkingProvider.setName(parkingProvider.getName());
			oldParkingProvider.setNickName(parkingProvider.getNickName());
			oldParkingProvider.setPassword(parkingProvider.getPassword());
			oldParkingProvider.setEmail(parkingProvider.getEmail());
			oldParkingProvider.setAccountNumber(parkingProvider.getAccountNumber());
			
			parkingProviderDAO.save(oldParkingProvider);
			return oldParkingProvider;
		} catch (Exception ex) {
			ex.toString();
			return null;
		}
	}
	
	/**
	 * /ParkingProviders/allParkingProviders -> return all the ParkingProviders..
	 * @return a empty list.
	 */
	@ResponseBody
	@GetMapping("/allparkingproviders")
	public List<ParkingProvider> getParkingProvider() {
		try {
			List<ParkingProvider> parkingProviders = parkingProviderDAO.getAllParkingProvider();
			return parkingProviders;
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * /parkingproviders/delete/{id} -> delete the parkingprovider user having the
	 * passed id.
	 * 
	 * @param id
	 *            The id for the parkingprovider to delete
	 * @return A string describing if the person is succesfully deleted or not.
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteParkingProvider(@PathVariable("id") long id) {
		try {
			parkingProviderDAO.delete(new ParkingProvider(id));
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

}

package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingConsumer extends User {
	
	private int creditCard;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parkingConsumer", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;

	public ParkingConsumer() {	}

	public ParkingConsumer(long id) {
		super(id);
	}

	public ParkingConsumer(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int creditCard, List<Vehicle> vehicles) {
		super(name, password, nickName, email);
		this.creditCard = creditCard;
		this.vehicles = vehicles;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}

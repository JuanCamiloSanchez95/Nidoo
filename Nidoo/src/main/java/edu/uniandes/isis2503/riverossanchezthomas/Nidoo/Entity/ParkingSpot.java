package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParkingSpot {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ParkingProvider parkingProvider;
	
	public ParkingSpot() {}
	
	public ParkingSpot(long id) {
		this.id = id;
	}

	public ParkingSpot(int number, ParkingProvider parkingProvider) {
		super();
		this.number = number;
		this.parkingProvider = parkingProvider;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}

}

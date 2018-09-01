package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String address;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ParkingProvider parkingProvider;
	
	public Parking() {}

	public Parking(long id) {
		this.id = id;
	}

	public Parking(String name, String address, ParkingProvider parkingProvider) {
		super();
		this.name = name;
		this.address = address;
		this.parkingProvider = parkingProvider;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}
}

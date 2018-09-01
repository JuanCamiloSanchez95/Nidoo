package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String lincensePlate;
	
	private String carModel;
	
	private String carBrand;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ParkingConsumer parkingConsumer;
	
	public Vehicle() {}
	
	public Vehicle(long id) {
		this.id = id;
	}

	public Vehicle(String lincensePlate, String carModel, String carBrand, ParkingConsumer parkingConsumer) {
		super();
		this.lincensePlate = lincensePlate;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.parkingConsumer = parkingConsumer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLincensePlate() {
		return lincensePlate;
	}

	public void setLincensePlate(String lincensePlate) {
		this.lincensePlate = lincensePlate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public ParkingConsumer getParkingConsumer() {
		return parkingConsumer;
	}

	public void setParkingConsumer(ParkingConsumer parkingConsumer) {
		this.parkingConsumer = parkingConsumer;
	}

	
}

package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class ParkingProvider extends User {
	
	private int accountNumber;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parkingProvider", cascade = CascadeType.ALL)
	private List<ParkingSpot> parkingspots;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parkingProvider", cascade = CascadeType.ALL)
	private List<Parking> parkings;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Booking> bookings;

	public ParkingProvider() {	}

	public ParkingProvider(long id) {
		super(id);
	}

	public ParkingProvider(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int accountNumber, List<ParkingSpot> parkingspots, List<Parking> parkings, List<Booking> bookings) {
		super(name, password, nickName, email);
		this.accountNumber = accountNumber;
		this.parkingspots = parkingspots;
		this.parkings = parkings;
		this.bookings = bookings;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<ParkingSpot> getParkingspots() {
		return parkingspots;
	}

	public void setParkingspots(List<ParkingSpot> parkingspots) {
		this.parkingspots = parkingspots;
	}

	public List<Parking> getParkings() {
		return parkings;
	}

	public void setParkings(List<Parking> parkings) {
		this.parkings = parkings;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}

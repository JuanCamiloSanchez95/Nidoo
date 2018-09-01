package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@CreatedDate
	private Date beginDate;
	
	private Date endDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ParkingProvider parkingProvider;
	
	public Booking() {}
	
	public Booking(long id) {
		this.id = id;
	}

	public Booking(Date endDate, ParkingProvider parkingProvider) {
		super();
		this.endDate = endDate;
		this.parkingProvider = parkingProvider;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ParkingProvider getParkingProvider() {
		return parkingProvider;
	}

	public void setParkingProvider(ParkingProvider parkingProvider) {
		this.parkingProvider = parkingProvider;
	}
}

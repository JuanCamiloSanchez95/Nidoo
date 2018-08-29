package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingConsumer extends User {
	
	private int creditCard;

	public ParkingConsumer() {	}

	public ParkingConsumer(long id) {
		super(id);
	}

	public ParkingConsumer(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int creditCard) {
		super(name, password, nickName, email);
		this.creditCard = creditCard;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

}

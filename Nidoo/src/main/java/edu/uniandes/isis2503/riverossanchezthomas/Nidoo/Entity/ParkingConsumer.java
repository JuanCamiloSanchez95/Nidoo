package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingConsumer extends User {

	public ParkingConsumer() {	}

	public ParkingConsumer(long id) {
		super(id);
	}

	public ParkingConsumer(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email) {
		super(name, password, nickName, email);
	}

}

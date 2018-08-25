package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingProvider extends User {

	public ParkingProvider() {	}

	public ParkingProvider(long id) {
		super(id);
	}

	public ParkingProvider(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email) {
		super(name, password, nickName, email);
	}

}

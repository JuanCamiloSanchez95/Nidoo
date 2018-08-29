package edu.uniandes.isis2503.riverossanchezthomas.Nidoo.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ParkingProvider extends User {
	
	private int accountNumber;

	public ParkingProvider() {	}

	public ParkingProvider(long id) {
		super(id);
	}

	public ParkingProvider(@NotNull String name, @NotNull String password, @NotNull String nickName,
			@NotNull String email, int accountNumber) {
		super(name, password, nickName, email);
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}

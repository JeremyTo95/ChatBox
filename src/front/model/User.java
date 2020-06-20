package front.model;


import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
	private UUID   id;
	private String firstName;
	private String lastName;
	private String pseudo;
	private String password;

	public User(String firstName, String lastName, String pseudo, String password) {
		this.id        = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.pseudo    = pseudo;
		this.password  = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", pseudo='" + pseudo + '\'' +
				'}';
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLastName() {
		return lastName;
	}

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

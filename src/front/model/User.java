package front.model;


import java.util.UUID;

public class User {
	private UUID   id;
	private String firstName;
	private String lastName;
	private String pseudo;

	public User(String firstName, String lastName, String pseudo) {
		this.id        = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.pseudo    = pseudo;
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
}

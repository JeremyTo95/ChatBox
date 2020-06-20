package front.model;


import java.io.Serializable;
import java.util.UUID;

/**
 * <h1>Object User</h1>
 * This method describe the user of the service
 */
public class User implements Serializable {
	private UUID   id;
	private String firstName;
	private String lastName;
	private String pseudo;
	private String password;

	/**
	 * Constructor of a user
	 *
	 * @param firstName
	 * @param lastName
	 * @param pseudo
	 * @param password
	 */
	public User(String firstName, String lastName, String pseudo, String password) {
		this.id        = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.pseudo    = pseudo;
		this.password  = password;
	}

	/**
	 * Parse the user into a string json
	 * @return
	 */
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", pseudo='" + pseudo + '\'' +
				'}';
	}

	/**
	 * Getter of the firstname
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter of the firstname
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter of the pseudo
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter of the pseudo
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter of the lastname
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter of the Id
	 * @return
	 */
	public UUID getId() {
		return id;
	}


	/**
	 * Setter of the Id
	 * @param id
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Setter of the lastname
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter of the password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

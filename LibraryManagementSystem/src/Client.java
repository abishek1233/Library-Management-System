/*
* Client.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Client object to represent the differnt Clients in the library such as normal clients and Vip Clients.
* 
*
*/

// Base Class
public class Client {
	
	// Two Common features amongst the Clients.
	private String name;
	private String emailAddress;
	private int id;  
	private String startingSection; 
	
	//adding the Clients.
	public Client (String name, String emailId, String startingSection)
	{
		this.setName(name);
		this.setEmailAddress(emailId);
		this.setId(Id.createId());
		this.setStartingSection(startingSection);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the startingSection
	 */
	public String getStartingSection() {
		return startingSection;
	}

	/**
	 * @param startingSection the startingSection to set
	 */
	public void setStartingSection(String startingSection) {
		this.startingSection = startingSection;
	}
}

// Derived Class - Normal Client
class NormalClient extends Client {
	
	// Initializing the Normal Client Class
	public NormalClient (String name, String emailId, String startingSection)
	{
		super(name, emailId, startingSection);
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "Client [The Client's name is " + getName() + ", Email Address " + getEmailAddress() + " ,Type of client: " + this.getClass().getSimpleName() +"]";
	}
}

//Derived Class - VIP Client
class VipClient extends Client {
	
	// Initializing the VIP Client Class
	public VipClient (String name, String emailId, String startingSection)
	{
		super(name, emailId, startingSection);
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "Client [The Client's name is " + getName() + ", Email Address " + getEmailAddress() + " ,Type of client: " + this.getClass().getSimpleName() +"]";
	}
}
/*
* Publication.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Publication object to represent the differnt publications available in the library such as books, magazines, bluerays and CD's.
* 
*
*/

// Base Class
public class Publications {
	
	// Two Common features amongst the Publications.
	private String title;
	private int yearOfPublication;
	private int id;
	private String section;
	
	//adding the publications.
	public Publications ( String title, int yearOfPub, String section)
	{
		this.setTitle(title);
		this.setYearOfPublication(yearOfPub);
		this.setId(Id.createId());
		this.setSection(section);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the yearOfPublication
	 */
	public int getYearOfPublication() {
		return yearOfPublication;
	}

	/**
	 * @param yearOfPublication the yearOfPublication to set
	 */
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
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
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}
}

// Derived Class- Books
class Book extends Publications {
	
	// Book class adds one more parameter as per the requirements
	public String author;
	
	// Book class has one constructor
	public Book (String auth,String title, int yearOfPub, String section)
	{
		super(title, yearOfPub,section);
		author = auth;
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "Book [The Books's name is " + getTitle() + ", Authored By " + author + ", Published in the Year: " + getYearOfPublication() +" is in the: " + getSection()+ " ]";
	}
}

//Derived Class- Magazine
class Magazine extends Publications {
	
	// Magazine class adds one more parameter as per the requirements
	public int issue;
	
	// Magazine class has one constructor
	public Magazine (String title, int yearOfPub, int issueNumber,String section)
	{
		super(title, yearOfPub,section);
		issue = issueNumber;
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "Magazine [The Magazine's name is " + getTitle() + ", Issue Number " + issue + ", Published in the Year: " + getYearOfPublication() + " is in the: " + getSection()+ " ]";
	}
}

//Derived Class- Magazine
class BlueRay extends Publications {
	
	
	// BlueRay class has one constructor
	public BlueRay (String title, int yearOfPub,String section)
	{
		super(title, yearOfPub,section);
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "BlueRay [The BlueRay's name is " + getTitle() + ", Published in the Year: " + getYearOfPublication() + " is in the: " + getSection() + " ]";
	}
}

//Derived Class- CD
class CD extends Publications {
	
	// CD class adds one more parameter as per the requirements
	public String author;
	
	
	// CD class has one constructor
	public CD (String auth, String title, int yearOfPub,String section)
	{
		super(title, yearOfPub,section);
		author = auth;
	}
	// toString Method to print the output.
	@Override
	public String toString() {
		return "CD [The CD's name is " + getTitle() + ", Authored By " + author + ", Published in the Year: " + getYearOfPublication() + " is in the: " + getSection() + " ]";
	}
}

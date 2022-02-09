/*
* Id.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Id object used to generate the unique ID's for both the publications and the Clients..
* 
*
*/

//Base Class
public class Id {
	
	static int maxId = 0;
	
	// Method to create the unique ID for publications and Clients.
	public static int createId() {
		return maxId++;
	}

}

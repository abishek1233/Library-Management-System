/*
* LibraryManagement.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* LibraryManagement mimics/implements the interface file and all the methods which can be performed in the Library are implemented here.
* 
*
*/

public class LibraryManagement implements ILibraryManagement{
	
	// Creating a new vector/instance for the respective publications.
	
	Vector books= new Vector(500);
	Vector magazines = new Vector(500);
	Vector bluerays = new Vector(500);
	Vector cds = new Vector(500);
	Vector clients = new Vector(500); 
	
	Graph libLayout = new Graph();
	static final double sectionDistance = 10;
	String currentSection = "Magazine-Section";
	
	Dictionary publicationMapping = new Dictionary();
	
	/******************************************** PART 1 ***************************************************/
	/*
	 * Method for adding a new book with given parameters - author's name, title of the book,
	 * and year of publication - to the library management system. 
	 * 
	 * Args:
	 * String author - author's name
	 * String title of the book
	 * int year of the publication of the book
	 * String section of the library 
	 * 
	 * Returns:
	 * int ID of the book
	 */
	@Override
	public int addBook(String author, String title, int yearOfPublication, String section) {
		Book book = new Book(author,title,yearOfPublication,section);
		books.addLast(new PublicationQueue(book));
		publicationMapping.add(book.getId(),book);
		return book.getId();
	}
	
	/*
	 * Method for adding a new magazine with given parameters - title, year and issue 
	 * of publication - to the library management system. 
	 * 
	 * Args:
	 * String title or name of the magazine
	 * int year of publication
	 * int issue of the magazine 
	 * String section of the library 
	 * 
	 * Returns:
	 * int ID of the magazine
	 */
	@Override
	public int addMagazine(String title, int yearOfPublication, int issue,String section) {
		Magazine magazine = new Magazine(title,yearOfPublication,issue,section);
		magazines.addLast(new PublicationQueue(magazine));
		publicationMapping.add(magazine.getId(),magazine);
		return magazine.getId();
	}
	
	/*
	 * Method for adding a new BlueRay with given parameters - title, year of publication
	 * - to the library management system. 
	 * 
	 * Args:
	 * String title or name of the movie
	 * int year of publication
	 * String section of the library 
	 * 
	 * Returns:
	 * int ID of the BlueRay
	 */
	@Override
	public int addBlueRay(String title, int yearOfPublication,String section) {
		BlueRay blueray = new BlueRay(title,yearOfPublication,section);
		bluerays.addLast(new PublicationQueue(blueray));
		publicationMapping.add(blueray.getId(),blueray);
		return blueray.getId();
	}
	
	/*
	 * Method for adding a new CD with given parameters - author, title, year of publication
	 * - to the library management system. 
	 * 
	 * Args:
	 * String author's name
	 * String title or name of the CD
	 * int year of publication
	 * String section of the library 
	 * 
	 * Returns:
	 * int ID of the CD
	 */
	@Override
	public int addCD(String author, String title, int yearOfPublication,String section) {
		CD cd = new CD(author, title, yearOfPublication,section);
		cds.addLast(new PublicationQueue(cd));
		publicationMapping.add(cd.getId(),cd);
		return cd.getId();
	}
	
	/*
	 * Method for adding a new client with given parameters - name and email address
	 * - to the library management system. 
	 * 
	 * Args:
	 * String client's name
	 * String client's email address
	 * 
	 * Returns:
	 * int ID of the Client
	 */
	@Override
	public int addClient(String name, String email) {
		NormalClient normalclient = new NormalClient(name,email,currentSection);
		clients.addLast(normalclient);
		return normalclient.getId();
	}
	
	/*
	 * Method for adding a new VIP client with given parameters - name and email address
	 * - to the library management system. 
	 * 
	 * Args:
	 * String client's name
	 * String client's email address
	 * 
	 * Returns:
	 * int ID of the VIP Client
	 */
	@Override
	public int addVIPClient(String name, String email) {
		VipClient vipclient = new VipClient(name,email,currentSection);
		clients.addLast(vipclient);
		return vipclient.getId();
	}
	
	/*
	 * Print all publications existing in the library management system. 
	 */
	@Override
	public void printAllPublications() {
		String bookString = books.toString();
		String magazineString = magazines.toString();
		String bluerayString = bluerays.toString();
		String cdString = cds.toString();
		String publicationString = bookString.substring(0, bookString.length()-1)
				+ magazineString.substring(2, magazineString.length()-1)
				+ bluerayString.substring(2, bluerayString.length()-1)
				+ cdString.substring(2, cdString.length());
		System.out.println(publicationString);
	}
	
	/*
	 * Print all clients registered in the library management system. 
	 */
	@Override
	public void printAllClients() {
		System.out.println(clients.toString());
	}
	
	/******************************************** end of PART 1 ***************************************************/

	/******************************************** PART 2 ***************************************************/ 
	
	/* 
	 * Method for borrowing a book from the library.  
	 * 
	 * Args:
	 * int client id
	 * String author's name 
	 * String title of the book 
	 * 
	 * Returns:
	 * int ID of the book 
	 */ 	
	@Override
	public int borrowBook(int client, String author, String title) {
		Client c = checkClient(client);
		if (c == null) {
			// There is no client with the specified clientID.
			return -1;
		}
		PublicationQueue pq = checkPublications(books, "Book" , author, title, 0, 0);
		if (pq == null) {
			// There is no book with the specified author and title.
			return -1;
		}
		pq.borrowPublication(c);
		
		findShortestPath(pq.getPublication().getId(),currentSection);
		currentSection = pq.getPublication().getSection();
		
		return pq.getPublication().getId();
	}
	
	/* 
	 * Method for borrowing a magazine to look at from the library.  
	 *  
	 * Args:
	 * int client id
	 * String title of the magazine 
	 * int year of the publication 
	 * int issue  
	 *  
	 * Returns:
	 * int ID of the magazine 
	 */ 
	@Override
	public int lookAtMagazine(int client, String title, int yearOfPublication, int issue) {
		Client c = checkClient(client);
		if (c == null) {
			// There is no client with the specified clientID.
			return -1;
		}
		PublicationQueue pq = checkPublications(magazines, "Magazine" , null, title, yearOfPublication, issue);
		if (pq == null) {
			// There is no Magazine with the specified title and issue and yearofPublication.
			return -1;
		}
		pq.borrowPublication(c);
		
		findShortestPath(pq.getPublication().getId(),currentSection);
		currentSection = pq.getPublication().getSection();
		
		return pq.getPublication().getId();
	}
	
	/* 
	 * Method for borrowing a movie on a BlueRay from the Library.  
	 * 
	 * Args:
	 * int client id	 
	 * String title of the magazine 
	 * int year of the publication 
	 * 
	 * Returns:
	 * int ID of the BlueRay 
	 */ 
	@Override
	public int borrowBlueRay(int client, String title, int yearOfPublication) {
		Client c = checkClient(client);
		if (c == null) {
			// There is no client with the specified clientID.
			return -1;
		}
		PublicationQueue pq = checkPublications(bluerays, "BlueRay" , null, title, yearOfPublication, 0);
		if (pq == null) {
			// There is no Blue-Ray with the specified title and issue and yearofPublication.
			return -1;
		}
		pq.borrowPublication(c);
		
		findShortestPath(pq.getPublication().getId(),currentSection);
		currentSection = pq.getPublication().getSection();
		
		return pq.getPublication().getId();
	}
	
	/* 
	 * Method for borrowing a CD from the library.  
	 * 
	 * Args:
	 * int client id 
	 * String author's name 
	 * String title of the CD 
	 *  
	 * Returns:
	 * int ID of the CD 
	 */ 
	@Override
	public int borrowCD(int client, String author, String title) {
		Client c = checkClient(client);
		if (c == null) {
			// There is no client with the specified clientID.
			return -1;
		}
		PublicationQueue pq = checkPublications(cds, "CD" , author, title, 0, 0);
		if (pq == null) {
			// There is no CD with the specified author and title.
			return -1;
		}
		pq.borrowPublication(c);
		
		findShortestPath(pq.getPublication().getId(),currentSection);
		currentSection = pq.getPublication().getSection();
		
		return pq.getPublication().getId();
	}
	
	/* 
	 * Method to return the publication back to the library.  
	 * 
	 * Args:
	 * int publicationID unique id of the publication.
	 * 
	 * Returns:
	 * int client ID of the next client the waiting list that borrowed the publication.Return -1 if no client was waiting.  
	 */ 
	@Override
	public int returnItem(int publicationID) {
		
		// Initializing the PublicationQueue.
		PublicationQueue pq = null;
		
		pq = checkReturnList(books, publicationID,pq);
		pq = checkReturnList(magazines, publicationID,pq);
		pq = checkReturnList(bluerays, publicationID,pq);
		pq = checkReturnList(cds, publicationID,pq);
			
		if (pq == null) {
			// Unable to find a publication with the specified ID.
			return -1;
		}
		
		Client nextClient = pq.returnPublication();
		return nextClient == null?-1:nextClient.getId();
	}
	
	/******************************************** end of PART 2 ***************************************************/ 

	/******************************************** PART 3 ***************************************************/
	
	/*
	 * Method to add a section of publications/media to the system
	 *   
	 * @param name of the section 
	 */	
	@Override
	public void addSection(String name) {
		
		Graph.Node node = new Graph.Node(name);
		libLayout.addNode(node);
		
	}
	
	/*
	 * Method to Connect two sections in the library that are directly connected
	 * 
	 * @param section1 the section to be connected to section2
	 * @param section2 the section to be connected to section1
	 */
	@Override
	public void connectSections(String section1, String section2) {
		
		libLayout.addEdge(section1, section2, sectionDistance);
	}
	
	/*
	 * Method to find and print the shortest path from the starting section
	 * to the section where the publication is located.
	 * 
	 * @param publicationID
	 * @param startSection
	 * 
	 */
	@Override
	public void findShortestPath(int publicationID, String startSection) {
		
		Publications pub = (Publications) publicationMapping.find(publicationID);
		String endSection = pub.getSection();
		
		//get shortest path
		
		Graph.Node endNode = libLayout.findNode(endSection);
		Graph.Node currentNode = libLayout.findNode(startSection);
		
		int shortestDistance = 0; 
		
		Vector path = libLayout.findPath(currentNode.getLabel(), endNode.getLabel());
		
		// calculating shortest distance by edges count (nodes-1) multiplied by fixed distance between nodes (i.e. 10) 
		shortestDistance = (path.size() - 1) * 10;
		
		System.out.println("Shortest distance from " + startSection + " to " + endSection + " is " + shortestDistance);
		
	}
	
	/******************************************** end of PART 3 ***************************************************/
	
	/******************************************** HELPER FUNCTIONS ************************************************/
	
	/* 
	 * Helper Function to iterate through the Return List of the publications given the publicationID to check the availability.  
	 * 
	 * Args:
	 * Vector vec the vector array of the different publications.
	 * int publicationID unique id of the publication.
	 * PublicationQueue pq to store the retrieved publication
	 * 
	 * Returns:
	 * PublicationQueue pq   
	 */ 
	public PublicationQueue checkReturnList(Vector vec, int pubID, PublicationQueue pq) {
		int nrPub = vec.size();
		for (int i =0; i <nrPub; i++) {
			PublicationQueue pq1 = (PublicationQueue) vec.get(i);
			if(pq1.getPublication().getId() == pubID) pq = pq1;
		}
		return pq;	
	}
	
	/* 
	 * Helper Function for iterating through the list of client and finding them based on their ID.  
	 * 
	 * Args:
	 * int client id
	 * 
	 * Returns:
	 * int c The client if the ID is present in the data.
	 */ 
	public Client checkClient(int clientID) {
		Client c = null;
		int nrClients = clients.size();
		for (int i=0;i<nrClients;i++) {
			Client c1 = (Client)clients.get(i);
			if (clientID == c1.getId()) {
				c = c1;
			}
		}
		return c;
	}
	
	/* 
	 *Helper function for iterating through the list of publications and check if it is present based in conditions.  
	 * 
	 * Args:
	 * Vector vec the publicationQueue of the different Publications
	 * String pubType the type of publication
	 * String author
	 * String title
	 * int yearOfPub
	 * int issue
	 * 
	 * Returns:
	 * PublicationQueue pq after checking the conditions and if the data is present.
	 */ 
	public PublicationQueue checkPublications(Vector vec, String pubType, String author, String title, int yearOfPub, int issue) {
		PublicationQueue pq = null;
		int nrPublication = vec.size();
		for (int i=0;i<nrPublication;i++) {
			PublicationQueue pq1 = (PublicationQueue)vec.get(i);
			
			if (pubType == "Book") {
				Book b = (Book)pq1.getPublication();
				if (b.author == author && b.getTitle() == title) {
					pq = pq1;
				}
			}
			else if (pubType == "Magazine") {
				Magazine m = (Magazine)pq1.getPublication();
				if (m.getYearOfPublication() == yearOfPub && m.getTitle() == title && m.issue == issue) {
					pq = pq1;
				}
			}
			else if (pubType == "BlueRay") {
				BlueRay br = (BlueRay)pq1.getPublication();
				if (br.getTitle() == title && br.getYearOfPublication() == yearOfPub) {
					pq = pq1;
				}
			}
			else if (pubType == "CD") {
				CD cd = (CD)pq1.getPublication();
				if (cd.getTitle() == title && cd.author == author) {
					pq = pq1;
				}
			}
		}
		return pq;
	}
	
	/******************************************** END OF HELPER FUNCTIONS ************************************************/
}

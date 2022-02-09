/*
* Main.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Main method to check all the implemented methods in the LibraryManagement.
* 
*
*/

public class Main {

	public static void main(String[] args) {
		
		// Creating a new instance of the LibraryManagement.
		ILibraryManagement management = new LibraryManagement();
		
		management.addSection("Book-Section");
		management.addSection("Magazine-Section");
		management.addSection("BlueRay-Section");
		management.addSection("CD-Section");
		
		
		// creating bi-directional path between sections
		management.connectSections("Book-Section", "Magazine-Section");
		management.connectSections("Magazine-Section", "Book-Section");
		
		management.connectSections("Magazine-Section", "BlueRay-Section");
		management.connectSections("BlueRay-Section", "Magazine-Section");
		
		management.connectSections("BlueRay-Section", "CD-Section");
		management.connectSections("CD-Section", "BlueRay-Section");
		
		management.connectSections("CD-Section", "Book-Section");
		management.connectSections("Book-Section", "CD-Section");
		
		management.connectSections("Book-Section", "BlueRay-Section");
		management.connectSections("BlueRay-Section", "Book-Section");
		
		management.connectSections("Magazine-Section", "CD-Section");
		management.connectSections("CD-Section", "Magazine-Section");
		
		
		// To add Publications to the Library.
		int blueRayId0 = management.addBlueRay("Titanic", 1998, "BlueRay-Section");
		int bookId0 = management.addBook("O'Reilly", "Scikit", 2000, "Book-Section");
		int cdId0 = management.addCD("Eminem", "Relapse", 2001,"CD-Section");
		int magId0 = management.addMagazine("Vogue", 2020, 4,"Magazine-Section");
		
		// To check the Unique Id of the publications added to the library.
		System.out.println("Publication IDs");
		System.out.println("Book's unique ID: "+bookId0);
		System.out.println("CD's unique ID: "+cdId0);
		System.out.println("BlueRay's unique ID: "+blueRayId0);
		System.out.println("Magazine's unique ID: "+magId0);
		System.out.println();
		
		// To add new Clients to the Library.
		int MathewId = management.addClient("Mathew", "m@gmail.com");
		int BartId = management.addClient("Bart", "b@gmail.com");
		int VictorId = management.addVIPClient("Victor", "v@gmail.com");
		int PieterId = management.addVIPClient("Pieter", "p@gmail.com");
		
		// To print the Unique ID's of the Clients.
		System.out.println("Client IDs");
		System.out.println("Mathew: "+MathewId);
		System.out.println("Victor: "+VictorId);
		System.out.println("Pieter: "+PieterId);
		System.out.println("Bart: "+BartId);
		System.out.println();
		
		//To print all the publications and the Clients
		System.out.println("Publications:");
		management.printAllPublications();
		System.out.println("\nClients:");
		management.printAllClients();
		System.out.println();
		
		// Checking the borrow method for the above mentioned clients.
//		management.borrowBlueRay(MathewId, "Titanic", 1998);
//		management.borrowBlueRay(BartId, "Titanic", 1998);
//		management.borrowBlueRay(VictorId, "Titanic", 1998);
//		management.borrowBlueRay(PieterId, "Titanic", 1998);
		
		management.borrowBook(MathewId, "O'Reilly", "Scikit");
		management.borrowBook(BartId, "O'Reilly", "Scikit");
		management.borrowBook(VictorId, "O'Reilly", "Scikit");
		management.borrowBook(PieterId, "O'Reilly", "Scikit");
		
//		// Printing the client's waiting list to check if the priority is given properly. 
		System.out.println("Waiting List");
		System.out.println("Next in Line:"+ management.returnItem(bookId0));
		System.out.println("Next in Line:"+ management.returnItem(bookId0));
		System.out.println("Next in Line:"+ management.returnItem(bookId0));
		System.out.println("Next in Line:"+ management.returnItem(bookId0));
		

	}

}

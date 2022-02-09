/*
* PublicationQueue.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* PublicationQueue object handles the borrowing and returning functionality of the publications to the Library.
* 
*
*/

// Base Class
public class PublicationQueue {
	final Publications p;
	Client c;
	final DoubleLinkedList normalClientQueue = new DoubleLinkedList();
	final DoubleLinkedList vipClientQueue = new DoubleLinkedList();
	
	public PublicationQueue(Publications p) {
		this.p = p;
	}
	
	public String toString() {
		return p.toString();
	}
	
	// Method to borrow the Publication and map it with the respective client and add him/her to theie respective Queues.
	public void borrowPublication(Client c) {
		if (this.c == null) {
			this.c = c;
		} else {
			if (c instanceof NormalClient) {
				normalClientQueue.AddLast(c);
			} else {
				vipClientQueue.AddLast(c);
			}
		}
	}
	
	// Method to return the publication borrowed back to the Library, but also takes into the condition that the VIP client must be given higher priority in the waiting list.
	public Client returnPublication() {
		if (!vipClientQueue.isEmpty()) {
			c =  (Client)vipClientQueue.getFirst();
			vipClientQueue.removeFirst();
		} else if(!normalClientQueue.isEmpty()) {
			c =  (Client)normalClientQueue.getFirst();
			normalClientQueue.removeFirst();
		} else {
			c = null;
		}
		return c;
	}
	
	// Method to get the required publication.
	public Publications getPublication() {
		return p;
	}
	
}

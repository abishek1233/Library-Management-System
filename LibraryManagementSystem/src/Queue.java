/*
* Queue.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Queue object with Vector which has all the methods of the data-structure.
* 
*
*/

public class Queue {
	
	private Vector data;
	
	public Queue(int capacity) {
		data = new Vector(capacity);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public void pop() {
		data.get(data.size()-1);
		data.removeLast();
	}

	public Object top() {
		 return data.getLast();
	}

	public int size() {
		return data.size();
		
	}

	public boolean empty() {
		return data.isEmpty();
	}
}

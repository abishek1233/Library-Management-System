/*
* Stack.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Stack object with Vector which has all the methods of the data-structure.
* 
*
*/

public class Stack{
	
	private Vector data;

	public Stack(int size) {
		data = new Vector(size);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public Object pop() {
		Object o = data.getFirst();
		data.removeFirst();
		return o;
	}

	public Object top() {
		return data.get(data.size()-1);
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		return data.isEmpty();
	}


}

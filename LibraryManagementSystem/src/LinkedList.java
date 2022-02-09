/*
* LinkedList.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* LinkedList object with all the methods of the data-structure.
* 
*
*/

public class LinkedList {
	
	private class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}

		public Object first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Object value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Object o) {
		head = new ListElement(o, head);
	}
	
	public Object getFirst() {
		return head.first();
	}

	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += " " + d.first().toString();
			d = d.rest();
		}
		s += " )";
		return s;
	}

	
	public int size() {
		int length = 0;
		ListElement d = head;
		while(d != null) {
			length++;
			d = d.rest();
		}
		return length;
	}
	
	public void set(int n, Object o) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);
	}
	
	public Object getLast() {
		ListElement d = head;
		if (d == null) return null;
		while(d.rest()!= null) {
			d = d.rest();
		}
		return d.first();
	}
	
	public void addLast(Object o) {
		ListElement d = head;
		if (d == null) {
			head = new ListElement(o);
			return;
		}
		while(d.rest()!= null) {
			d = d.rest();
		}
		d.setRest(new ListElement(o));
	}
	
	public Object find(Object obj) {
		ListElement d = head;
		if (d == null) return null;
		while(d.rest()!= null) {
			if (d.first() == obj) return obj;
			d = d.rest();
		}
		return null;
	}
	
	public void append(LinkedList list2) {
		if (list2.head == null) return;
		ListElement tail = new ListElement(list2.head.first());
		ListElement d = head;
		if (d == null) {
			head = tail;
		} else {
			while(d.rest()!= null) {
				d = d.rest();
			}
			d.setRest(tail);
		}
		ListElement list2El = list2.head;
		while (list2El.rest() != null) {
			list2El = list2El.rest();
			ListElement newTail = new ListElement(list2El.first());
			tail.setRest(newTail);
			tail = newTail;
		}
	}
	

}
	



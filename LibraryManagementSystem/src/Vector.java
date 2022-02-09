/*
* Vector.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Vector object with all the methods of the data-structure.
* 
*
*/

public class Vector 
{
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}


	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return data[index];
	}

	public void set(int index, Object obj)
	{
		while (index < data.length) {
			this.extendCapacity();
		}
		data[index] = obj;
		if (index > count) {
			count = index+1;
		}
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		if (count == data.length) {
			this.extendCapacity();
		}
		for(int i=count-1;i>=0;i--){
			data[i+1]=data[i];
		}
		data[0]=item;
		count++;
	}

	public void addLast(Object o)
	{
		if (count == data.length) {
			this.extendCapacity();
		}
		data[count] = o;
		count++;
	}

	public String toString () {
		String out = "[";
		for (int i = 0; i < count; i++) {
			if (data[i] != null) {	
				out += " " + data[i].toString();
			}
		}
		out += " ]";
		return out;	
	}
	

	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		return data[0];
	}

	public Object getLast()
	{
		return data[count-1];
	}

	public void removeLast()
	{
		data[count-1] = null;
		count --;
	} 

	public void removeFirst()
	{
		for(int i=0;i<=count;i++){
			data[i]=data[i+1];
		}
		this.count--;
	}

	public void reverse()
	{
		Object temp;
		for(int i=0;i<count/2;i++){
			temp = data[i];
			data[i] = data[count-i-1];
			data[count-i-1]= temp;	
		}
	}

	public Vector repeat()
	{
		return this.interleave(this);
	}

	public Vector interleave(Vector v2)
	{
		Vector vec1 = new Vector(count+v2.count);
		int maxCount = count > v2.count ? count : v2.count;
		for(int i=0;i<maxCount;i++){
			if (i < count) vec1.addLast(data[i]);
			if (i < v2.count) vec1.addLast(v2.data[i]);
		}
		return vec1;	
	}

	private void extendCapacity() {
		Object [] data2 = new Object[2*count];
		for (int i = 0; i < count; i++) {
			data2[i] = data[i]; 
		}
		data = data2;
	}
	
}

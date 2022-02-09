/*
* Dictionary.java
* Abhisheik Krishnagiri Tupil Ravikanth
* 18/12/2021
*
* Dictionary object which implements all the methods of the data-structure.
* 
*
*/

public class Dictionary {
	
	@SuppressWarnings("rawtypes")
	private class DictionaryPair implements Comparable {
		private Object key;
		private Object value;
        
		public DictionaryPair(Object key, Object value) {
			this.key=key;
			this.value=value;
		}

		public Object getKey() {
			return this.key;
		}

		@SuppressWarnings("unused")
		public void setKey(Object key) {
			this.key=key;
		}
		public Object getValue() {
			return this.value;
		}

		@SuppressWarnings("unused")
		public void setValue(Object value) {
			this.value=value;
		}

		public int compareTo(Object o) {
			DictionaryPair dp= (DictionaryPair)o;
			return (((Dictionary.DictionaryPair) key).compareTo(dp.key));
		}

	}

	private Vector data;

	public Dictionary() {
		data= new Vector(10);
	}

	public void add(Object key, Object value) {
		DictionaryPair myPair = new DictionaryPair(key, value);
		if(findPosition(key)==-1) {
			data.addLast(myPair);	
		}
		else {
			
		}
	}

	public int findPosition(Object key) {
		int position=0;
		if(data.contains(key)==true) {
			while(data != key) {
				position++;
			}
			return position-1;
		}
		else {
			return -1;
		}
	}

	public Object find(Object key) {
		for(int i=0; i<data.size();i++) {
			DictionaryPair temp = (DictionaryPair)data.get(i);
			if(temp.getKey() == key) {
				Object val = (Object)temp.getValue();
				return val;
			}
			
		}
		return null;
	}
	
	public void removeKey(Object key){
		for(int i=0;i<data.size();i++) {
			DictionaryPair temp=(DictionaryPair)data.get(i);
			if(temp.getKey()==key) {
				if(i!=data.size()-1) {
					for(int j=i; j<data.size()-1;j++) {
						  data.set(j, data.get(j+1)); 
					}
					data.removeLast();
				}
				else {
					data.removeLast();
				}
			  
			}
		}

	}
	
	public int size(){
		return data.size();
	}
	public String toString() {
		String s=" ";
		for  (int i=0; i < data.size(); i++) 
		{
			DictionaryPair temp=(DictionaryPair)data.get(i);
			s = s + temp.getKey()+ " "+temp.getValue()+" ";
		}
		return s;
	}
}

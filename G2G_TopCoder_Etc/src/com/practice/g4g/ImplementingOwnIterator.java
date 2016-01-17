package com.practice.g4g;

public class ImplementingOwnIterator {

}	

/*	import java.util.ArrayList;
	import java.util.Iterator;

	public class A<Item> implements Iterator<Item> {

		private ArrayList<?> b;
		private int position;

		public A(B b) {
			this.b = b.getB();
		}

		@Override
		public boolean hasNext() {
			if (position < b.size())
				return true;
			else
				return false;
		}

		@Override
		public Object next() {
			Object aniObj = b.get(position);
			position++;
			return aniObj;
		}

		@Override
		public void remove() {
			b.remove(position);
		}

	}



	import java.util.ArrayList;
	import java.util.Iterator;

	public class B implements Iterable<Item> {

		private ArrayList<String> b = new ArrayList<String>();

		public B(ArrayList b){
			this.b = b;
		}

		public ArrayList getB() {
			return b;
		}

		@Override
		public Iterator<String> iterator() {
			return new A(this);
		}

	}
*/	

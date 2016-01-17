package com.practice.g4g;

import java.util.Iterator;

public class RepeatObjNTimeReturningIterator {
	
	
	public static <T> Iterator<T> repeat(T e, int num) {
		final T t = e;
		final int number = num;
		return new Iterator<T>() {
			private T object = t;

			private int repeatNumber = number;
			private int counter = 0;

			@Override
			public boolean hasNext() {
				return counter < repeatNumber;
			}

			@Override
			public T next() {
				counter++;
				return object;
			}

			@Override
			public void remove() {
				repeatNumber--;

			}
		};
		}

		public static void main(String[] args) {
		Iterator<String> iter = repeat("Test repeater", 7);
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
		}

}
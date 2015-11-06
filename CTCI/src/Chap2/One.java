package Chap2;

import java.util.HashMap;
import java.util.Map;

import com.linkedlists.CustomLinkedList;
import com.linkedlists.LLNode;

public class One {
	public static void main(String[] args) {
		
		CustomLinkedList ll = new CustomLinkedList();
		LLNode head = ll.createTestSet1();
		ll.printLL(head);
		/*Map<Integer, Integer> myMap = new HashMap<>();
		myMap.put(1, 1);
		myMap.put(2, 1);
		myMap.put(3, 1);
		myMap.put(4, 1);
		
		if(myMap.containsKey(5)) {
			System.out.println("yes it's there");
		}*/
	}
}

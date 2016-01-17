package revision;

import com.linkedlists.*;

public class ReverseLLRecursive {
	
	public static void main(String[] args) {
		CustomLinkedList c = new CustomLinkedList();
		LLNode ll = c.createTestSet1();
		c.printLL(ll);
		System.out.println();
		LLNode llReverse = reverse(ll);
		c.printLL(llReverse);
	}

	public static LLNode reverse(LLNode ll) {
		
		if(ll.next==null) return ll;
		
		LLNode temp = reverse(ll.next);
		
		LLNode curr = temp;
		while(curr.next!=null) {
			curr = curr.next;			
		}
		
		curr.next = ll;
		ll.next = null;
		return temp;
	}
}

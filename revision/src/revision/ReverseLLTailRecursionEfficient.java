package revision;

import com.linkedlists.CustomLinkedList;
import com.linkedlists.LLNode;

public class ReverseLLTailRecursionEfficient {
	
	public static void main(String[] args) {
		CustomLinkedList c = new CustomLinkedList();
		LLNode ll, llReverse;
		
		ll= null;
		
		ll = c.createTestSetWithLengthNull();
		c.printLL(ll);
		llReverse = reverse(ll, null);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength1();
		c.printLL(ll);
		llReverse = reverse(ll, null);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength2();
		c.printLL(ll);
		llReverse = reverse(ll, null);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength3();
		c.printLL(ll);
		llReverse = reverse(ll, null);
		c.printLL(llReverse);
	}

	public static LLNode reverse(LLNode ll, LLNode previous) {
		
		if(ll == null) return ll; //handles length=null case, i.e. empty list
		if(ll.next == null) {
			ll.next = previous;
			return ll;
		}
		
		LLNode next = ll.next;
		ll.next = previous;
		
		return reverse(next, ll);
	}

}

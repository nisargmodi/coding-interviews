package revision;

import com.linkedlists.*;

public class ReverseLLRecursive {
	
	public static void main(String[] args) {
		CustomLinkedList c = new CustomLinkedList();
		LLNode ll, llReverse;
		
		ll= null;
		
		ll = c.createTestSetWithLengthNull();
		c.printLL(ll);
		llReverse = reverse(ll);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength1();
		c.printLL(ll);
		llReverse = reverse(ll);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength2();
		c.printLL(ll);
		llReverse = reverse(ll);
		c.printLL(llReverse);
		
		ll = c.createTestSetWithLength3();
		c.printLL(ll);
		llReverse = reverse(ll);
		c.printLL(llReverse);
	}

	public static LLNode reverse(LLNode ll) {
		
		if(ll == null) return null; //handles length=null case, i.e. empty list
		
		if(ll.next==null) return ll; //handles length=1 case
		
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

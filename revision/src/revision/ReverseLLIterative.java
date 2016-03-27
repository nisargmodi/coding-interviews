package revision;

import com.linkedlists.*;

public class ReverseLLIterative{
	
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
		
		LLNode head = ll;
		LLNode curr = head.next;
		LLNode next = null;
		
		if(curr!=null) next = curr.next; //handles length=1 case;
		
		head.next = null;
		while(curr!=null) {
			curr.next = head;
			head = curr;
			curr = next;
			if(curr!=null) //handles length=2 case and in general when curr-reaches-beyond-the-last-element case.
			next = curr.next;
		}
		return head;
	}
}
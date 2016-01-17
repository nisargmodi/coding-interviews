package revision;

import com.linkedlists.*;

public class ReverseLLIterative{
	
	public static void main(String[] args) {
		CustomLinkedList c = new CustomLinkedList();
		LLNode ll = c.createTestSet1();
		c.printLL(ll);
		LLNode llReverse = reverse(ll);
		c.printLL(llReverse);
	}

	public static LLNode reverse(LLNode ll) {
		LLNode prev = ll;
		LLNode curr = prev.next;
		LLNode next = curr.next;
		
		prev.next = null;
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if(curr!=null)
			next = curr.next;
		}
		return prev;
	}
}
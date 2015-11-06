package Chap2;

import com.linkedlists.CustomLinkedList;
import com.linkedlists.LLNode;

public class Five {
	public static void main(String[] args) {
		CustomLinkedList ll = new CustomLinkedList();
		LLNode head1 = ll.createTestSet();
		
		LLNode head2 = ll.createTestSet2();
		
		/*ll.printLL(head1);
		System.out.println("Second:");
		ll.printLL(head2);*/
		
		ll.printLL(calculateSum(head1, head2));
	}

	private static LLNode calculateSum(LLNode head1, LLNode head2) {
		int carrier = 0;
		LLNode headfinal = new LLNode();
		LLNode head3 = headfinal;
		while(head1!=null && head2!=null) {
			headfinal.next = new LLNode();
			headfinal = headfinal.next;
			headfinal.data=(head1.data + head2.data + carrier)%10;
			carrier = (head1.data + head2.data + carrier)/10;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(head1!=null || head2!=null) {
			while(head1!=null) {
				headfinal.next = new LLNode();
				headfinal = headfinal.next;
				headfinal.data=(head1.data + carrier)%10;
				carrier = (head1.data + carrier)/10;
				head1 = head1.next;
			}
			
			while(head2!=null) {
				headfinal.next = new LLNode();
				headfinal = headfinal.next;
				headfinal.data=(head2.data + carrier)%10;
				carrier = (head2.data + carrier)/10;
				head2 = head2.next;
			}
		}
		if(carrier!=0) {
			headfinal.next = new LLNode();
			headfinal = headfinal.next;
			headfinal.data = carrier;
		}
		return head3.next;
	}
	
	

}

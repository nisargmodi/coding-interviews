package com.linkedlists;

public class CustomLinkedList {
	public LLNode createTestSet1() {
		
		LLNode ll = new LLNode();
		LLNode head = ll;
		//creating test set
		int i=0;
		while(i<7) {
			ll.next = new LLNode();
			ll = ll.next;
			ll.data = 2*i;
			i++;
		}
		
		return head.next;
	}
	
	public LLNode createTestSet2() {
		
		LLNode ll = new LLNode();
		LLNode head = ll;
		//creating test set
		int i=0;
		while(i<5) {
			ll.next = new LLNode();
			ll = ll.next;
			ll.data = 3*i;
			i++;
		}
		
		return head.next;
	}
	
	public void printLL(LLNode head) {
		while (head != null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
		
		System.out.println();
	}

}

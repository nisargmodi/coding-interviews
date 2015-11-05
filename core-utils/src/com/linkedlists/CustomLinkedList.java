package com.linkedlists;

public class CustomLinkedList {
	public LLNode createTestSet() {
		
		LLNode ll = new LLNode();
		LLNode head = ll;
		//creating test set
		int i=0;
		while(i<3) {
			ll.next = new LLNode();
			ll = ll.next;
			ll.data = i+1;
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
			ll.data = i+5;
			i++;
		}
		
		return head.next;
	}
	
	public void printLL(LLNode head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

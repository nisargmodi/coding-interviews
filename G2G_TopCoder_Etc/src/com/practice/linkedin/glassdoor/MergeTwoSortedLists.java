package com.practice.linkedin.glassdoor;

import com.linkedlists.CustomLinkedList;
import com.linkedlists.LLNode;

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		
		CustomLinkedList ll = new CustomLinkedList();
		LLNode head1 = ll.createTestSet1();
		LLNode head2 = ll.createTestSet2();
		
		ll.printLL(merge(head1, head2));
	}

	private static LLNode merge(LLNode head1, LLNode head2) {
		
		LLNode head = new LLNode();
		if(head1.data<head2.data) {
			head = head1;
		}
		else head = head2;
		
		while(head1!=null && head2!=null) {
			
			LLNode prev1 = head1;
			LLNode prev2 = head2;
			
			while(head1!=null && head1.data<head2.data) {
					prev1 = head1;
					head1 = head1.next;
				}
			if(prev1 != head1) {
				prev1.next = head2;
			}
			
			while(head1!=null && head2.data<head1.data) {
					prev2 = head2;
					head2 = head2.next;
				}
			if(prev2 != head2) {
				prev2.next = head1;
			}
		}
		return head;
	}	

}

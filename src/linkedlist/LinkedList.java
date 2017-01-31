package linkedlist;

import java.util.NoSuchElementException;

import linkedlist.LinkedList.MyIterator;

public class LinkedList {

	ListNode head;

	public ListNode insert(int data) {

		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		return head;
	}

	public ListNode appendToTail(ListNode data) {

		if (head == null) {
			head = data;
		} else {
			ListNode current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = data;
		}
		return head;
	}

	public void delete(int data) {
		if (head == null) {
			return;
		} else if (head.data == data) {
			head = head.next;
		} else {
			ListNode prev = null;
			ListNode current = head;

			boolean isFound = false;
			while (current != null) {
				prev = current;
				current = current.next;
				if (current.data == data) {
					isFound = true;
					break;
				}
			}

			if (isFound) {
				prev.next = prev.next.next;
				// prev.next = current.next;
			}
		}
	}

	public void printList() {

		if (head == null) {
			return;
		}
		ListNode current = head;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println();
	}

	public MyIterator getIterator() {
		return new MyIterator();
	}

	public class MyIterator implements ListIterable {

		ListNode current;

		public MyIterator() {
			current = null;
		}

		@Override
		public boolean hasNext() {
			if (current == null) {
				return head != null;
			} else {
				return current.next != null;
			}
		}

		@Override
		public ListNode next() {

			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			if (current == null) {
				current = head;
			} else {
				current = current.next;
			}
			return current;
		}

	}

	public static void main(String args[]) {

		LinkedList list1 = new LinkedList();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);
		head1.next.next.next.next = new ListNode(9);

		list1.head = head1;

		MyIterator it = list1.getIterator();

		while (it.hasNext()) {
			ListNode temp = it.next();
			System.out.print(temp + " ");
		}
	}
}

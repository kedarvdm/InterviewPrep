package linkedlist;

public class MergeTwoSortedLinkedLists {

	public static void main(String args[]) {
		// 1->3->5->7->9
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);
		head1.next.next.next.next = new ListNode(9);

		// 2->4->6->8
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(8);

		ListNode merged = mergeList(head1, head2);
		ListNode current = merged;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public static ListNode mergeList(ListNode list1, ListNode list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.data < list2.data) {
			list1.next = mergeList(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeList(list2.next, list1);
			return list2;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newhead = new ListNode(0);
		ListNode current = newhead;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}

		if (p1 != null) {
			current.next = p1;
		}

		if (p2 != null) {
			current.next = p2;
		}

		newhead = newhead.next;
		return newhead;
	}
}

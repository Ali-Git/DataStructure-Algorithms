package linked_list.delete.great;
// Delete nodes having greater value on right
import java.util.Scanner;
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class LinkedList {

	Node head;

	/* Linked list Node */
	/* Utility functions */
	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		/*
		 * Constructed Linked List is 1.2.3.4.5.6. 7.8.8.9.null
		 */
		int value;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0 && sc.hasNextInt()) {
			int n = sc.nextInt();
			LinkedList llist = new LinkedList();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n && sc.hasNextInt(); i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			new GfG().compute(llist);
			llist.printList();
			t--;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * class Node { int data; Node next; Node(int data) { this.data = data; } }
 * public class LinkedList { Node head; // Member Methods }
 */
/*
 * This is method only submission. You only need to complete the below method.
 */
class GfG {
	void compute(LinkedList l) {
		boolean flag = true;
		Node head = l.head;
		Node last = null;
		while (head != null) {
			Node temp = head.next;
			head.next = last;
			last=head;
			head = temp;
		}
		head=last;
		while(head!=null) {
			while(head.next!=null && head.data>head.next.data) {
				head.next=head.next.next;
			}
			head=head.next;
		}
		//System.out.println(last);
		head=last;
		last=null;
		while (head != null) {
			Node temp = head.next;
			head.next = last;
			last=head;
			head = temp;
		}
		l.head=last;
		/*
		 * Node temp=head; while (temp != null) { System.out.print(temp.data + " ");
		 * temp = temp.next; } System.out.println();
		 */
	}
}
/*
Input:
3
8
12 15 10 11 5 6 2 3
6
10 20 30 40 50 60
6
60 50 40 30 20 10

Output:
15 11 6 3
60
60 50 40 30 20 10

Explanation:
Testcase 1: Since, 12, 10, 5 and 2 are the elements which have greater elements on their next node. So, after deleting them, the linked list would like be 15, 11, 6, 3.
*/

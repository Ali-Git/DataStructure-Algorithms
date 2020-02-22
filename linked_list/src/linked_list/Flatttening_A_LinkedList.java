package linked_list;

import java.util.Scanner;

class Node {
	int data;
	Node next;
	Node bottom;

	Node(int d) {
		data = d;
		next = null;
		bottom = null;
	}
}

public class Flatttening_A_LinkedList {
	Node head;

	void printList(Node node) {
		// Node temp = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.bottom;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while (t > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;
			int flag = 1;
			int flag1 = 1;
			for (int i = 0; i < N; i++) {
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if (flag == 1) {
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				} else {
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}

				for (int j = 0; j < m; j++) {
					int a = sc.nextInt();
					tempB = new Node(a);
					if (flag1 == 1) {
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					} else {
						preB.bottom = tempB;
						preB = tempB;
					}
				}

			}
			// list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);

			t--;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Node class used in the program class Node { int data; Node next; Node bottom;
 * 
 * Node(int d) { data = d; next = null; bottom = null; } }
 */
/*
 * Function which returns the root of the flattened linked list.
 */
class GfG {
	Node flatten(Node root) {
		Node head = root;
		Node h_root = root;
		Node v_root = root;
		while (h_root != null && h_root.next != null) {
			h_root = h_root.next;
			Node h_bottom = h_root;
			while (v_root != null && h_bottom!=null) {
				if (v_root.data >= h_bottom.data) {
					Node temp = v_root;
					v_root = new Node(h_bottom.data);
					v_root.bottom = temp;
					head = v_root;
					h_bottom = h_bottom.bottom;
				} else if (v_root.bottom != null && v_root.data < h_bottom.data && v_root.bottom.data >= h_bottom.data) {
					Node temp = v_root.bottom;
					v_root.bottom = new Node(h_bottom.data);
					v_root.bottom.bottom = temp;
					h_bottom = h_bottom.bottom;
				} else {
					if(v_root.bottom==null && h_bottom!=null) {
						v_root.bottom = new Node(h_bottom.data);
						h_bottom = h_bottom.bottom;
					}
					v_root = v_root.bottom;
				}
			}
			v_root = head;
		}
		return v_root;
	}
}

/*
 Input:
1                   
4 
4 2 3 4                  
5 7 8 30 10 20 19 22 50 28 35 40 45

Output:
5 7 8 10 19 20 22 28 30 35 40 45 50
 */

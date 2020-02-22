package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Leftmost and rightmost nodes of binary tree
// https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1
class Node {
	int data;
	Node left, right;

	Node(int key) {
		data = key;
		left = right = null;
	}
}

public class LeftAndRightBothView {
	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}

			GfGLRView gfg = new GfGLRView();
			gfg.printCorner(root);
			System.out.println();
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Node class of the binary tree class Node { int data; Node left, right;
 * Node(int key) { data = key; left = right = null; } }
 */
class GfGLRView {
	public static void printCorner(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		Node tempPop = null;
		while (!queue.isEmpty()) {
			Node popNode = queue.poll();
			if (popNode == null) {
				if (queue.peek() != null)
					queue.add(null);
			} else {
				Node left = popNode.left;
				Node right = popNode.right;
				if (left != null)
					queue.add(left);
				if (right != null)
					queue.add(right);
			}
			if (popNode != null && queue.peek() == null || tempPop == null)
				System.out.print(popNode.data + " ");
			tempPop = popNode;
		}
	}

}

/*
Input:
2
6
15 10 L 10 8 L 10 12 R 15 20 R 20 16 L 20 25 R
2
1 2 R 2 3 R

Output:
15 10 20 8 25
1 2 3

*/
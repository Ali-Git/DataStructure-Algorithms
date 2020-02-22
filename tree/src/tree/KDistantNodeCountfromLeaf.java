package tree;

import java.util.LinkedList;
import java.util.Queue;
//Initial Template for Java
import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int key) {
		data = key;
		left = right = null;
	}
}

public class KDistantNodeCountfromLeaf {
	static Node root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = null;
			for (int i = 0; i < n; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (root == null) {
					root = new Node(n1);
					switch (lr) {
					case 'L':
						root.left = new Node(n2);
						break;
					case 'R':
						root.right = new Node(n2);
						break;
					}
				} else {
					insert(root, n1, n2, lr);
				}

			}

			GfGKD gfg = new GfGKD();
			int k = sc.nextInt();
			System.out.println(gfg.printKDistantfromLeaf(root, k));

		}
	}

	public static void insert(Node root, int n1, int n2, char ch) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (ch) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, ch);
			insert(root.right, n1, n2, ch);
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
class GfGKD {

	public static int printKDistantfromLeaf(Node node, int k) {
		Node head = node;
		int h = height(node);
		//System.out.println(h);
		int l = h-k-1;
		int counter=0;
		int nodeCounter=0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node popNode = queue.poll();
			Node left=null;
			Node right=null;
			if(popNode==null) {
				counter++;
				Node peek=queue.peek();
				if(peek!=null) {
					queue.add(null);
				}
			}else {
				left = popNode.left;
				right = popNode.right;
				if(left!=null) queue.add(left);
				if(right!=null) queue.add(right);
			}
			if(counter==l && popNode!=null) nodeCounter++;
			if(counter>l) break;
		}
		//System.out.println(nodeCounter);
		return nodeCounter;
	}

	private static int height(Node node) {
		if (node == null)
			return 0;
		else {
			int lh = height(node.left) + 1;
			int rh = height(node.right) + 1;
			if (lh > rh)
				return lh;
			else
				return rh;
		}

	}

}

/*


Input:
1
7
1 2 L 2 4 L 2 5 R 1 3 R 3 6 L 6 8 R 3 7 R
2

1
5
1 3 L 3 5 L 5 7 L 5 8 R 8 9 R
4

Output:
2
1

*/
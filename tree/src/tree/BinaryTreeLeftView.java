package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// A Binary Tree node
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeLeftView {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root=null;
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}
			TreeBTLeftView g = new TreeBTLeftView();
			g.leftView(root);
			System.out.println();
			t--;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * A Binary Tree node class Node { int data; Node left, right; Node(int item) {
 * data = item; left = right = null; } }
 */
class TreeBTLeftView {
	void leftView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		System.out.print(root.data+" ");
		while(!queue.isEmpty()) {
			Node popNode = queue.poll();
			if(popNode==null) {
				Node peek=queue.peek();
				if(peek!=null) {
					System.out.print(peek.data+" ");
					queue.add(null);
				}
			}else {
				Node left = popNode.left;
				Node right = popNode.right;
				if(left!=null) queue.add(left);
				if(right!=null) queue.add(right);
			}
		}

	}
}
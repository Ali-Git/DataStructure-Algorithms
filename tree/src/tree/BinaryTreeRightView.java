package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeRightView {
	public static void insert(Node root, int n1, int n2, char lr) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, lr);
			insert(root.right, n1, n2, lr);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = Integer.parseInt(sc.next());
			Node root = null;

			while (n-- > 0) {
				int n1 = Integer.parseInt(sc.next());
				int n2 = Integer.parseInt(sc.next());
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
			TreeBTRightView tree = new TreeBTRightView();
			tree.rightView(root);
			System.out.println();

		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Complete The Function Provided Given Below is The Node Of Tree class Node {
 * int data; Node left, right; public Node(int data) { this.data = data; left =
 * right = null; } }
 */
class TreeBTRightView {
	void rightView(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node popNode = queue.poll();
			if(popNode==null) {
				if(queue.peek()!=null) {
					queue.add(null);
				}
			}else {
				if(queue.peek()==null) {
					System.out.print(popNode.data+" ");
				}
				Node left = popNode.left;
				Node right = popNode.right;
				if(left!=null) queue.add(left);
				if(right!=null) queue.add(right);
			}
		}

	}
}

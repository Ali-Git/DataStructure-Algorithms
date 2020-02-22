package tree;

// INITIAL CODE
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

// A Binary Tree node
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeBoundaryTraversal {
	int height(Node node) {
		if (node == null)
			return 0;
		int l = 1 + height(node.left);
		int r = 1 + height(node.right);
		if (l > r)
			return l;
		else
			return r;
	}

	// driver function to test the above functions
	public static void main(String args[]) {

		// Input the number of test cases you want to run
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
				// cout << n1 << " " << n2 << " " << (char)lr << endl;
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

			GfGBoundary g = new GfGBoundary();
			g.printBoundary(root);
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
class GfGBoundary {

	void printBoundary(Node root) {
		if (root == null)
			return;
		Stack<Integer> stack = new Stack<>();
		System.out.print(root.data + " ");
		leftBoundaryTraversal(root.left);
		leafBoundaryTraversal(root.left);
		leafBoundaryTraversal(root.right);
		rightBoundaryTraversal(root.right, stack);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void leftBoundaryTraversal(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		System.out.print(root.data + " ");
		if (root.left != null)
			leftBoundaryTraversal(root.left);
		else if (root.right != null) {
			leftBoundaryTraversal(root.right);
		}

	}

	private void leafBoundaryTraversal(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");
		leafBoundaryTraversal(root.left);
		leafBoundaryTraversal(root.right);

	}

	private void rightBoundaryTraversal(Node root, Stack<Integer> stack) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		stack.push(root.data);
		if (root.right != null)
			rightBoundaryTraversal(root.right, stack);
		else if (root.left != null) {
			rightBoundaryTraversal(root.left, stack);
		}
	}
}

/*
 * 
 * 1 7 20 8 L 20 22 R 8 4 L 8 12 R 12 10 L 12 14 R 22 25 R
 * 
 * Input: 
 1 
 6 
 1 2 R 2 4 R 4 5 R 5 6 R 6 7 R 7 8 L
 * 
 * Its Correct output is: 1 8 7 6 5 4 2
 * 
 * And Your Code's output is: 1 8 2 4 5 6 7
 * 
 */
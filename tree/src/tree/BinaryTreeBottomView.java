package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// Tree node class
class Node {
	int data; // data of the node
	int hd; // horizontal distance of the node
	Node left, right; // left and right references

	// Constructor of tree node
	public Node(int key) {
		data = key;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class BinaryTreeBottomView {
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

			Tree g = new Tree();

			// g.leftView(root);
			g.bottomView(root);

			System.out.println();
			t--;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Tree node class class Node { int data; //data of the node int hd;
 * //horizontal distance of the node Node left, right; //left and right
 * references public Node(int key) { data = key; hd = Integer.MAX_VALUE; left =
 * right = null; } }
 */
class Tree {

	private static int min = 0;
	private static int max = 0;

	public void bottomView(Node root) {
		Node head = root;
		min = 0;
		max = 0;
		findMinMax(root, 0);
		// System.out.println(min + " | " + max);
		Map<Integer, Node> map = new HashMap<>();
		prepareBottomViewNodeMap(head, map);
		for (int i = min; i <= max; i++) {
			Node temp = map.get(i);
			System.out.print(temp.data + " ");
		}
	}

	private static void findMinMax(Node root, int hd) {
		if (root == null)
			return;
		if (min > hd)
			min = hd;
		if (max < hd)
			max = hd;
		findMinMax(root.left, hd - 1);
		findMinMax(root.right, hd + 1);
	}

	private static void prepareBottomViewNodeMap(Node root, Map<Integer, Node> map) {

		Queue<Integer> hdQueue = new LinkedList<>();
		hdQueue.add(0);
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		map.put(0, new Node(root.data));
		while (!nodeQueue.isEmpty()) {
			Node polledNode = nodeQueue.poll();
			int hd = hdQueue.poll();
			Node leftNode = polledNode.left;
			Node rightNode = polledNode.right;
			if (leftNode != null) {
				map.put(hd - 1, new Node(leftNode.data));
				hdQueue.add(hd - 1);
				nodeQueue.add(leftNode);
			}
			if (rightNode != null) {
				map.put(hd + 1, new Node(rightNode.data));
				hdQueue.add(hd + 1);
				nodeQueue.add(rightNode);
			}
		}
	}
}
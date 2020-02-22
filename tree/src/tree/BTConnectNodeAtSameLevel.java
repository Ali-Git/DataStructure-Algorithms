package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Initial Template for Java
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class NodeSL {
	int data;
	NodeSL left, right, nextRight;

	NodeSL(int x) {
		this.data = x;
		left = right = nextRight = null;
	}

}

public class BTConnectNodeAtSameLevel {

	static void printSpecial(NodeSL root) {
		if (root == null)
			return;
		NodeSL node = root;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.nextRight;
		}
		if (root.left != null)
			printSpecial(root.left);
		else
			printSpecial(root.right);

	}

	static void inorder(NodeSL root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			HashMap<Integer, NodeSL> m = new HashMap<Integer, NodeSL>();
			int n = Integer.parseInt(br.readLine());

			NodeSL root = null;

			String nums[] = br.readLine().split(" ");
			int mm = n;
			for (int idx = 0; idx < mm; idx++) {

				int n1 = Integer.parseInt(nums[idx * 3]);
				int n2 = Integer.parseInt(nums[idx * 3 + 1]);

				String lr = nums[idx * 3 + 2];
				NodeSL parent = m.get(n1);
				if (parent == null) {
					parent = new NodeSL(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				NodeSL child = new NodeSL(n2);
				if (lr.equals("L"))
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}
			new Level().connect(root);
			printSpecial(root);
			System.out.println();
			inorder(root);
			System.out.println();

		}

	}

}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
/*
 * class Node { int data; Node left, right, nextRight; Node(int x) { this.data =
 * x; left = right = nextRight = null; }
 * 
 * 
 * }
 */
class Level {
	static void connect(NodeSL root) {
		Queue<NodeSL> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			NodeSL popNode = queue.poll();
			if(popNode==null) {
				NodeSL peek=queue.peek();
				if(peek!=null) {
					queue.add(null);
				}
			}else {
				popNode.nextRight = queue.peek();
				NodeSL left = popNode.left;
				NodeSL right = popNode.right;
				if(left!=null) queue.add(left);
				if(right!=null) queue.add(right);
			}
		}

	}

}

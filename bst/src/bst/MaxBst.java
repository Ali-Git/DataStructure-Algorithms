package bst;

import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class MaxBst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = null;
			if (n == 0) {
				System.out.println("0");
				continue;
			}
			if (n == 1) {
				int a = sc.nextInt();
				System.out.println("1");
				continue;

			} else {
				while (n-- > 0) {
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char ch = sc.next().charAt(0);
					if (root == null) {
						root = new Node(n1);
						switch (ch) {
						case 'L':
							root.left = new Node(n2);
							break;
						case 'R':
							root.right = new Node(n2);
							break;
						}
					} else {
						insert(n1, n2, ch, root);
					}
				}
				GfGMaxBst g = new GfGMaxBst();
				System.out.println(g.largestBst(root));
			}
		}
	}

	public static void insert(int n1, int n2, char ch, Node root) {
		if (root == null)
			return;
		if (root.data == n1)
			switch (ch) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		insert(n1, n2, ch, root.left);
		insert(n1, n2, ch, root.right);
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * The Node class is as follows class Node{ int data; Node left,right; Node(int
 * data) { this.data = data; this.left = null; this.right = null; } }
 */

class GfGMaxBst {
	
	public static int largestBst(Node node) {
		Info info = largest(node);
		return info.getNodeCount();
	}

	private static Info largest(Node root) {
		if (root == null) {
			return null;
		} else {
			Info l_info = largest(root.left);
			Info r_info = largest(root.right);
			Info info = null;
			if (l_info == null && r_info == null) {
				info = new Info();
				info.setBST(true);
				info.setNodeCount(1);
				info.setMinNode(root.data);
				info.setMaxNode(root.data);
			} else if (l_info == null && r_info != null) {
				info = new Info();
				if (r_info.isBST() && root.data < r_info.getMaxNode()) {
					info.setBST(true);
					info.setNodeCount(r_info.getNodeCount() + 1);
					info.setMinNode(root.data<r_info.getMinNode()?root.data:r_info.getMinNode());
					info.setMaxNode(r_info.getMaxNode());
				} else {
					info.setBST(false);
					info.setNodeCount(r_info.getNodeCount());
					info.setMinNode(r_info.getMinNode() < root.data ? r_info.getMinNode() : root.data);
					info.setMaxNode(root.data > r_info.getMaxNode() ? root.data : r_info.getMaxNode());
				}

			} else if (l_info != null && r_info == null) {
				info = new Info();
				if (l_info.isBST() && root.data > l_info.getMaxNode()) {
					info.setBST(true);
					info.setNodeCount(l_info.getNodeCount() + 1);
					info.setMinNode(l_info.getMinNode());
					info.setMaxNode(root.data);
				} else {
					info.setBST(false);
					info.setNodeCount(l_info.getNodeCount());
					info.setMinNode(root.data < l_info.getMinNode() ? root.data : l_info.getMinNode());
					info.setMaxNode(root.data > l_info.getMaxNode() ? root.data : l_info.getMaxNode());
				}
			} else if (l_info != null && r_info != null) {
				info = new Info();
				if (l_info.isBST() && r_info.isBST() && root.data > l_info.getMaxNode()
						&& root.data < r_info.getMinNode()) {
					info.setBST(true);
					info.setNodeCount(l_info.getNodeCount() + r_info.getNodeCount() + 1);
					info.setMinNode(l_info.getMinNode());
					info.setMaxNode(r_info.getMaxNode());
				} else {
					info.setBST(false);
					info.setNodeCount(l_info.getNodeCount() > r_info.getNodeCount() ? l_info.getNodeCount()
							: r_info.getNodeCount());
					int min = root.data;
					if (min > l_info.getMinNode())
						min = l_info.getMinNode();
					if (min > r_info.getMinNode())
						min = r_info.getMinNode();
					int max = root.data;
					if (max > l_info.getMaxNode())
						max = l_info.getMaxNode();
					if (max > r_info.getMaxNode())
						max = r_info.getMaxNode();
					info.setMinNode(min);
					info.setMaxNode(max);
				}
			}
			return info;
		}
	}
}

class Info {
	private boolean isBST;
	private int nodeCount;
	private int minNode;
	private int maxNode;

	public boolean isBST() {
		return isBST;
	}

	public void setBST(boolean isBST) {
		this.isBST = isBST;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

	public int getMinNode() {
		return minNode;
	}

	public void setMinNode(int minNode) {
		this.minNode = minNode;
	}

	public int getMaxNode() {
		return maxNode;
	}

	public void setMaxNode(int maxNode) {
		this.maxNode = maxNode;
	}
}
/*
Input
2
2
3 2 L 3 4 R
4
10 20 L 10 30 R 20 40 L 20 60 R

Output
3
1

Explanation:
Testcase 1: First case represents a tree with 3 nodes and 2 edges where root is 3, left child of 3 is 2 and right child of 3 is 4.


1
6
1 2 R 2 4 R 4 5 R 5 6 R 6 7 R 7 8 L
Corr Ans:1
Ans: 6

1
4
20 10 L 10 5 L 5 1 L 1 50 R
Corr Ans: 2
Ans: 5

1
6
20 10 L 10 5 L 5 2 L 2 3 R 20 30 R 30 15 L
Corr Ans: 4
Ans: 7
*/
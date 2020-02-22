package tree;

// INITIAL CODE
import java.util.HashMap;
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

public class BTLowestCommonAncestor {
	// driver function to test the above functions
	public static void main(String args[]) {
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
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

			int a = sc.nextInt();
			int b = sc.nextInt();

			Tree g = new Tree();
			Node k = g.lca(root, a, b);
			System.out.println(k.data);
			// System.out.println();
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
class Tree {
	/*
	 * If n1 and n2 are present, return reference to LCA. If both are not present,
	 * return null,. Else if left subtree contains any of them return pointer to
	 * left.
	 */

	private LCAResult lcaResult = null;

	Node lca(Node root, int n1, int n2) {

		//return findLCAMethod2(root, n1, n2);
	  lcaResult=new LCAResult(); 
	  findLCA(root, n1, n2); 
	  int dis=lcaResult.getN1Count()+lcaResult.getN2Count();
	  System.out.println("distance count between the nodes is : "+dis);
	  if(!lcaResult.isN1flag() && !lcaResult.isN2flag()) return lcaResult.getLcaNode();
	  else return new Node(-1);
	}

	// For this method to work..it is assumed that both the nodes are present..
	// If one of the node is not present it will give the node which is present as a
	// result which is wrong
	private Node findLCAMethod2(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		Node left = findLCAMethod2(root.left, n1, n2);
		Node right = findLCAMethod2(root.right, n1, n2);
		if (left == null && right == null)
			return null;
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	private Node findLCA(Node root, int n1, int n2) {
		if (root == null)
			return null;
		Node node = null;
		if (root.data == n1 && n1 == n2) {
			lcaResult.setN1flag(false);
			lcaResult.setN2flag(false);
			lcaResult.setLcaNode(root);
			node = root;
			return node;
		}
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);

		if (left == null && right == null) {
			if (root.data == n1 && lcaResult.isN1flag()) {
				lcaResult.setN1flag(false);
				node = root;
			}
			if (root.data == n2 && lcaResult.isN2flag()) {
				lcaResult.setN2flag(false);
				node = root;
			}
		} else if (left != null && right == null) {
			if (!lcaResult.isN1flag()) {
				if (root.data == n2) {
					lcaResult.setN2flag(false);
					lcaResult.setLcaNode(root);
					node = root;
				} else {
					node = left;
				}
			} else if (!lcaResult.isN2flag()) {
				if (root.data == n1) {
					lcaResult.setN1flag(false);
					lcaResult.setLcaNode(root);
					node = root;
				} else {
					node = left;
				}
			}
		} else if (left == null && right != null) {
			if (!lcaResult.isN1flag()) {
				if (root.data == n2) {
					lcaResult.setN2flag(false);
					lcaResult.setLcaNode(root);
					node = root;
				} else {
					node = right;
				}
			} else if (!lcaResult.isN2flag()) {
				if (root.data == n1) {
					lcaResult.setN1flag(false);
					lcaResult.setLcaNode(root);
					node = root;
				} else {
					node = right;
				}
			}
		} else if (left != null && right != null) {
			if (!lcaResult.isN1flag() && !lcaResult.isN2flag() && lcaResult.getLcaNode() == null) {
				lcaResult.setLcaNode(root);
				node = root;
			}
		}
		if(node!=null && lcaResult.getLcaNode()==null) {
			if(!lcaResult.isN1flag()) lcaResult.setN1Count(lcaResult.getN1Count()+1);
			else if(!lcaResult.isN2flag()) lcaResult.setN2Count(lcaResult.getN2Count()+1);
		}
		return node;

	}
}

class LCAResult {
	private Node lcaNode;
	private boolean n1flag = true;
	private boolean n2flag = true;
	private int n1Count=0;
	private int n2Count=0;

	public Node getLcaNode() {
		return lcaNode;
	}

	public void setLcaNode(Node lcaNode) {
		this.lcaNode = lcaNode;
	}

	public boolean isN1flag() {
		return n1flag;
	}

	public void setN1flag(boolean n1flag) {
		this.n1flag = n1flag;
	}

	public boolean isN2flag() {
		return n2flag;
	}

	public void setN2flag(boolean n2flag) {
		this.n2flag = n2flag;
	}

	public int getN1Count() {
		return n1Count;
	}

	public void setN1Count(int n1Count) {
		this.n1Count = n1Count;
	}

	public int getN2Count() {
		return n2Count;
	}

	public void setN2Count(int n2Count) {
		this.n2Count = n2Count;
	}

}
/*
 * Input 1 2 1 2 L 1 3 R 2 3
 * 
1 
3 
5 2 L 2 3 L 2 4 R 
3 4 
Output 1 2
 * 
 * 
1 
8 
3 6 L 3 8 R 6 2 L 6 11 R 8 13 R 11 9 L 11 5 R 13 7 L 
8 11 
OP-3
 * 
 * 
1 
1 
1 2 L 
1 1 
OP-1
 * 
 * ------------------------- 
 1
 4
 1 2 L 2 3 L 2 4 R 3 5 L 
 3 5 
 OP-3
 * 
 * 1 4 1 2 L 2 3 L 2 4 R 3 5 L 3 6 Op-should not havee been
 * ----------------------
 */
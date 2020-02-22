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

public class BTTwoNodesMinDist {
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

			int a = sc.nextInt();
			int b = sc.nextInt();

			GfGMDTN g = new GfGMDTN();
			// Node k = g.LCA(root,a,b);
			System.out.println(g.findDist(root, a, b));
			// System.out.println();
			t--;

		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
// FUNCTION CODE
/*
 * A Binary Tree node class Node { int data; Node left, right; Node(int item) {
 * data = item; left = right = null; } }
 */
/*
 * Should return minimum distance between a and b in a tree with given root
 */
class GfGMDTN {
	
	private FlagAndCount fc = new FlagAndCount();
	int findDist(Node root, int a, int b) {
		System.out.println("***");
		dist(root, a, b, fc);
		return fc.getCount();
	}
	private void dist(Node root, int a, int b, FlagAndCount fc) {
		if(root==null) return;
		if(root.data==a) {
			if(fc.isFlag()) {
				fc.setFlag(false);
				return;
			}else {
				fc.setFlag(true);
			}
		}
		if(root.data==b) {
			if(fc.isFlag()) {
				fc.setFlag(false);
				return;
			}else {
				fc.setFlag(true);
			}
		}
		if(fc.isFlag()) 
		{
			fc.setCount(fc.getCount()+1);
			
		}else {
			dist(root.left, a, b, fc);
		}
		
		if(fc.isFlag()) 
		{
			fc.setCount(fc.getCount()+1);
			
		}else {
			dist(root.right, a, b, fc);
		}
		
	}
}

class FlagAndCount{
	private boolean flag=false;
	private int count=0;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}


/*
1
2
1 2 L 1 3 R
2 3

Op-2
*/
package tree;

//Initial Template for Java
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

public class BinaryTreeTopView {

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

			new View().topView(root);
			System.out.println();
			t--;

		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
/*
 * class Node { int data; Node left, right; Node(int item) { data = item; left =
 * right = null; } }
 */
class View {
	private static int min=0;
	private static int max=0;
	static void topView(Node root) {
		Node head = root;
		min=0;
		max=0;
		findMinMax(root, 0);
		//System.out.println(min + " | " + max);
		Map<Integer, Node> map = new HashMap<>();
		prepareVLineNodeMap(head, map);
		for(int l=min; l<=max; l++) {
			Node temp = map.get(l);
			System.out.print(temp.data+" ");
		}
	}
	public static void prepareVLineNodeMap(Node root, Map<Integer, Node> map) {

		Queue<Integer> hdQueue = new LinkedList<>();
		hdQueue.add(0);
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		map.put(0, new Node(root.data));
		while(!nodeQueue.isEmpty()) {
			Node polledNode = nodeQueue.poll();
			int hd = hdQueue.poll();
			Node leftNode = polledNode.left;
			Node rightNode = polledNode.right;
			if(leftNode!=null) {
				updateLineNodeMap(map, hd-1, leftNode.data);
				hdQueue.add(hd-1);
				nodeQueue.add(leftNode);
			} 
			if(rightNode!=null) {
				updateLineNodeMap(map, hd+1, rightNode.data);
				hdQueue.add(hd+1);
				nodeQueue.add(rightNode);
			}
		}
	}
	
	private static void updateLineNodeMap(Map<Integer, Node> map, int key, int lrNodeData) {
		if(!map.containsKey(key)) {
			map.put(key, new Node(lrNodeData));
		}
	}
	
	private static void findMinMax(Node root, int hd) {
		if(root==null) return;
		if(min>hd) min=hd;
		if(max<hd) max=hd;
		findMinMax(root.left, hd-1);
		findMinMax(root.right, hd+1);
	}
}
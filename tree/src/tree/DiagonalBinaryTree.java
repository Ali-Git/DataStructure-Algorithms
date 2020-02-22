package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Tree node
class TreeNode {
	int data; // node data
	TreeNode left, right; // left and right child's reference
	// Tree node constructor

	TreeNode(int d) {
		data = d;
		left = right = null;
	}
}

public class DiagonalBinaryTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			TreeNode root = null;
			if (n == 1) {
				int a = sc.nextInt();
				System.out.println(a);
				continue;
			} else {
				while (n-- > 0) {
					int n1 = Integer.parseInt(sc.next());
					int n2 = Integer.parseInt(sc.next());
					char lr = sc.next().charAt(0);
					if (root == null) {
						root = new TreeNode(n1);
						switch (lr) {
						case 'L':
							root.left = new TreeNode(n2);
							break;
						case 'R':
							root.right = new TreeNode(n2);
							break;
						}
					} else {
						insert(root, n1, n2, lr);
					}
				}
			}
			GfG tree = new GfG();
			tree.diagonalPrint(root);
			System.out.println();

		}
	}

	public static void insert(TreeNode root, int n1, int n2, char lr) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new TreeNode(n2);
				break;
			case 'R':
				root.right = new TreeNode(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, lr);
			insert(root.right, n1, n2, lr);
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Node is defined as class TreeNode { int data; //node data TreeNode left,
 * right; //left and right child's reference // Tree node constructor public
 * TreeNode(int data) { this.data = data; left = right = null; } }
 */
class GfG {
	public void diagonalPrint(TreeNode root) {
		TreeNode head = root;
		int leftTreeD = 0;
		while (root.left != null) {
			root = root.left;
			leftTreeD++;
		}
		root = head;
		// System.out.println(leftTreeD);
		Map<Integer, TreeNode> map = new HashMap<>();
		prepareDiagonalLineNodeMap(root, map, 0);
		// System.out.println(map);
		for (int i = 0; i <= leftTreeD; i++) {
			TreeNode tn = map.get(i);
			while (tn != null) {
				System.out.print(tn.data + " ");
				tn = tn.right;
			}
		}
	}

	private void prepareDiagonalLineNodeMap(TreeNode root, Map<Integer, TreeNode> map, int diagonalD) {
		if (root == null)
			return;
		if (map.containsKey(diagonalD)) {
			TreeNode node = map.get(diagonalD);
			TreeNode temp = node;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = new TreeNode(root.data);
			map.put(diagonalD, node);
		} else {
			map.put(diagonalD, new TreeNode(root.data));
		}
		prepareDiagonalLineNodeMap(root.left, map, diagonalD + 1);
		prepareDiagonalLineNodeMap(root.right, map, diagonalD);

	}

}
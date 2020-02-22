package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Make Binary Tree From Linked List
// https://practice.geeksforgeeks.org/problems/make-binary-tree/1
class TreeLBT {
	int data;
	TreeLBT left;
	TreeLBT right;

	TreeLBT(int d) {
		data = d;
		left = null;
		right = null;
	}
}

class NodeLBT {
	int data;
	NodeLBT next;

	NodeLBT(int d) {
		data = d;
		next = null;
	}
}

public class LinkedListToBinaryTree {
	static NodeLBT lhead;
	static Queue<TreeLBT> queue = new LinkedList<TreeLBT>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			TreeLBT node = null;
			lhead = null;
			NodeLBT head = null;
			while (!queue.isEmpty()) {
				queue.poll();
			}
			int n = sc.nextInt();
			if (n != 0) {
				LinkedListToBinaryTree llist = new LinkedListToBinaryTree();
				int a1 = sc.nextInt();
				head = new NodeLBT(a1);
				llist.addToTheLast(head);
				lhead = head;
				for (int i = 1; i < n; i++) {
					int a = sc.nextInt();
					llist.addToTheLast(new NodeLBT(a));
				}
			}
			GfGLBT g = new GfGLBT();
			TreeLBT root = g.convert(lhead, node);
			try {
				levelOrder(root, n);
			} catch (NullPointerException ex) {
				System.out.println(-1);
			}
			System.out.println();
		}
	}

	public static void levelOrder(TreeLBT root, int n) {
		queue.add(root);
		while (!queue.isEmpty() && n-- > 0) {
			TreeLBT proot = queue.remove();
			try {
				queue.add(proot.left);
				queue.add(proot.right);
				System.out.print(proot.data + " ");
			} catch (NullPointerException ex) {
			}
		}
	}

	public void addToTheLast(NodeLBT head) {
		if (lhead == null)
			lhead = head;
		else {
			NodeLBT temp = lhead;
			while (temp.next != null)
				temp = temp.next;
			temp.next = head;
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * class Tree{ int data; Tree left; Tree right; Tree(int d){ data=d; left=null;
 * right=null; } } class Node { int data; Node next; Node(int d) { data = d;
 * next = null; } }
 */
class GfGLBT {
	public static TreeLBT convert(NodeLBT head, TreeLBT node) {
		TreeLBT treeH = new TreeLBT(head.data);
		TreeLBT tree = treeH;
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.data);
			head = head.next;
		}
		int n = (list.size() - 1) / 2;
		for (int i = 0; i <= n; i++) {
			// tree=treeH;
			int left = 0;
			int right = 0;
			// System.out.print(list.get(i) + " ");
			if (((2 * i + 1)) < list.size()) {
				// System.out.print(" | left" + list.get(2 * i + 1));
				insertTreeElement(tree, list, 0, i, true);
			}
			if (((2 * i + 2)) < list.size()) {
				// System.out.print(" | right" + list.get(2 * i + 2));
				insertTreeElement(tree, list, 0, i, false);
			}
			// System.out.println();
		}
		return treeH;
	}

	private static void insertTreeElement(TreeLBT tree, List<Integer> list, int rI, int i, boolean flag) {
		if (tree == null)
			return;
		if (rI == i) {
			if (flag)
				tree.left = new TreeLBT(list.get(2 * i + 1));
			else
				tree.right = new TreeLBT(list.get(2 * i + 2));
			return;
		}
		insertTreeElement(tree.left, list, 2 * rI + 1, i, flag);
		insertTreeElement(tree.right, list, 2 * rI + 2, i, flag);

	}

}

/*
 * 
 * 
 * 1 5 1 2 3 4 5
 * 
 * 1 5 5 4 3 2 1
 * 
 * 1 2 3 4 5
 * 
 * 
 * Input: 1 6 31 97 31 41 39 88
 * 
 * Its Correct output is: 31 97 31 41 39 88
 * 
 * And Your Code's output is: 31 88 31
 * 
 * 
 */
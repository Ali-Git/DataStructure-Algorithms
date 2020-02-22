package bst.pre.pro;

import java.util.Scanner;

public class PreToPostTree {
	
	private static Node rootNode;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
        	int node_count = sc.nextInt();
        	int pre[] = new int[node_count];
        	for(int i=0; i<node_count; i++) {
        		pre[i]=sc.nextInt();
        	}
        	createBST(pre, 0, pre.length-1);
        	//System.out.println(rootNode);
        	//printPostOrder(rootNode);
        }

	}
	
	private static void printPostOrder(Node root){
		if(root==null) {
			return;
		}else {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	private static void createBST(int pre[], int min, int max) {
		//System.out.println("root: "+min);
		//insertNode(rootNode, new Node(pre[min]));
		if(max>min) {
			int i=min;
			for(i=min; i<=max; i++) {
				if(pre[min]<pre[i]) { // pre[min]==root
					break;
				}
			}
			if(i-1 >= min+1) createBST(pre, min+1, i-1); // by putting this check, it will remove the repitition
			if(max >= i) createBST(pre, i, max); // by putting this check, it will remove the repitition
		}
		System.out.print(pre[min]+" ");

	}
	
	private static Node insertNode(Node root, Node node) {
		if(root==null) {
			if(rootNode==null) rootNode = node;
			return node;
		}else {
			if(node.data < root.data) {
				Node temp = insertNode(root.left, node);
				root.left = temp;
			}else if(node.data > root.data){
				Node temp = insertNode(root.right, node);
				root.right = temp;
			}
			return root;
		}
	}

}

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


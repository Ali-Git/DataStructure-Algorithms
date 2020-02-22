package bst;
// Add all greater values to every node in a BST

	// INITIAL CODE
	import java.util.*;
	import java.lang.*;
	import java.io.*;
	// A Binary Search Tree node

public class Greater_Nodes_Sum
	{
		Node root;
		
		void insert(Node root, int key)
		{
			//System.out.print(key);
			if(key < root.data)
			{    //System.out.print(root.key);
				if(root.left != null)
					insert(root.left, key);
				else
				{
		            root.left = new Node(key);
					//System.out.print(root.left.key);
				}	
				//root = root.left;
				//insert(root.left,key);
			}
			else if(key > root.data)
			{
				//System.out.print(root.key);
				if(root.right != null)
					insert(root.right, key);
				else
				{
				    root.right = new Node(key);
				//System.out.print(root.right.key);
				}
				//root = root.right;
				//insert(root.right, key);
				//System.out.println(key);
			}
		}
		void inorder(Node node)
		{
			if(node==null)
				return ;
			else
				inorder(node.left);
				System.out.print(node.data + " ");
				inorder(node.right);
		}
	    public static void main(String args[])
	    {
			Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
			//Node root;
	        while (t > 0)
	        {
				//Node root;
				//Node tmp;
				//root = null;
	            int n = sc.nextInt();
			    Greater_Nodes_Sum tree = new Greater_Nodes_Sum();
				//GfG g = new GfG();
				int a1 = sc.nextInt();
				Node root = new Node(a1);
				
				for(int i=1;i<n;i++)
	            {
					int a = sc.nextInt();
					tree.insert(root,a);
				}
			
	            GfG g = new GfG();
	            //tree.inorder(root);
				g.modify(root);
				tree.inorder(root);
				System.out.println();
			t--;
			}
	    }
	}
	
	/*This is a function problem.You only need to complete the function given below*/
	// A Binary Search Tree node
	/* class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	} */
	class GfG
	{   
	    private int sum=0;
	    void modify(Node root)
	    {
	    	if(root==null){
	    	    return;
	    	}else{
	    	    modify(root.right);
	    	    sum = sum + root.data;
	    	    root.data = sum;
	    	    modify(root.left);
	    	}
	    }
	}

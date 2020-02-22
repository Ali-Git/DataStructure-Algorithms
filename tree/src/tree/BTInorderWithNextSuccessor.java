package tree;
// https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1

import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
import java.lang.Math;
class Node
    {
        int data;
        Node left,right,next;
        Node(int d) {data = d; left =right= next= null; }
    }
		
public class BTInorderWithNextSuccessor
{
    public static Node target;
    BTInorderWithNextSuccessor(){
        target=null;
    }
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void print(Node root)
    {
        if(root==null)
        return;
        while(root.left!=null)
            root=root.left;
        while(root!=null){
        System.out.print(root.data+"->");
        if(root.next!=null)
        System.out.print(root.next.data+" ");
        else
        System.out.print("-1 ");
        root=root.next;
        }
    }
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			BTInorderWithNextSuccessor llist=new BTInorderWithNextSuccessor();
			Node root=null,parent=null;
			HashMap<Integer, Node> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(root==null){
                    root=new Node(a);
                    switch(c){
                        case 'L':root.left=new Node(b);
                        break;
                        case 'R':root.right=new Node(b);
                        break;
                    }
                }
                else{
                    insert(root,a,b,c);
                }
            }
            GFG obj = new GFG();
            obj.populateNext(root);
            //inorder(root);
            print(root);
            System.out.println();
		}
	}
	public static void insert(Node root,int a, int b,char c){
	    if(root==null)
	        return;
	   if(root.data==a){
	       switch(c){
            case 'L':root.left=new Node(b);
            break;
            case 'R':root.right=new Node(b);
            break;
            }
	   }
	   else{
	       insert(root.left,a,b,c);
	       insert(root.right,a,b,c);
	   }
	}
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
    {
        int data;
        Node left,right,next;
        Node(int d) {data = d; left =right= next= null; }
    }*/
class GFG
{
	private static Node lastLeftParent=null;
    public static void populateNext(Node root)
    {
    	Node head=root;
        print(root, head);
    }
    
    private static void print(Node root, Node head){
        if(root==null) return;
        print(root.left, head);
        if(root.right!=null)
        	findLeftMostNodeInRightSubtree(root, root.right);
        else {
        	lastLeftParent=null;
        	findLastLeft(root, head, null);
        	if(lastLeftParent==null)
        		root.next=new Node(-1);
        	else
        		root.next=lastLeftParent;
        }
        	
        print(root.right, head);
    }

	private static void findLastLeft(Node node, Node root, Node lastLeft) {
		if(root==null) return;
		if(root.left!=null) {
			lastLeft=root;
			findLastLeft(node, root.left, lastLeft);
		}
		if(root==node) {
			lastLeftParent=lastLeft;
			return;
		}
		findLastLeft(node, root.right, lastLeft);

		
	}

	private static void findLeftMostNodeInRightSubtree(Node node, Node right) {
		while(right.left!=null) {
			right=right.left;
		}
		node.next=new Node(right.data);
	}
}

/*
Input:
1
3
10 8 L 8 3 L 10 12 R

Output:
3->8 8->10 10->12 12->-1



Input:
1
2
21 57 L 21 12 R

Its Correct output is:
57->21 21->12 12->-1

And Your Code's output is:
57->-1 -1->-1
---------------------------
1
6
54 92 L 54 9 R  92 4 L 92 41 R  9 26 L 9 63 R

Its Correct output is:
4->92 92->41 41->54 54->26 26->9 9->63 63->-1

And Your Code's output is:
4->92 92->41 41->-1

*/
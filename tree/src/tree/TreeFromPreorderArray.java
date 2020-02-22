package tree;

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
public class TreeFromPreorderArray
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []pre=new int[n];
            char []preLN=new char[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                pre[i]=b;
            }
            for(int i=0;i<n;i++)
            {
                char c=sc.next().charAt(0);
                preLN[i]=c;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
//Function should return the root of the formed binary tree.
class GFG
{
    Node constructTree(int n, int pre[], char preLN[])
    {
	    
	    Node root = new Node(pre[0]);
	    for(int i=1; i<pre.length; i++) {
	    	
	    	construct(root, new Node(pre[i]), preLN[i]);
	    }
	    
	    return root;
    }
    
    private void construct(Node root, Node node, char ch) {
    	if(root==null) {
    		return;
    	}else {
    		construct(root.left, node, ch);
    		construct(root.right, node, ch);
    	}
    }
}

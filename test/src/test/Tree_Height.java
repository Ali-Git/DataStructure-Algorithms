package test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
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
class Tree_Height
{
    public static void main(String args[])
    {
    	Node root = new Node(1);
    	root.left = new Node(2);
    	root.right = new Node(3);
    	root.right.left = new Node(4);
    	//root.right.right = new Node(5);
    	//30
    	//95 74 L 95 71 R  74 61 L 74 82 R  71 5 L 71 5 R  
    	//61 14 L 61 37 R  82 5 L 82 61 R  5 14 L 5 77 R  5 4 L 5 61 R  
    	//14 43 L 14 50 R  37 30 L 37 16 R  5 94 L 5 39 R  
    	//61 87 L 61 25 R  14 66 L 14 5 R  77 34 L 77 14 R  4 71 L 4 18 R  61 85 L 61 56 R
    	
    	boolean res = isPerfectRec(root);
    	System.out.println("res: "+res);
    	
    	Tree tree = new Tree();
    	int h = tree.height(root);
    	System.out.println("Height of the tree : "+h);
    	for(int i=1; i<=h; i++) {
    		levelOrderTraversal(root, i);
    	}
    }
    
    static void levelOrderTraversal(Node node, int level) {
    	if(level==1) {
    		System.out.print(node.data+" ");
    	}else {
    		if (node.left != null) levelOrderTraversal(node.left, level-1);
    		if (node.right != null) levelOrderTraversal(node.right, level-1);
    	}
    }
    
    static Boolean flag = true;
    public static boolean isPerfectRec(Node root) //, int d, int level
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left==null && node.right!=null){
                flag=false;
                break;
            }
            if(node.left!=null && node.right==null){
                flag=false;
                break;
            }
            //System.out.println("***-"+node.data+" || left-> "+node.left+" || right-> "+node.right);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        if(flag){
            return true;
        }else{
            flag=true;
            return false;
        }
       
    }
}

class Tree
{
    int height(Node node) 
    {
		if(node==null) {
			return 0;
		}else {
			int lheight = height(node.left);
			lheight = lheight + 1;
			int rheight = height(node.right);
			rheight = rheight + 1;
			if(lheight > rheight) {
				return lheight;
			}else {
				return rheight;
			}
		}
    }  
}
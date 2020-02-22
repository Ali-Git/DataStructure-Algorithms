package tree;

import java.util.Scanner;

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

public class BTNodeAncestorMaxDiff
{
    public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            GfGAMD g=new GfGAMD();
            System.out.println(g.maxDiff(root));
            
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
    
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
//Back-end complete function Template for Java
/*
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
*/
class GfGAMD
{

	int maxDiff(Node root) {
		GLNode glNode= getMaxDiff(root);
		return glNode.d;

	}

	private GLNode getMaxDiff(Node root) {
		if (root == null)
			return null;
		GLNode glNode = new GLNode();
		GLNode left = getMaxDiff(root.left);
		GLNode right = getMaxDiff(root.right);
		if(left==null && right==null) {
			glNode.setL(root.data);
			glNode.setD(Integer.MIN_VALUE);
		}else if(left!=null && right==null) {
			int min=root.data;
			if(min>left.l) min=left.l;
			if(root.data-left.l>left.d) {
				glNode.setL(min);
				glNode.setD(root.data-left.l);
			}else {
				glNode.setL(min);
				glNode.setD(left.d);
			}
		}else if(left==null && right!=null) {
			int min=root.data;
			if(min>right.l) min=right.l;
			if(root.data-right.l>right.d) {
				glNode.setL(min);
				glNode.setD(root.data-right.l);
			}else {
				glNode.setL(min);
				glNode.setD(right.d);
			}
		}else if(left!=null && right!=null) {
			int min=root.data;
			if(left.l<min) min=left.l;
			if(right.l<min) min=right.l;
			glNode.setL(min);
			int maxDiff=left.d;
			if(maxDiff<right.d) maxDiff=right.d;
			if(maxDiff<root.data-left.l) maxDiff=root.data-left.l;
			if(maxDiff<root.data-right.l) maxDiff=root.data-right.l;
			glNode.setD(maxDiff);
		}
		return glNode;
	}
	
	class GLNode{
		private int l;
		private int d=Integer.MIN_VALUE;
		public int getL() {
			return l;
		}
		public void setL(int l) {
			this.l = l;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		
	}
}

/*
1
4
3 5 L 3 0 R  5 6 L 5 4 R

Its Correct output is:
3
And Your Code's output is:
6

1
4
1 2 L 1 6 R  2 4 L 2 3 R
-1-R
0-W

1
7
6 14 L 6 10 R  14 3 L 14 13 R  10 8 L 10 5 R  3 1 L
13-R
11-W


1
42
60 1 L 60 43 R  1 55 L 1 31 R  43 11 L 43 51 R  55 41 L 55 20 R  31 13 L 31 48 R  11 34 L 11 56 R  51 40 L 51 49 R  41 47 L 41 37 R  20 33 L 20 29 R  13 21 L 13 54 R  48 7 L 48 50 R  34 4 L 34 27 R  56 28 L 56 38 R  40 24 L 40 30 R  49 16 L 49 17 R  47 8 L 47 57 R  37 23 L 37 46 R  33 15 L 33 61 R  29 45 L 29 62 R  21 5 L 21 59 R  54 26 L 54 36 R

Its Correct output is:
59

And Your Code's output is:
56



1
18
0 19 L 0 3 R  19 13 L 19 6 R  3 10 L 3 22 R  13 9 L 13 26 R  6 14 L 6 24 R  10 4 L 10 23 R  22 15 L 22 17 R  9 8 L 9 27 R  26 29 L 26 16 R
13-R
19-W
*/
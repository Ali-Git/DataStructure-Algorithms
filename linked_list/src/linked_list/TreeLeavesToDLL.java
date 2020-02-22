package linked_list;

import java.util.Scanner;
class Node
{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class TreeLeavesToDLL
{
     public static void main(String[] args){
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
            Node head = null;
            //inorder(root);
            GfG g=new GfG();
            root = g.convertToDLL(root);
            g.pritntDLL();
            System.out.println();
           
           // System.out.println(g.tilt(root));
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
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class GfG
{
    public void pritntDLL(){
        while(h_node!=null){
            System.out.print(h_node.data+" ");
            h_node = h_node.right;
        }
    }
    
	private static Node h_node=null;
	private static Node node=null;
    Node convertToDLL(Node root)
    {
        convert(root);
        System.out.println(h_node);
        return h_node;
    }
    private void convert(Node root){
        if(root==null){
            return;
        }else{
            convert(root.left);
            if(root.left==null && root.right==null){
                if(h_node==null) {
                	h_node = root;
                	node = root;
                }else {
                	root.left = node;
                	node.right=root;
                	node = node.right;
                }
                System.out.println("data: "+node.data);
            }
            convert(root.right);
        }
    }
}

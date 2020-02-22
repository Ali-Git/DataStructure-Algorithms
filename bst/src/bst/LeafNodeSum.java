package bst;

import java.util.*;
public class LeafNodeSum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            GfG2 gfg = new GfG2();
            System.out.println(gfg.sumOfLeafNodes(root));
        }
    }
    
    public static Node insert(Node root, int x)
    {
        
        if(root == null)
          {
              return (new Node(x));
          }
          
          if(x < root.data)
          {
              root.left = insert(root.left, x);
          }
          else if(x >= root.data)
          {
              root.right = insert(root.right, x);
          }
          
      return root;      
    }
    
}

class GfG2
{
    private static int res=0;
    public static int sumOfLeafNodes(Node root)
    {
        res=0;
        return sum(root);
    }
    
    private static int sum(Node root){
        if(root == null)
          return 0;
        else{
            if(root.left==null && root.right==null){
                res = res + root.data;
            }
            sum(root.left);
            sum(root.right);
            return res;
        }
    }
}
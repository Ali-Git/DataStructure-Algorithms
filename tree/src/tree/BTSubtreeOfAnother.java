package tree;

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class BTSubtreeOfAnother {
    public static void main(String[] args)throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        
        

        while (t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();

            Node root = null;

            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }

                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
			//sec tree
			
			 HashMap<Integer, Node> mm = new HashMap<Integer, Node> ();
            int nn = sc.nextInt();

            Node roott = null;

            while (nn > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                
                Node parent = mm.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    mm.put(n1, parent);
                    if (roott == null)
                        roott = parent;
                }

                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                mm.put(n2, child);
                nn--;
            }
            TreeSubtree g = new TreeSubtree();
            boolean q = g.isSubtree(roott, root);
            if (q == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    // public static void insert(int a, int b, char lr, Node root) {
    //     if (root == null) return;
    //     if (root.data == a) {
    //         switch (lr) {
    //             case 'L':
    //                 root.left = new Node(b);
    //                 break;
    //             case 'R':
    //                 root.right = new Node(b);
    //                 break;
    //         }
    //     }
    //     insert(a, b, lr, root.left);
    //     insert(a, b, lr, root.right);
    // }
}





// } Driver Code Ends

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class TreeSubtree {
	
	class Info{
		private StringBuilder inStr = new StringBuilder();
		private StringBuilder preStr = new StringBuilder();
	}

    public static boolean isSubtree(Node T, Node S) {
        
    	if(S==null) return true;
    	TreeSubtree.Info sInfo = new TreeSubtree().new Info();
    	TreeSubtree.Info tInfo = new TreeSubtree().new Info();
        inOrderTraverseString(S , sInfo, false);
        inOrderTraverseString(T, tInfo, false);
        preOrderTraverseString(S, sInfo, false);
        preOrderTraverseString(T, tInfo, false);
        //System.out.println(tInfo.inStr +" |In| "+sInfo.inStr);
        //System.out.println(tInfo.preStr +" |Pre| "+sInfo.preStr);
        if(tInfo.inStr.toString().contains(sInfo.inStr.toString())) {
        	if(tInfo.inStr.toString().contains(sInfo.inStr.toString()))
        		return true;
        	else
        		return false;
        }else
        return false;
    }
	private static void inOrderTraverseString(Node node, TreeSubtree.Info info, boolean flag) {
		if(node==null) {
			String str="";
			if(flag) str="lnull";
			else str="rnull";
			info.inStr.append(str);
			return;
		}
		inOrderTraverseString(node.left, info, true);
		info.inStr.append("#"+node.data);
		inOrderTraverseString(node.right, info, false);
	}
	
	private static void preOrderTraverseString(Node node, TreeSubtree.Info info, boolean flag) {
		if(node==null) {
			String str="";
			if(flag) str="lnull";
			else str="rnull";
			info.preStr.append(str);
			return;
		}
		info.preStr.append("#"+node.data);
		preOrderTraverseString(node.left, info, true);
		preOrderTraverseString(node.right, info, false);
	}
}


/*

3
1
3 4 L
3
1 2 L 1 3 R 3 4 L
5
26 10 L 10 20 L 10 30 R 20 40 L 20 60 R
5
26 10 L 10 20 L 10 30 R 20 40 L 20 60 R
3
10 4 L 10 6 R 4 30 R
6
26 10 L 26 3 R 10 4 L 10 6 R 6 25 R 3 3 R

Output:
1
1
0


1
2
10 4 L 10 6 R
6
26 10 L 26 3 R 10 4 L 10 6 R 6 25 R 3 3 R
OP-1


1
1
1 2 L
3
1 2 L 1 3 R 2 4 L
OP-0




*/
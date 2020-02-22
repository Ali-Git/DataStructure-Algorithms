package bst;

import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class CorrectBSTBySwapTwo
{
    static int flag = 1;
    static int c = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = n;
            if(n == 0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Node temp = null;
             for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    temp = new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                                 temp.left = new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                                 temp.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                    insert(temp, a, a1, lr);
                }
            }
            flag = 1;
            c = 0;
            GfGFixBST gfg = new GfGFixBST();
            root = gfg.correctBST(root);
            
            inorder(temp, root);
            if(c+1 == m)
            System.out.println(flag);
            else
            System.out.println("0");
            
        }
    }
    
    public static void insert(Node root, int a, int a1, char lr)
    {
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
    
    public static void inorder(Node temp, Node root)
    {
        	if(flag==0){
		      return;
	}
	if(temp==null && root== null)
		return;
	if(root==null){
		flag=0;
		return;
	}
	if(temp==null){
		flag=0;
		return;
	}
	if(temp.data==root.data){
	    c++;
	}
	inorder(temp.left,root.left);
	inorder(temp.right,root.right);
    }
}

// } Driver Code Ends
/*
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/

class GfGFixBST
{

	private Set<Integer> set = null;
	private GfGFixBST.NodeInfo nodeInfo1 = null;
	private GfGFixBST.NodeInfo nodeInfo2 = null;

	public Node correctBST(Node root) {
		set = new HashSet<>();
		findNodes(root);
		if (set.size() == 2) {
			List<Integer> list = new ArrayList<>();
			for(int temp: set) {
				list.add(temp);
			}
			int n1=list.get(0);
			int n2=list.get(1);
			fillNodes(root, n1, n2);
			if(nodeInfo1.getRootNode()==nodeInfo2.getRootNode()) {
				int temp = nodeInfo1.getRootNode().left.data;
				nodeInfo1.getRootNode().left.data = nodeInfo1.getRootNode().right.data;
				nodeInfo1.getRootNode().right.data=temp;
			}else {
				if (nodeInfo1.getRootNode().left!=null && nodeInfo1.getRootNode().left.data == n1)
					nodeInfo1.getRootNode().left.data = nodeInfo2.getChildData();
				if (nodeInfo1.getRootNode().right!=null && nodeInfo1.getRootNode().right.data == n1)
					nodeInfo1.getRootNode().right.data = nodeInfo2.getChildData();
				if (nodeInfo2.getRootNode().left!=null && nodeInfo2.getRootNode().left.data == n2)
					nodeInfo2.getRootNode().left.data = nodeInfo1.getChildData();
				if (nodeInfo2.getRootNode().right!=null && nodeInfo2.getRootNode().right.data == n2)
					nodeInfo2.getRootNode().right.data = nodeInfo1.getChildData();
			}

		}

		return root;
	}

	private void fillNodes(Node root, int n1, int n2) {
		if (root == null)
			return;
		if (root.left != null) {
			if (root.left.data == n1)
				nodeInfo1 = new GfGFixBST().new NodeInfo(root, n1);
			if (root.left.data == n2)
				nodeInfo2 = new GfGFixBST().new NodeInfo(root, n2);
		}
		if (root.right != null) {
			if (root.right.data == n1)
				nodeInfo1 = new GfGFixBST().new NodeInfo(root, n1);
			if (root.right.data == n2)
				nodeInfo2 = new GfGFixBST().new NodeInfo(root, n2);
		}
		if (nodeInfo1 != null && nodeInfo2 != null)
			return;
		fillNodes(root.left, n1, n2);
		fillNodes(root.right, n1, n2);

	}

	private Info findNodes(Node root) {
		if (root == null)
			return null;

		Info left = findNodes(root.left);
		Info right = findNodes(root.right);
		if (left != null && root.data < left.max) {
			set.add(left.max);
		}
		if (right != null && root.data > right.min) {
			set.add(right.min);
		}
		GfGFixBST.Info info = new GfGFixBST().new Info();
		int min = root.data;
		int max = root.data;
		if (left != null) {
			if (min > left.min)
				min = left.min;
			if (max < left.max)
				max = left.max;
		}
		if (right != null) {
			if (min > right.min)
				min = right.min;
			if (max < right.max)
				max = right.max;
		}
		info.setMin(min);
		info.setMax(max);
		return info;
	}

	class Info {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

	}

	class NodeInfo {
		private Node rootNode;
		private int childData;

		public NodeInfo(Node rootNode, int childData) {
			this.rootNode = rootNode;
			this.childData = childData;
		}

		public Node getRootNode() {
			return rootNode;
		}

		public void setRootNode(Node rootNode) {
			this.rootNode = rootNode;
		}

		public int getChildData() {
			return childData;
		}

		public void setChildData(int childData) {
			this.childData = childData;
		}
	}

}

/*
 * 
 * Input:
2
4
10 5 L 10 8 R  5 2 L 5 20 R
5
8 3 L 8 10 R 3 1 L 3 6 R 6 7 R

Output:
1
0


1
4
5 3 L 5 7 R 3 4 L 3 1 R
OP-1

1
5
10 7 L 10 14 R 14 8 R 7 15 R 7 4 L

1
5
10 14 L 10 7 R 14 8 R 7 15 R 14 4 L
OP-1

OP-1

*/
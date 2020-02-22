package tree;



import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data, hd;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
public class VerticalBinaryTree
{
    public static void main (String[] args)throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = Integer.parseInt(read.readLine());
            Node root = null;
            String str[] = read.readLine().replace("  ", " ").trim().split(" ");
            int k = 0;
            while(n-- > 0)
            {
                int n1 = Integer.parseInt(str[k++]);
                int n2 = Integer.parseInt(str[k++]);
	        	char lr= str[k++].charAt(0);
				
                
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
            }
            
            BinaryTree obj = new BinaryTree();
            obj.verticalOrder(root);
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}*/
class BinaryTree
{
	private static int min=0;
	private static int max=0;
	static void verticalOrder(Node root) {
		Node head = root;
		min=0;
		max=0;
		findMinMax(root, 0);
		//System.out.println(min + " | " + max);
		Map<Integer, Node> map = new HashMap<>();
		prepareVLineNodeMap(head, map);
		for (int i = min; i <= max; i++) {
			Node temp = map.get(i);
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
	}

	private static void findMinMax(Node root, int hd) {
		if(root==null) return;
		if(min>hd) min=hd;
		if(max<hd) max=hd;
		findMinMax(root.left, hd-1);
		findMinMax(root.right, hd+1);
	}

	public static void prepareVLineNodeMap(Node root, Map<Integer, Node> map) {

		Queue<Integer> hdQueue = new LinkedList<>();
		hdQueue.add(0);
		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		map.put(0, new Node(root.data));
		while(!nodeQueue.isEmpty()) {
			Node polledNode = nodeQueue.poll();
			int hd = hdQueue.poll();
			Node leftNode = polledNode.left;
			Node rightNode = polledNode.right;
			if(leftNode!=null) {
				updateLineNodeMap(map, hd-1, leftNode.data);
				hdQueue.add(hd-1);
				nodeQueue.add(leftNode);
			} 
			if(rightNode!=null) {
				updateLineNodeMap(map, hd+1, rightNode.data);
				hdQueue.add(hd+1);
				nodeQueue.add(rightNode);
			}
		}
	}
	
	private static void updateLineNodeMap(Map<Integer, Node> map, int key, int lrNodeData) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			Node temp=node;
			while(temp.right!=null) {
				temp=temp.right;
			}
			temp.right = new Node(lrNodeData);
			map.put(key, node);
		}else {
			map.put(key, new Node(lrNodeData));
		}
	}

}

/*
1
3
1 2 L 1 3 R 3 5 L

1
2
1 2 R 1 3 L

1
4
10 20 L 10 30 R 20 40 L 20 60 R

1
4
1 2 L 1 3 R 2 4 R 4 5 R

*/
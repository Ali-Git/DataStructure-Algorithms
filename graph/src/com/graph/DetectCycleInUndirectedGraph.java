package com.graph;

import java.util.*;

import com.graph.MST.Edge;
import com.graph.MST.Node;

import java.io.*;
import java.lang.*;

public class DetectCycleInUndirectedGraph
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends
//User function Template for Java

/*
ArrayList<ArrayList<Integer>> list: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
	class Node {
		int data;
		Node parent;
		int rank;
	}
	private static Map<Integer, Node> map = new HashMap<>();
    private static boolean flag=false;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V)
    {
    	flag=false;
		for(int i=0; i<V; i++) {
			makeSet(i);
		}
		// Adjacency Matrix has been created to not to create duplicate edge.
		int arr[][] = new int[V][V]; 
		List<Edge> list = new ArrayList<>();
		for(int i=0; i< V; i++) {
			List<Integer> tempList = graph.get(i);
			if(tempList.isEmpty()) continue;
			for(int j: tempList) {
				if(arr[j][i]==1) continue;//Ignoring duplicate edge
				list.add(new DetectCycle().new Edge(i, j, 1));
				arr[i][j]=1;
			}
			
		}
		//System.out.println(list);
		for(Edge edge: list) {
			int v1Parent =findSet(edge.v1);
			int v2Parent =findSet(edge.v2);
			if(v1Parent==v2Parent) {
				flag=true;
				break;	
			}
			else {
				union(edge.v1, edge.v2);
			}
		}
        return flag;
    }
    
	private static void makeSet(int data) {
		DetectCycle.Node node = new  DetectCycle().new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}
	
	private static boolean union(int data1, int data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		// if they are part of same set do nothing
		if (parent1.data == parent2.data) {
			return false;
		}

		// else whoever's rank is higher becomes parent of other
		if (parent1.rank >= parent2.rank) {
			// increment rank only if both sets have same rank
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
		return true;
	}
	
	private static int findSet(int data) {
		return findSet(map.get(data)).data;
	}
	
	private static Node findSet(Node node) {
		Node parent = node.parent;
		if (parent == node) {
			return parent;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}
	
	class Edge {
		int v1;
		int v2;
		int weight;
		public Edge() {}
		
		public Edge(int v1, int v2, int weight) {
			this.v1=v1;
			this.v2=v2;
			this.weight=weight;
		}

		public int getV1() {
			return v1;
		}

		public void setV1(int v1) {
			this.v1 = v1;
		}

		public int getV2() {
			return v2;
		}

		public void setV2(int v2) {
			this.v2 = v2;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}
}



/*
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output:
1
0
1

Explanation:
Testcase 1: In above first test case there is a graph with 2 vertices and 2 edges the first edge is from 0 to 1 and other edge is from 0 to 0 . 
Testcase 2: In the second test case there is a graph with 3 vertices and 3 edges from 0 to 1 , 1 to 2 and 2 to 3.

*/

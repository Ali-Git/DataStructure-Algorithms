package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Initial Template for Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Minimum Spanning Tree
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class KruskalMinSpanningTree {

	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			String str[] = read.readLine().trim().split(" ");
			int V = Integer.parseInt(str[0]);
			int E = Integer.parseInt(str[1]);
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j = 0; j < V; j++)
					temp.add(Integer.MAX_VALUE);
				graph.add(temp);
			}
			str = read.readLine().trim().split(" ");
			int k = 0;
			while (E-- > 0) {
				int u = Integer.parseInt(str[k++]);
				int v = Integer.parseInt(str[k++]);
				int w = Integer.parseInt(str[k++]);
				u--;
				v--;
				graph.get(u).set(v, w);
				graph.get(v).set(u, w);
			}
			System.out.println(new MST().spanningTree(V, E, graph));
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
class MST {
	static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
		for(int i=0; i<V; i++) {
			makeSet(i);
		}
		List<Edge> list = new ArrayList<>();
		for(int i=0; i< V; i++) {
			for(int j=i; j<V; j++) {
				int temp = (graph.get(i)).get(j);
				if(temp==Integer.MAX_VALUE) continue;
				list.add(new MST().new Edge(i, j, (graph.get(i)).get(j)));
			}
		}
		
		//System.out.println(list);
		Collections.sort(list, new MST().new Edge());
		//System.out.println(list);
		int resultWeight=0;
		for(Edge edge: list) {
			int v1Parent =findSet(edge.v1);
			int v2Parent =findSet(edge.v2);
			if(v1Parent==v2Parent) continue;
			else {
				//System.out.println("v1:"+edge.v1+" | v2: "+edge.v2+" | wt: "+edge.weight);
				resultWeight=resultWeight+edge.weight;
				union(edge.v1, edge.v2);
			}
		}
		return resultWeight;
	}
	
	private static Map<Integer, Node> map = new HashMap<>();
	
	class Node {
		int data;
		Node parent;
		int rank;
	}
	
	private static void makeSet(int data) {
		MST.Node node = new  MST().new Node();
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

	//
	
	class Edge implements Comparator<Edge>{
		int v1;
		int v2;
		int weight;
		public Edge() {}
		
		public Edge(int v1, int v2, int weight) {
			this.v1=v1;
			this.v2=v2;
			this.weight=weight;
		}
		
		@Override
		public int compare(Edge e1, Edge e2) {
			// TODO Auto-generated method stub
			return Integer.compare(e1.weight, e2.weight);
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
2
3 3
1 2 5 2 3 3 1 3 1
2 1
1 2 5

Output:
4
5

 
 */

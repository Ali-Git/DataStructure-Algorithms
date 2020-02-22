package com.graph;

//Initial Template for Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DijkstraShortestPath {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int V = sc.nextInt();
			ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
			for (int i = 0; i < V; i++) {
				ArrayList<Integer> temp = new ArrayList<>(V);
				list.add(i, temp);
			}

			for (int i = 0; i < V; i++) {
				ArrayList<Integer> temp = list.get(i);
				for (int j = 0; j < V; j++) {
					temp.add(sc.nextInt());
				}
				list.add(temp);
			}
			int s = sc.nextInt();
			new Implementation().dijkstra(list, s, V);
			System.out.println();

		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
/*
 * ArrayList<ArrayList<Integer>> list: arraylist of arraylist which represents
 * graph src: it represents source vertex V: number of vertex
 */
class Implementation {
	static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V) {

		//Map<Integer, Integer> map = new HashMap<>();
		//Queue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>((a, b)-> (a.get(1)-b.get(1)));
		
		
		//System.out.println(list);
		Map<Integer, Integer> pathMap = new HashMap<>();
		Map<Integer, Integer> distMap = new HashMap<>();
		
		BinaryMinHeap<Integer> bmh = new BinaryMinHeap<>();
		for(int i=0; i<V; i++) {
			if(src==i) bmh.add(0, i); // removing the source node
			else bmh.add(Integer.MAX_VALUE, i);   // value -> key
		}
		distMap.put(src, 0);
		pathMap.put(src, null);
		while(!bmh.empty()) {
			BinaryMinHeap<Integer>.Node extractMinNode = bmh.extractMinNode();
			distMap.put(extractMinNode.key, extractMinNode.weight);
			int current = extractMinNode.key;
			List<Integer> adjList = list.get(current);
			for(int i=0; i< adjList.size(); i++) {
				if(bmh.containsData(i) && adjList.get(i)>0) {
					int crntWeight= distMap.get(current) + adjList.get(i);
					if(bmh.getWeight(i)>crntWeight) {
						bmh.decrease(i, crntWeight);
						pathMap.put(i, current);
					}
				}
			}
		}
		for(int i=0; i<V; i++) {
			if(distMap.containsKey(i)){
				System.out.print(distMap.get(i)+" ");
			}
		}
	}}
/*
----------
0 16 7 21 39 28 38 7 50 6 2 25 31 27 13 20
16 0 48 19 15 16 36 41 23 5 12 38 34 17 49 50
7 48 0 9 29 10 44 5 26 49 31 13 45 35 23 22
21 19 9 0 42 37 19 19 45 12 29 25 11 41 10 5
39 15 29 42 0 33 29 29 41 23 6 1 14 41 10 40
28 16 10 37 33 0 44 39 6 29 21 37 50 35 37 12
38 36 44 19 29 44 0 20 40 50 37 3 32 27 11 41
  7 41 5 19 29 39 20 0 5 44 45 50 50 43 43 18
  50 23 26 45 41 6 40 5 0 47 27 30 47 37 38 6
6 5 49 12 23 29 50 44 47 0 23 1 10 8 7 29
2 12 31 29 6 21 37 45 27 23 0 19 24 46 2 28
25 38 13 25 1 37 3 50 30 1 19 0 14 7 14 1
31 34 45 11 14 50 32 50 47 10 24 14 0 30 23 35
27 17 35 41 41 35 27 43 37 8 46 7 30 0 22 9
13 49 23 10 10 37 11 43 38 7 2 14 23 22 0 21
20 50 22 5 40 12 41 18 6 29 28 1 35 9 21 0

		for(int i=0; i<V; i++) {
			if(distMap.containsKey(i)){
				System.out.print(distMap.get(i)+" ");
			}
		}
---------
1 
3 
0 1 43 1 0 6 43 6 0 
2

OP-7 6 0

1
2
0 25 25 0
0

0 25


1
16
0 16 7 21 39 28 38 7 50 6 2 25 31 27 13 20 16 0 48 19 15 16 36 41 23 5 12 38 34 17 49 50 7 48 0 9 29 10 44 5 26 49 31 13 45 35 23 22 21 19 9 0 42 37 19 19 45 12 29 25 11 41 10 5 39 15 29 42 0 33 29 29 41 23 6 1 14 41 10 40 28 16 10 37 33 0 44 39 6 29 21 37 50 35 37 12 38 36 44 19 29 44 0 20 40 50 37 3 32 27 11 41 7 41 5 19 29 39 20 0 5 44 45 50 50 43 43 18 50 23 26 45 41 6 40 5 0 47 27 30 47 37 38 6 6 5 49 12 23 29 50 44 47 0 23 1 10 8 7 29 2 12 31 29 6 21 37 45 27 23 0 19 24 46 2 28 25 38 13 25 1 37 3 50 30 1 19 0 14 7 14 1 31 34 45 11 14 50 32 50 47 10 24 14 0 30 23 35 27 17 35 41 41 35 27 43 37 8 46 7 30 0 22 9 13 49 23 10 10 37 11 43 38 7 2 14 23 22 0 21 20 50 22 5 40 12 41 18 6 29 28 1 35 9 21 0
8

Its Correct output is:
12 13 10 11 8 6 10 5 0 8 14 7 18 14 15 6

12 13 10 11 8 6 10 5 0 8 14 7 18 14 15 6
43 13 10 29 8 6 10 5 0 8 41 7 18 16 39 6

And Your Code's output is:
25 13 10 46 8 6 10 5 0 8 23 7 18 16 21 6
43 13 10 29 8 6 10 5 0 8 41 7 18 16 39 6

 * 
 * 
 if(bmh.getWeight(i)>crntWeight) {
							if(distMap.containsKey(current))
								bmh.decrease(i, distMap.get(current) + crntWeight);
							else
								bmh.decrease(i, crntWeight);
							pathMap.put(i, current);
						}
 */
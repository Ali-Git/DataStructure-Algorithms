package com.heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthElemInStream {

	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    	while(tc-- >0) {
    		int kth = sc.nextInt();
    		int count = sc.nextInt();
    		Queue<Integer> min_heap = new PriorityQueue<>((a,b)->a.compare(a, b));
    		for(int i=0; i<count; i++) {
    			int elem = sc.nextInt();
    			if(min_heap.size()<kth) {
    				min_heap.add(elem);
    			}
    			else {
    				if(min_heap.peek()<elem) {
    					int pol = min_heap.poll();
    					min_heap.add(elem);
    				}
    			}
    			if(min_heap.size()>=kth) {
    				System.out.print(min_heap.peek()+" ");
    			}else {
    				System.out.print(-1+" ");
    			}
    		}
    		System.out.println();
    	}
	}

}
/*
Input:
2
4 6
1 2 3 4 5 6
1 2
3 4

Output:
-1 -1 -1 1 2 3
3 4 

Explanation:
Testcase1:
k = 4
For 1, the 4th largest element doesn't exist so we print -1.
For 2, the 4th largest element doesn't exist so we print -1.
For 3, the 4th largest element doesn't exist so we print -1.
For 4, the 4th largest element is 1 {1, 2, 3, 4}
For 5, the 4th largest element is 2 {2, 3, 4 ,5}
for 6, the 4th largest element is 3 {3, 4, 5}

*/
package com.heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
//Find median in a stream

public class MedianInStream {
	public static void main (String[] args) {
	    
    	Scanner sc = new Scanner(System.in);
    	int count = sc.nextInt();
    	// 7 3 1 -> Lower Max Heap
    	Queue<Integer> queue_lmh = new PriorityQueue<>((a,b)->a.compare(b, a));
    	// 5 10 15 -> Upper Min Heap
    	Queue<Integer> queue_umh = new PriorityQueue<>((a,b)->a.compare(a, b));
    	for(int i=0; i<count; i++){
    	    int temp= sc.nextInt();
    	    // queue_lower_max_heap && queue_upper_min_heap
            addElementInMinOrMaxHeap(temp, queue_lmh, queue_umh);
            balanceHeaps(queue_lmh, queue_umh);
            printResult(queue_lmh, queue_umh);
    	}
	}
	
	private static void addElementInMinOrMaxHeap(int temp, Queue<Integer> queue_lmh, Queue<Integer> queue_umh){
	    if(queue_umh.size()==0 || temp < queue_umh.peek()){ 
	        queue_lmh.add(temp);
	        //System.out.println("*");
	    }else{
	        queue_umh.add(temp);
	        //System.out.println("#");
	    }	    
	}
	
	private static void balanceHeaps(Queue<Integer> queue_lmh, Queue<Integer> queue_umh){
        if(queue_umh.size() - queue_lmh.size() >=2){
	        queue_lmh.add(queue_umh.poll());
	        //System.out.println("$");
	    }else if(queue_lmh.size() - queue_umh.size() >=2){
	        queue_umh.add(queue_lmh.poll());
	        //System.out.println("&");
	    }
	}
	
    private static void printResult(Queue<Integer> queue_lmh, Queue<Integer> queue_umh){
        if(queue_lmh.size() > queue_umh.size()){
            System.out.println(queue_lmh.peek());
        }else if(queue_lmh.size() < queue_umh.size()){
            System.out.println(queue_umh.peek());
        }else{
            System.out.println((queue_lmh.peek()+queue_umh.peek())/2);
        }
    }
}
/*
Input:
4
5
15
1 
3
Output:
5
10
5
4
 
Explanation:
Testcase 1:
Flow in stream : 5, 15, 1, 3
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3)


*/
package com.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianOfStream {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Queue<Integer> queue = new PriorityQueue<>((a,b)->a.compare(b, a));
		Queue<Integer> queue_list = new LinkedList<>();
		for(int i=0; i<count; i++){
		    int temp= sc.nextInt();
		    queue.add(temp);
		    //System.out.println("*i:"+i+"-"+temp);
		    if (i%2 == 0) {
		    	int pos = i/2;
		    	int poll_elm = 0;
		    	while(pos>0) {
		    		poll_elm = queue.poll();
		    		//System.out.println("e: "+poll_elm);
		    		queue_list.add(poll_elm);
		    		pos--;
		    	}
		    	System.out.println(queue.peek());
		    	while(!queue_list.isEmpty()) {
		    		queue.add(queue_list.poll());
		    	}
		    }else {
		    	int pos = i/2;
		    	int poll_elm = 0;
		    	while(pos>0) {
		    		poll_elm = queue.poll();
		    		//System.out.println("o: "+poll_elm);
		    		queue_list.add(poll_elm);
		    		pos--;
		    	}
		    	int a = queue.poll();
		    	int b = queue.poll();
		    	queue_list.add(a);
		    	queue_list.add(b);
		    	System.out.println((a+b)/2);
		    	//System.out.println("oo: "+queue.peek());
		    	while(!queue_list.isEmpty()) {
		    		queue.add(queue_list.poll());
		    	}
		    }
		}
	}
	
    
    //Using merge sort -> TLE  || so didn't go with this approach
	/*
	 * mergeSort(arr, 0, i); if(i%2==0){ int even_i = i/2;
	 * System.out.println("*i:"+i+" | "+arr[even_i]); }else{ int odd_i = i/2; int
	 * res = (arr[odd_i] + arr[odd_i+1])/2; System.out.println("*i:"+i+" | "+res); }
	 */
	
    private static void mergeSort(int arr[], int l, int r){
        if(l<r){
            int m = (r + l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    
    private static void merge(int arr[], int l, int m, int r){
        int arrL[] = new int[m-l+1+1];
        int arrR[] = new int[r-m+1];
        int arrL_i=0;
        int arrR_i=0;
        for(int i=l; i<=r; i++){
            if(i<=m){
                arrL[arrL_i++]=arr[i];
            }else{
                arrR[arrR_i++]=arr[i];
            }
        }
        arrL_i=0;
        arrR_i=0;
        arrL[arrL.length-1]=Integer.MAX_VALUE;
        arrR[arrR.length-1]=Integer.MAX_VALUE;
        for(int i=l; i<=r; i++){
            if(arrL[arrL_i] < arrR[arrR_i]){
                arr[i] = arrL[arrL_i];
                arrL_i++;
            }else{
                arr[i] = arrR[arrR_i];
                arrR_i++;
            }
            
        }
        
    }	
}

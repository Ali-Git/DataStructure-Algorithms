package com.stack;

import java.util.Scanner;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/stock-span-problem/0
//Stock span problem
public class StockSpanProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int size = sc.nextInt();
		    int arr[] = new int[size];
		    for(int i=0; i<size; i++){
		        arr[i]=sc.nextInt();
		    }
		    Stack<Integer> st = new Stack<>();
		    for(int i=0; i<size; i++) {
		    	int current = arr[i];
		    	int counter=1;
		    	
		    	Stack<Integer> tempStack = new Stack<>();
		    	while(!st.empty()) {
		    		if(current>=st.peek()) {
		    			tempStack.push(st.pop());
		    			counter++;
		    		}else break;
		    	}
		    	
		    	while(!tempStack.empty()) {
		    		st.push(tempStack.pop());
		    	}
		    	System.out.print(counter+" ");
		    	st.push(current);
		    }
		    System.out.println();
		}
	}

}
/*


Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1

*/
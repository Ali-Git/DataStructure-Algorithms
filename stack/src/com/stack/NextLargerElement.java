package com.stack;

import java.util.Scanner;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/next-larger-element/0
//Next larger element
public class NextLargerElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int size = sc.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			Stack<Integer> stack = new Stack<>();
			int last = Integer.MIN_VALUE;
			int greatest = Integer.MIN_VALUE;
			for (int i = size - 1; i >= 0; i--) {
				int res = -1;
				if(last>arr[i]) res=last;
				else if(greatest<arr[i] || stack.empty()) {
					
				}
				else {
					Stack<Integer> tempStack = new Stack<>();
					while (!stack.empty()) {
						int pop = stack.pop();
						if(pop > arr[i]) {
							res=pop;
							stack.push(pop);
							break;
						}
						tempStack.push(pop); 
					}
					while(!tempStack.empty()) {
						stack.push(tempStack.pop());
					}
				}
				stack.push(res);
				//System.out.print(res + " ");
				last = arr[i];
				if(greatest<arr[i]) greatest=arr[i];
			}
			while(!stack.empty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
	}
}
/*
Input:
1
14
10 3 12 4 2 9 13 0 8 11 1 7 5 6

12 12 13 9 9 13 -1 8 11 -1 7 -1 6 -1

And Your Code's output is:
12 12 -1 9 9 13 -1 8 11 -1 7 -1 6 -1
 * 
Input 
1
5 
1 3 2 8 7
 
1 
4 
1 3 2 4

1
4 
4 3 2 1
 * 
 Output 
 3 4 4 -1 
 -1 -1 -1 -1
 
 
 

 
 * 
 */

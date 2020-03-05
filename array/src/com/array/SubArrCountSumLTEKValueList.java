package com.array;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/count-of-subarrays/0
public class SubArrCountSumLTEKValueList {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		while(tc-- >0) {
			int arrL = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[arrL];
			for(int i=0; i<arrL; i++) {
				arr[i]= sc.nextInt();
			}
			int i=0, j=0;
			int counter=0;
			int totalSubArrayCount = (arrL * (arrL+1))/2;
			while(i<arrL && j<arrL) {
				
				if(arr[j]<=k) {
					counter +=j-i+1;
					j++;
				}else {
					j++;
					i=j;
				}
			}
			
			System.out.println(totalSubArrayCount-counter);
		}
	}

}

/*
Input:
2
3 2
3 2 1
4 1
1 2 3 4

Output:
3
9

*/




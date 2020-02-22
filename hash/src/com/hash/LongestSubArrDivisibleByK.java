package com.hash;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k/0/
// Longest subarray with sum divisible by K
public class LongestSubArrDivisibleByK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
			int arrSize = sc.nextInt();
		    int div = sc.nextInt();
		    int arr[] = new int[arrSize];
		    for(int i=0; i<arrSize; i++){
		        arr[i]=sc.nextInt();
		    }
		}
	}

}


/*
Input:
2
6 3
2 7 6 1 4 5
7 3
-2 2 -5 12 -11 -1 7
Output:
4
5

Explanation:

Input : A[] = {2, 7, 6, 1, 4, 5}, K = 3
Output : 4
The subarray is {7, 6, 1, 4} with sum 18,
which is divisible by 3.
*/













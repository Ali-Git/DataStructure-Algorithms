package com.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0
// Longest Sub-Array with Sum K
public class LongestSubArrSumK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int arrSize = sc.nextInt();
		    int reqSum = sc.nextInt();
		    int arr[] = new int[arrSize];
		    for(int i=0; i<arrSize; i++){
		        arr[i]=sc.nextInt();
		    }
		    int sum=0, maxLength=0;
		    Map<Integer, Integer> map = new HashMap<>();
		    for(int i=0; i<arrSize; i++){
		    	sum += arr[i];
		    	if(!map.containsKey(sum)) map.put(sum, i);
		        if(map.containsKey(sum-reqSum) && i-map.get(sum-reqSum) > maxLength)
		        	maxLength = i-map.get(sum-reqSum);
		        if(sum==reqSum) 
		        	maxLength = i+1;
		    }
		    System.out.println(maxLength);
		}
	}

}


/*
Input:
3
6 15
10 5 2 7 1 9
6 -5
-5 8 -14 2 4 12
3 6
-1 2 3
Output:
4
5
0
Explanation:
TestCase 1:

Input : arr[] = { 10, 5, 2, 7, 1, 9 }, 
K = 15
Output : 4
The sub-array is {5, 2, 7, 1}.





2
10 3
1 2 3 -3 -2 -1 4 1 0 1
8 5
1 2 3 -4 -5 3 3 1
Output of Online Judge is:
8
2


1
10 3
1 2 3 -3 -2 -1 4 1 0 1

OP-8
And Your Code's output is:
6
*/




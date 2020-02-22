package com.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0
// Zero Sum Subarrays
public class ZeroSumSubArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int size = sc.nextInt();
		    int arr[]=new int[size];
		    for(int i=0; i<size; i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(countZeroSum(arr, size));
		}
	}
	
	
	private static int countZeroSum(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int preSum = 0;
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == 0)
				res++;

			if (!map.containsKey(preSum)) {
				map.put(preSum, 1);
			} else {
				res += map.get(preSum);
				int tmp = map.get(preSum);
				map.put(preSum, ++tmp);
			}
		}

		return res;
	}
	

}


/*
2
6
0 0 5 5 0 0
10
6 -1 -3 4 -2 2 4 6 -12 -7

Output:
6
4

--
1
30
9 -10 -1 5 17 -18 6 19 -12 5 18 14 4 -19 11 8 -19 18 -20 14 8 -14 12 -12 16 -11 0 3 -19 16


Its Correct output is:
11

And Your Code's output is:
9
*/

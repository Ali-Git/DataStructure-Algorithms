package dynamic_programming;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/maximum-sub-array/0
public class MaxSumSubArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0) {
			int arrL = sc.nextInt();
			int arr[] = new int[arrL];
			int dp[] = new int[arrL];
			for(int i=0; i<arrL; i++) {
				arr[i]=sc.nextInt();
			}
			int max = arr[0];
			int resJ=0;
			dp[0]=arr[0];
			for(int i=1; i<arrL; i++) {
				dp[i]=max(dp[i-1] +arr[i], arr[i]);
				if(max<dp[i]) {
					max=dp[i];
					resJ=i;
				}
			}
			int resI=resJ;
			//System.out.println("MaxSum: "+max);
			while(max!=0 && resI>=0) {
				max -= arr[resI];
				if(max>0) resI--;
			}
			//System.out.println("resI: "+resI+" | resJ: "+resJ);
			for(int i=resI; i<=resJ; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
		}
	}

	private static int max(int i, int j) {
		return i>j?i:j;
	}
}

/*
Input
2
3
1 2 3
2
-1  2
Output
1 2 3
2




Input:
1
12
8 5 -3 -4 1 8 -1 2 -3 9 5 4

Its Correct output is:
9 5 4

And Your Code's output is:
8 5 -3 -4 1 8 -1 2 -3 9 5 4
*/







package dynamic_programming;

import java.util.Scanner;

public class MaxSumSubArrOfNonNegativeNumbers {

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
				if(arr[i]>=0) {
					dp[i]=max(dp[i-1] +arr[i], arr[i]);
					if(max<=dp[i]) {
						max=dp[i];
						resJ=i;
					}
				}else {
					dp[i]=arr[i];
					
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
1
13
9 -7 -9 -1 8 6 5 0 -8 -2 -4 -10 -8

-------
1
5
-2 -4 -5 0 -1

Its Correct output is:
0

And Your Code's output is:
-1

*/






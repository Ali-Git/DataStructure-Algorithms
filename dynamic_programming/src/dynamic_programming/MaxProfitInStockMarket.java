package dynamic_programming;

import java.util.Scanner;

public class MaxProfitInStockMarket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int trans_count = sc.nextInt();
			int days = sc.nextInt();
			int[] profit_per_day = new int[days];
			int [][] result_max_profit = new int[trans_count+1][days];
			int i=0;
			int days_counter = days;
			while(days_counter-- >0) {
				profit_per_day[i++]=sc.nextInt();
			}
			for(int j=0; j<trans_count+1; j++) {
				int maxDiff=0;
				// this maxDiff is used to directly use second step 
				// where we already hold the max difference by looking at the plot of the matrix
				for(int k=0; k<days; k++) {
					if(j==0) continue;
					if(k==0) {
						maxDiff=result_max_profit[j-1][0]-profit_per_day[0];
						continue;
					}
					int temp = result_max_profit[j-1][k-1]-profit_per_day[k];
					if(maxDiff<temp) {
						maxDiff=temp;
					}
					result_max_profit[j][k]=getMaxVal(result_max_profit[j][k-1], profit_per_day[k]+maxDiff);
				}
			}
			System.out.println(result_max_profit[trans_count][days-1]);
		}

	}
	
	private static int getMaxVal(int i, int j) {
		return i>j?i:j;
	}

}


/*
 * 
 Examples 

Input
3
2
6
10 22 5 75 65 80
3
4
20 580 420 900
1
5
100 90 80 50 25

Output
87
1040
0
 

Explanation:
Output 1: Trader earns 87 as sum of 12 and 75  i.e. Buy at price 10, sell at 22, buy at  5 and sell at 80
Output 2: Trader earns 1040 as sum of 560 and 480 i.e. Buy at price 20, sell at 580, buy at 420 and sell at 900
Output 3: Trader cannot make any profit as selling price is decreasing day by day.Hence, it is not possible to earn anything.
 
 
 * */

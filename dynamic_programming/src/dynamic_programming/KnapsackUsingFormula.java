package dynamic_programming;

import java.util.Scanner;
//

public class KnapsackUsingFormula {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int item_count = sc.nextInt();
			int max_wt = sc.nextInt();
			int[][] knapsArr = new int[item_count+1][max_wt + 1];
			//System.out.print("item_count:" + item_count);
			int wt[] = new int[item_count];
			int val[] = new int[item_count];
			System.out.print("wt: ");
			for (int i = 0; i < item_count; i++) {
				wt[i] = sc.nextInt();
				System.out.print(wt[i]+" ");
			}
			System.out.print("\nval: ");
			for (int i = 0; i < item_count; i++) {
				val[i] = sc.nextInt();
				System.out.print(val[i]+" ");
			}
			System.out.println();
			for (int i = 0; i < item_count+1; i++) {
				for (int j = 0; j < max_wt + 1; j++) {
					if(i==0) break;
					if (j < wt[i-1]) {
						knapsArr[i][j] = knapsArr[i - 1][j];
					} else {
						
						knapsArr[i][j] = getMaxVal(val[i-1]+ knapsArr[i-1][j-wt[i-1]], knapsArr[i-1][j]);
					}
				}
			}
			System.out.println("result: " + knapsArr[item_count][max_wt]);
		}
	}
	
	private static int getMaxVal(int i, int j) {
		return i>j?i:j;
	}

}
/*
1 - tc
3 - item count
3 - wt ? for total weight 3 we have to find the maximum value.
1 2 3 
4 5 1



 1 
 3 
 3 
 1 2 3 
 4 5 1
 op-9
 * /
 */


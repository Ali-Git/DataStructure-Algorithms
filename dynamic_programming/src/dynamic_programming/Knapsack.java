package dynamic_programming;

import java.util.Scanner;

public class Knapsack {

	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			count = 0;
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
						
						knapsArr[i][j] = getMaxVal(i, j, knapsArr, wt, val);
					}
				}
			}
			int max = knapsArr[item_count][max_wt];
			System.out.println("knapsArr: " + knapsArr);
			for (int i = item_count; i >= 0; i--) {
				for (int j = max_wt; j >= 0; j--) {
					if(i==0) break;
					if (knapsArr[i][j - 1] < max) {
						if (knapsArr[i - 1][j] != max) {
							System.out.print(wt[i-1] + " ");
							count++;
							max = max - val[i-1];
						}
						break;
					}
				}
			}
		}
	}
	
	private static int getMaxVal(int i, int j, int[][] knapsArr, int[] wt, int[] val) {
		int left_wt = j - wt[i-1];
		int prev = knapsArr[i-1][j];
		int current= val[i-1];
		int wtl=0;
		for(int k=0;k<i-1;k++) {
			wtl=wtl+wt[k];
		}
		while(left_wt>wtl) {
			left_wt--;
		}
		if(left_wt>0 && wtl>0) {
			current= current + knapsArr[i][left_wt];
		}
		return prev>current?prev:current;
	}

}

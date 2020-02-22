package dynamic_programming;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Coin Change -> Different comb of coins to get the sum

public class CoinChangingWaysToSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int coint_count = sc.nextInt();
			int coins[] = new int[coint_count];
			Queue<Integer> queue = new PriorityQueue<>((a, b)->a.compare(a, b));
			for(int i=0; i<coint_count; i++) {
				queue.add(sc.nextInt());
			}
			for(int i=0; i<coint_count; i++) {
				coins[i]=queue.poll();
			}
			int sum = sc.nextInt();
			int R[][] = new int[coint_count+1][sum+1];
			for(int i=1; i<coint_count+1; i++) {
				for(int j=0; j<sum+1; j++) {
					if(j==0) {
						R[i][j]=1;
						continue;
					}
					if(j>=coins[i-1]) {
						R[i][j] = R[i-1][j] + R[i][j - coins[i-1]];
					}else {
						R[i][j]=R[i-1][j];
					}
				}
			}
			System.out.println(R[coint_count][sum]);
			
		}

	}

}

/*
Input:
2
3
1 2 3
4
4
2 5 3 6
10

Output:
4
5

Explanation:
Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.
*/

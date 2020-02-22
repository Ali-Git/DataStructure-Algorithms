package dynamic_programming;

import java.util.Scanner;
// Minimum Coin to get the sum..
public class CoinChangingMinCoinsSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int coint_count = sc.nextInt();
			System.out.println("cc: "+coint_count);
			int coins[] = new int[coint_count+1];
			for(int i=1; i<coint_count+1; i++) {
				coins[i]=sc.nextInt();
				System.out.println(coins[i]+" ");
			}
			System.out.println();
			int sum = sc.nextInt();
			System.out.println("sum: "+sum);
			int R[][] = new int[coint_count+1][sum+1];
			for(int i=0; i<coint_count+1; i++) {
				for(int j=0; j<sum+1; j++) {
					if(i==0 || j==0) continue;
					if(j<coins[i]) {
						R[i][j]=R[i-1][j];
					}else {
						R[i][j] = min(R[i-1][j], R[i][j-coins[i]]+1);
					}
				}
			}
			System.out.println(R);
		}
		
		

	}
	
	private static int min(int val1, int val2) {
		if(val1==0) return val2;
		return val1<val2?val1:val2;
	}

}

/*
 1
4
1 5 6 8
11

output - 2 (5,6)
 */

package dynamic_programming;

import java.util.Scanner;
// taking multiple pieces of rod is allowed

public class RodCuttingMaxProfit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int count = sc.nextInt();
			int []rod = new int[count];
			int R[][] = new int[count+1][count+1];
			for(int i=0; i<count; i++) {
				rod[i] = sc.nextInt();
			}
			for(int i=1; i<count+1; i++) {
				for(int j=0; j<count+1; j++) {
					if(j>=i) {
						R[i][j]= getMax(R[i-1][j], rod[i-1] + R[i][j- i]);
						
					}else {
						R[i][j] = R[i-1][j];
					}
				}
			}
			System.out.println(R[count][count]);
		}

	}
	
	private static int getMax(int val1, int val2) {
		return val1>val2?val1:val2;
	}

}
/**
 * 
 Example:
Input:
1
8
1 5 8 9 10 17 17 20
Output:
22

 */

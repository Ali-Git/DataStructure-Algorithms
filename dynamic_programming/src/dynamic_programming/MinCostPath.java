package dynamic_programming;

import java.util.Scanner;
// Minimum Cost Path (Tushar-22) it wont solve gfg problem becoz they don't expect diagonal move  
public class MinCostPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int count = sc.nextInt();
			int R[][] = new int[count][count];
			for(int i=0; i<count; i++) {
				for(int j=0; j<count; j++) {
					R[i][j] = sc.nextInt();
				}
			}
			for(int i=0; i<count; i++) {
				for(int j=0; j<count; j++) {
					if(i==0 && j==0) continue;
					if(i==0) {
						R[i][j] = R[i][j] + R[i][j-1];
					}else if(j==0){
						R[i][j] = R[i-1][j] + R[i][j];
					}else {
						R[i][j] = R[i][j] + min(R[i][j-1], R[i-1][j]);
					}
				}
			}
			System.out.println(R[count-1][count-1]);
		}

	}
	
	private static int min(int val1, int val2) {
		return val1<val2?val1:val2;
	}

}
/*
Input:
2
5
31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20
2
42 93 7 14

Output:
327
63

Explanation:
Testcase 1:
Grid is:
31, 100, 65, 12, 18,
10, 13, 47, 157, 6,
100. 113, 174, 11, 33,
88, 124, 41, 20, 140,
99, 32, 111, 41, 20
A cost grid is given in below diagram, minimum
cost to reach bottom right from top left
is 327 (31 + 10 + 13 + 47 + 65 + 12 + 18 + 6 + 33 + 11 + 20 + 41 + 20)
*/

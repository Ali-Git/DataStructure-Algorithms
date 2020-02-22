package dynamic_programming;

import java.util.Scanner;

public class OptimalBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int keyAndFreqCount = sc.nextInt();
			int keys[] = new int[keyAndFreqCount];
			int freqs[] = new int[keyAndFreqCount];
			for(int i=0; i<keyAndFreqCount; i++) {
				keys[i]=sc.nextInt();
			}
			int R[][]=new int[keyAndFreqCount+1][keyAndFreqCount+1];
			for(int i=0; i<keyAndFreqCount; i++) {
				freqs[i]=sc.nextInt();
				R[i][i+1] = freqs[i]; // l=1 is filled here [0,1] means only single node
			}
			for(int l=2; l<keyAndFreqCount+1; l++) {
				for(int i=0; i<keyAndFreqCount+1; i++) {
					for(int j=i+l; j<keyAndFreqCount+1; j++) {
						R[i][j] = getMin(i, j, R, freqs);
						break;
					}
				}
			}

			System.out.println(R[0][keyAndFreqCount]);
		}

	}
	private static int getMin(int i, int j, int R[][], int []freqs) {
		int fwt = getFreqWt(i, j, freqs); // i should not be included [0,1] means 1 element |||y [0,2] means 2 element (1,2) | 0 should be excluded
		int min=Integer.MAX_VALUE;
		int root_index=0;
		for(int m=i; m<j; m++) {
			int temp = R[i][m] + R[m+1][j] + fwt;
			if(temp<min) {
				min =temp;
				root_index = m+1;
			}
		}
		System.out.println("root_index: "+root_index);
		return min;

	}
	
	private static int getFreqWt(int i, int j, int freqs[]) {
		int fwt = 0;
		for(int k=i+1; k<=j; k++) {
			fwt = fwt + freqs[k-1];
		}
		return fwt;
	}
}
/*
 * 
 Input:
2
2
10 12
34 50
3
10 12 20
34 8 50
Output:
118
142
 */

/*

1
3
10 12 20
34 8 50

*/
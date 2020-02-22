package dynamic_programming;

import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int matrix_count = sc.nextInt();
			int[] msa = new int[matrix_count];// matrix_size_arr
			int[][] R = new int[matrix_count-1][matrix_count-1];// result_matrix_count
			for(int i=0; i<matrix_count; i++) {
				msa[i]=sc.nextInt();
			}
			for(int i=0; i<matrix_count; i++) {
				for(int j=0; j<matrix_count; j++) {
					if(i==j) continue;
					R[i][j]=calculateMin(R, msa, i, j);
				}
			}
			System.out.println(R);
		}

	}
	
	private static int calculateMin(int[][]R, int[]msa, int i, int j) {
		int min =0;
		int temp=0;
		for(int m=i; m<j; m++) {
			temp = R[i][m] + R[m+1][j] + msa[i] * msa[i+1+m] * msa[j+1];
			if(temp<min) min=temp;
		}
		if(min==0) min=temp;
		return min;
	}

}

/*
 Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
38
27
 */

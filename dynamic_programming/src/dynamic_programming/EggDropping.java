package dynamic_programming;

import java.util.Scanner;
//Egg Dropping Puzzle
public class EggDropping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int eggs = sc.nextInt();
			int floors = sc.nextInt();
			int R[][]= new int[eggs+1][floors+1];
			for(int i=1; i<=eggs; i++) {
				for(int j=1; j<=floors; j++) {
					if(i==1) {
						R[i][j] = j;
					}else if(j<i){
						R[i][j] = R[i-1][j];
					}else {
						R[i][j] = getMinOfMax(i, j, R);
					}
				}
			}
			System.out.println(R[eggs][floors]);
		}

	}
	
	private static int getMinOfMax(int i, int j, int R[][]) {
		int min = Integer.MAX_VALUE;
		for(int m=1; m<=j; m++) {
			int temp=0;
			if(m==1) {
				temp = 1 + getMax(0, R[i][j-m]);
			}else if(m==j) {
				temp = 1 + getMax(R[i-1][m-1], 0);
			}else {
				temp = 1 + getMax(R[i-1][m-1], R[i][j-m]);
			} 
			if(min>temp) min = temp;
		}
		return min;
	}
	
	private static int getMax(int val1, int val2) {
		return val1>val2?val1:val2;
	}

}
/*
Input:
2
2 10
3 5

Output:
4
3
*/

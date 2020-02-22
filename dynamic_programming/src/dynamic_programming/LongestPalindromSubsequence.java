package dynamic_programming;

import java.util.Scanner;

public class LongestPalindromSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String str = sc.next();
			int str_l = str.length();
			int R[][] = new int[str_l][str_l];
			for(int l=0; l<str_l; l++) {
				for(int i=0; i<str_l; i++) {
					for(int j=i+l; j<str_l; j++) {
						if(l==0 && i==j) {
							R[i][j] = 1;
							break;
						}
						if(str.charAt(i)==str.charAt(j)) {
							R[i][j] = R[i+1][j-1] +2;
						}else {
							R[i][j] = R[i][j-1] > R[i+1][j] ? R[i][j-1] : R[i+1][j];
						}
						break;
					}
				}
			}
			System.out.println(R[0][str_l-1]);
		}

	}

}

/*
 Input:
2
bbabcbcab
abbaab
Output:
7
4 

 * 
 */

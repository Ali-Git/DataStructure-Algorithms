package dynamic_programming;

import java.util.Scanner;
//Longest Common Subsequence
public class LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int st1_length = sc.nextInt();
			int st2_length = sc.nextInt();
			String st1 = sc.next();
			String st2 = sc.next();
			char[] arr1 = st1.toCharArray();
			char[] arr2 = st2.toCharArray();
			int res[][] = new int[arr1.length+1][arr2.length+1];
			for(int i=0; i<arr1.length+1; i++) {
				for(int j=0; j<arr2.length+1; j++) {
					if(i==0 || j==0) continue;
					if(arr1[i-1] == arr2[j-1]) {
						res[i][j]=res[i-1][j-1]+1;
					}else {
						res[i][j] = getMaxVal(res[i-1][j], res[i][j-1]);
					}
				}
			}
			
			System.out.println(res[arr1.length][arr2.length]);
			
		}

	}
	
	private static int getMaxVal(int i, int j) {
		return i>j?i:j;
	}

}

/*
 * 
 * 
 Input:
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC

Output:
3
2

Explanation
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

LCS of "ABC" and "AC" is "AC" of length 2
 */

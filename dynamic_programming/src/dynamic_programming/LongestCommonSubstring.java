package dynamic_programming;

import java.util.Scanner;
// Longest Common Substring
public class LongestCommonSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int st1_l = sc.nextInt();
			int st2_l = sc.nextInt();
			String str1 = sc.next();
			char[] str1_arr = str1.toCharArray();
			String str2 = sc.next();
			char[] str2_arr = str2.toCharArray();
			int R[][] = new int[st1_l+1][st2_l+1];
			int count = 0;
			for(int i=1; i<st1_l+1; i++) {
				for(int j=1; j<st2_l+1; j++) {
					if(str1_arr[i-1]==str2_arr[j-1]) {
						R[i][j]= R[i-1][j-1] +1;
						if(R[i][j]>count) count=R[i][j];
					}
				}
			}
			System.out.println(count);
			
		}

	}

}
/*
Input:
2
6 6
ABCDGH
ACDGHR
3 2
ABC
AC

Output:
4
1

Example:
Testcase 1: CDGH is the longest substring present in both of the strings
*/
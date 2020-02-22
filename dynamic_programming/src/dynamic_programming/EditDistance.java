package dynamic_programming;

import java.util.Scanner;

// Edit Distance of opeations add, remove, replace
public class EditDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int st1_length = sc.nextInt();
			int st2_length = sc.nextInt();
			System.out.println("l1: "+st1_length);
			System.out.println("l1: "+st2_length);
			String st1 = sc.next();
			String st2 = sc.next();
			System.out.println("st1: "+st1);
			System.out.println("st2: "+st2);
			int R[][] = new int[st1_length+1][st2_length+1];
			for(int i=0; i<st1_length+1; i++) {
				for(int j=0; j<st2_length+1; j++) {
					if(i==0) {
						R[i][j]=j;
						continue;
					}
					if(j==0) {
						R[i][j]=i;
						continue;
					}
					
					if(st1.charAt(i-1)==st2.charAt(j-1)) {
						R[i][j] = R[i-1][j-1];
					}else {
						R[i][j] = minOf3(R[i][j-1], R[i-1][j], R[i-1][j-1])+1;
					}
				}
			}
			System.out.println(R[st1_length][st2_length]);
		}

	}
	
	private static int minOf3(int val1, int val2, int val3) {
		return (val1<val2?val1:val2)<val3?(val1<val2?val1:val2):val3;
	}

}
/*
Input:
1
4 5
geek gesek

Output:
1

Explanation:
Testcase 1: One operation is required to make 2 strings same i.e. removing 's' from str2.
*/
package com.array;

import java.util.Scanner;

public class Rotate2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0) {
			int n = sc.nextInt();
			int arr[][]=new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int f=n;
			int s=f;
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<s-1; j++) {
					
					int temp = arr[i+j][f-1];
					arr[i+j][f-1]=arr[i][j+i];
					arr[i][j+i]=temp;
					
					temp = arr[f-1][f-j-1];
					arr[f-1][f-j-1] = arr[i][j+i];
					arr[i][j+i]=temp;
					
					temp=arr[f-j-1][i];
					arr[f-j-1][i] = arr[i][j+i];
					arr[i][j+i]=temp;
					
				}
				s=s-2;
				f=f-1;
			}

			
			System.out.println(arr);
		}
	}

}

/*

Input:

2
3
1 2 3 4 5 6 7 8 9
2
56 96 91 54


1
4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16

Output:

7 4 1 8 5 2 9 6 3
91 56 54 96

*/




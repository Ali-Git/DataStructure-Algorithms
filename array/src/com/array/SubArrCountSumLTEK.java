package com.array;

import java.util.Scanner;

// SubArrCountSumLTEK => Sum <=K    "LTEK means"
public class SubArrCountSumLTEK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0) {
			int arrL = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[arrL];
			for(int i=0; i<arrL; i++) {
				arr[i]=sc.nextInt();
			}
			int totalSubArrCount = (arrL * (arrL+1))/2;
			int i=0, j=0;
			int sum=arr[0], counter=0;
			while(i<arrL && j<arrL) {
				if(sum<=k) {
					j++;
					if(j>=i) counter +=j-i;
					if(j<arrL) {
						sum +=arr[j];
					}
				}
				else {
					sum -=arr[i];
					i++;
				}
			}
			System.out.println(totalSubArrCount);
			System.out.println(counter);
		}

	}

}
/*

Input:
1
3 2
3 2 1


Output:
4


*/

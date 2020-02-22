package dynamic_programming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int count = sc.nextInt();
			int []arr = new int[count];
			int R[] = new int[count];
			for(int i=0; i<count; i++) {
				arr[i] = sc.nextInt();
				R[i]=1;
				System.out.print(arr[i]+" ");
			}
			int longestSeq=1;
			System.out.println();
			for(int i=1; i<count; i++) {
				for(int j=0; j<=i; j++) {
					if(j==i) {
						i=i+1;
						j=0;
						if(i>=count) break;
					}
					if(arr[j]<arr[i]) {
						int temp = R[j]+1;
						if(temp>R[i]) R[i]=temp;
						if(R[i]>longestSeq) longestSeq = R[i];
					}
					
				}
			}
			System.out.println(longestSeq);
			
		}

	}

}


package bst.pre.pro;

import java.util.Scanner;

public class PreBstArrayCheck {
	
	private static boolean flag = true;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
        	int node_count = sc.nextInt();
        	int pre[] = new int[node_count];
        	for(int i=0; i<node_count; i++) {
        		pre[i]=sc.nextInt();
        	}
        	flag = true;
        	checkBST(pre, 0, pre.length-1);
        	System.out.println(flag?1:0);
        }

	}
	
	private static void checkBST(int pre[], int min, int max) {
		if(max>min) {
			int i=min;
			for(i=min; i<=max; i++) {
				if(pre[min]<pre[i]) { 
					break;
				}
			}
			if(i-1 >= min+1) {
				for(int k=min+1; k<=i-1; k++) {
					if (pre[min]<pre[k]) {
						flag=false;
						return;
					}
				}
				checkBST(pre, min+1, i-1);
			} 
			if(max >= i) {
				for(int k=i; k<=max; k++) {
					if (pre[min]>pre[k]) {
						flag=false;
						return;
					}
				}
				checkBST(pre, i, max); 
			}
		}
	}
}
/*
Input:
3
5
40 30 35 80 100
8
40 30 32 35 80 90 100 120
8
7  9 6 1 4 2 3 40

Output:
1
1
0



1
37
61 30 28 47 42 25 41 56 27 45 44 34 46 35 58 36 60 29 53 55 32 31 33 59 50 51 52 37 39 38 43 49 54 57 40 26 48
*/
package bst.pre.pro;

import java.util.Scanner;

public class PreBstLeafPrint {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
        	int node_count = sc.nextInt();
        	int pre[] = new int[node_count];
        	for(int i=0; i<node_count; i++) {
        		pre[i]=sc.nextInt();
        	}
        	createBST(pre, 0, pre.length-1);
        	System.out.println();
        }

	}
	
	private static void createBST(int pre[], int min, int max) {
		if(min==max) System.out.print(pre[min]+" ");
		if(max>min) {
			int i=min;
			for(i=min; i<=max; i++) {
				if(pre[min]<pre[i]) {
					break;
				}
			}
			if(i-1 >= min+1) {
				createBST(pre, min+1, i-1);
				//if(i-1==min+1) System.out.print(pre[min+1]+" ");
			}
			if(max >= i) {
				createBST(pre, i, max);
				//if(max==i) System.out.print(pre[i]+" ");
			}
		}
	}
}

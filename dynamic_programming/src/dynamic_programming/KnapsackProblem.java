package dynamic_programming;

import java.util.Scanner;

public class KnapsackProblem {

	private static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
			count=0;
		    int item_count = sc.nextInt();
		    int max_wt = sc.nextInt();
		    int[][] knapsArr = new int[item_count][max_wt+1];
		    System.out.print("item_count: "+item_count);
		    int wt[] = new int[item_count];
		    int val[] = new int[item_count];
            for(int i=0; i<item_count; i++){
                wt[i] = sc.nextInt();
                System.out.print("wt: "+wt[i]);
            }
            for(int i=0; i<item_count; i++){
                val[i] = sc.nextInt();
                System.out.print("val: "+val[i]);
            }
		    
            for(int i=0; i<item_count; i++) {
            	for(int j=0; j<max_wt+1; j++) {
            		if(j<wt[i]) {
            			if(i-1 >=0) knapsArr[i][j]=knapsArr[i-1][j];
            		}else {
            			int left_wt = j-wt[i];
            			knapsArr[i][j]=getMaxVal(i, j, left_wt, knapsArr, wt, val);
            		}
            	}
            }
            int max = knapsArr[item_count-1][max_wt];
            System.out.println("knapsArr: "+knapsArr);
            for(int i=item_count-1; i>=0; i--) {
            	for(int j=max_wt; j>=0; j--) {
            		if(knapsArr[i][j-1]<max) {
            			if(i-1<0) {
            				System.out.print(wt[i]);
            				count++;
            				break;
            			}
            			if(knapsArr[i-1][j]!=max) {
            				System.out.print(wt[i]+" ");
            				count++;
            				max=max-val[i];
            			}
            			break;
            		}
            	}
            }
		}
	}
	
	private static int getMaxVal(int i, int j, int left_wt, int[][] knapsArr, int[] wt, int[] val) {
		int prev = 0;
		if(i-1 >= 0)prev = knapsArr[i-1][j];
		int current= val[i];
		int wtl=0;
		for(int k=0;k<i;k++) {
			wtl=wtl+wt[k];
		}
		while(left_wt>wtl) {
			left_wt--;
		}
		if(left_wt>0 && wtl>0) {
			current= current + knapsArr[i][left_wt];
		}
		return prev>current?prev:current;
	}
}

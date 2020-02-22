package stack.histogram;

import java.util.*;
import java.lang.*;
class MaxRect{
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0){
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] a=new int[50][50];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		GfG g=new GfG();
		
		System.out.println(g.maxArea(a,m,n));
	}
}
}


/*This is a function problem.You only need to complete the function given below*/
/*Complete the function given below*/
class GfG{
    public int maxArea(int a[][],int m,int n){
    	int global_hist=0;
    	int arr[] = new int[n+1];
    	for(int k=0; k<m; k++) {
    		for(int j=0;j<n; j++) {
    			if(k==0) {
    				arr[j]=a[k][j];
    			}else {
    				if(a[k][j]>0) arr[j] = arr[j] +a[k][j];
    				else arr[j]=0;
    			}
    		}
    		
    		//
    		Stack<Integer> st = new Stack<>();
			st.push(0);
			int gt_hist=0;
			for(int i=1; i<n+1; i++) {
				if(arr[st.peek()] > arr[i]) {
					while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
						int p = st.pop();
						int hist=0;
						if(st.isEmpty()) {
							hist = arr[p]*i;
						}else {
							hist = arr[p]*(i-st.peek()-1);
						}
						if(gt_hist < hist) gt_hist=hist;
					}
					st.push(i);
				}else {
					st.push(i);
				}
				
			}
			//System.out.println(gt_hist);
			if(gt_hist> global_hist) global_hist=gt_hist;
    	}
        return global_hist;
    }
}

/*
1
4 4 
0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0
op-8


*/
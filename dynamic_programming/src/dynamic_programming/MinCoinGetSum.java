package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MinCoinGetSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int v = sc.nextInt();
		    int n = sc.nextInt();
		    int res[] = new int[v+1];
		    for(int j=1; j<=v; j++){
		    	res[j]=Integer.MAX_VALUE;
		    }
		    for(int i=0; i<n; i++) {
		    	int temp=sc.nextInt();
		    	for(int j=1; j<=v; j++) {
		    		if(j>=temp) {
		    			int min=res[j];
		    			if(res[j-temp]!=Integer.MAX_VALUE && res[j-temp]+1<min) 
		    				min=res[j-temp]+1;
		    			res[j]=min;
		    		}
		    	}
		    }
		    if(res[v]==Integer.MAX_VALUE)
		        System.out.println(-1);
		    else
		        System.out.println(res[v]);
		}
	}

}
/*

1
1785 23
56 51 13 57 30 10 86 7 6 62 55 2 82 50 89 94 91 64 16 61 72 35 3
Op-20
yours-19

1
11 3
3 5 9

OP-2
Yours-3

1
7 2
2 1
OP-4

1
13 4
7 2 3 6
OP-2

1
8777 5
86 7 43 67 6
OP-103
76


*/

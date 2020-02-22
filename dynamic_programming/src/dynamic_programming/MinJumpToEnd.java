package dynamic_programming;

import java.util.Scanner;
//Minimum number of jumps
public class MinJumpToEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int count = sc.nextInt();
			int [] j_input = new int[count];
			for(int i=0; i<count; i++) {
				j_input[i]=sc.nextInt();
			}
			int [] j_count = new int[count];
			int [] j_pos = new int[count];
			boolean flag = true;
			for(int i=1; i<count; i++) {
				int min=Integer.MAX_VALUE;
				int pos=-1;
				for(int j=0; j<i; j++) {
					if(j_input[j]>=i-j) {
						int temp = j_count[j] +1;
						if(min>temp) {
							min=temp;
							pos=j;
						}
					}
				}
				j_count[i]=min;
				if(pos==-1) {
					System.out.println(-1); // this mean it can't reach to the end..
					flag=false;
					break;
				}
				j_pos[i]=pos;
			}
			if(flag) System.out.println(j_count[count-1]);
		}

	}

}
/*
Input:
2
11
1 3 5 8 9 2 6 7 6 8 9
6
1 4 3 2 6 7
Output:
3
2

Explanation:
Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. 
Now, from here we jump to 5h element with value 9. and from here we will jump to last.
*/
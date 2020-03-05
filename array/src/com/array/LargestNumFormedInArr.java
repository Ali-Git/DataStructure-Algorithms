package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LargestNumFormedInArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0) {
			int arrL = sc.nextInt();
			int arr[] = new int[arrL];
			List<String> list = new ArrayList<>();
			for(int i=0; i<arrL; i++) {
				arr[i]=sc.nextInt();
				list.add(String.valueOf(arr[i]));
			}
			// (3, 30)-> "330".compareTo("303")>0 = 1 => so that means "3" > "30" in increasing order "30" would come first and then "3" 
			// so returning -1 means bigger number "3" would come first and then "30" in decreasing order.
			// (95, 3)-> "953".compareTo("395")>0 = 1 => so that mean "95" > "3" in increasing order "3" would come first and then "95"  
			// so returning -1 means bigger number "95" would come first and then "3" in decreasing order.
			Collections.sort(list, (a, b)-> (a+b).compareTo((b+a))>0?-1:1);
			StringBuilder sb = new StringBuilder();
			for(String s: list) {
				sb.append(s);
			}
			System.out.println(sb);
			//System.out.println(list);
			
		}
	}
}

/*

Input:
2
5
3 30 34 5 9
4
54 546 548 60

Output:
9534330
6054854654
*/





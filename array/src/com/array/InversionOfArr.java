package com.array;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// https://practice.geeksforgeeks.org/problems/inversion-of-array/0
// Inversion of array
public class InversionOfArr {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int count = sc.nextInt();
		    int arr[] = new int[count];
		    int counter=0;
		    Map<Integer, Integer> treeMap = new TreeMap<>((a, b)->a.compare(b, a));
		    for(int i=0; i<count; i++){
		        arr[i]=sc.nextInt();
		        for(Map.Entry<Integer, Integer> m: treeMap.entrySet()){
		            if(arr[i]>=m.getKey()) 
		                break;
		            counter += treeMap.get(m.getKey());
		        }
		        if(treeMap.containsKey(arr[i])) {
		        	treeMap.put(arr[i], treeMap.get(arr[i])+1);
		        }else {
		        	treeMap.put(arr[i], 1);
		        }
		    }
		    System.out.println(counter);
		}
	}
}
/*

Input:
1
42
468 335 1 170 225 479 359 463 465 206 146 282 328 462 492 496 443 328 437 392 105 403 154 293 383 422 217 219 396 448 227 272 39 370 413 168 300 36 395 204 312 323

Its Correct output is:
494

And Your Code's output is:
481
*/









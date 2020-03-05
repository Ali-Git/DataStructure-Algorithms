package com.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Max absolute difference
// https://practice.geeksforgeeks.org/problems/max-absolute-difference/0
public class MaxAbsoluteDifference {
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int arrL = sc.nextInt();
		    int arr[] = new int[arrL];
		    for(int i=0; i<arrL; i++){
		        arr[i]=sc.nextInt();
		    }
		    int max[] = new int[arrL];
		    int min[] = new int[arrL];
		    int leftMax[] = new int[arrL];
		    int leftMin[] = new int[arrL];
		    max[0]=arr[0];
		    min[0]=arr[0];
		    leftMax[0]=arr[0];
		    leftMin[0]=arr[0];
		    for(int i=1; i<arrL; i++){
		        max[i] = max(arr[i], max[i-1]+arr[i]);
		        min[i] = min(arr[i], min[i-1]+arr[i]);
		        leftMax[i] = max(max[i], leftMax[i-1]);
		        leftMin[i] = min(min[i], leftMin[i-1]);
		    }
		    int rightMax[] = new int[arrL];
		    int rightMin[] = new int[arrL];
		    max[arrL-1]=arr[arrL-1];
		    min[arrL-1]=arr[arrL-1];
		    rightMax[arrL-1]=arr[arrL-1];
		    rightMin[arrL-1]=arr[arrL-1];
		    for(int i=arrL-2; i>=0; i--){
		        max[i] = max(arr[i], max[i+1]+arr[i]);
		        min[i] = min(arr[i], min[i+1]+arr[i]);
		        rightMax[i] = max(max[i], rightMax[i+1]);
		        rightMin[i] = min(min[i], rightMin[i+1]);
		    }
		    //System.out.println(leftMax);
		    //System.out.println(leftMin);
		    //System.out.println(rightMax);
		    //System.out.println(rightMin);
		    int maxDiff=Integer.MIN_VALUE;
		    for(int i=0; i<arrL; i++) {
		    	if(i+1<arrL && maxDiff<leftMax[i]-rightMin[i+1])
		    		maxDiff = leftMax[i]-rightMin[i+1];
		    	if(i+1<arrL && maxDiff<rightMax[i+1]-leftMin[i])
		    		maxDiff = rightMax[i+1]-leftMin[i];
		    }
		    System.out.println(maxDiff);
		}
	
	}
	
	private static int min(int a, int b){
	    return a<b?a:b;
	}
	private static int max(int a, int b){
	    return a>b?a:b;
	}
	public static void RND (String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- >0){
		    int arrL = sc.nextInt();
		    int arr[] = new int[arrL];
		    for(int i=0; i<arrL; i++){
		        arr[i]=sc.nextInt();
		    }
		    Queue<Map.Entry<Integer, Index>> maxHeap = new PriorityQueue<>((a, b)-> Integer.compare(b.getKey(), a.getKey()));
		    Map<Integer, Index> maxMap = new HashMap<>();
		    int maxOrMin[] = new int[arrL];
		    maxOrMin[0]=arr[0];
		    int startIndex=0;
		    maxMap.put(arr[0], new Index(startIndex, 0));
		    for(int i=1; i<arrL; i++){
		        maxOrMin[i] = max(arr[i], maxOrMin[i-1]+arr[i]);
		        if(maxOrMin[i]==arr[i]) {
		        	maxMap.put(maxOrMin[i], new Index(i, i));
		        	startIndex=i+1;
		        }else {
		        	maxMap.put(maxOrMin[i], new Index(startIndex, i));
		        }
		            
		    }
		    maxHeap.addAll(maxMap.entrySet());
		    
		    Queue<Map.Entry<Integer, Index>> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a.getKey(), b.getKey()));
		    Map<Integer, Index> minMap = new HashMap<>();
		    maxOrMin[0]=arr[0];
		    startIndex=0;
		    minMap.put(arr[0], new Index(startIndex, 0));
		    for(int i=1; i<arrL; i++){
		        maxOrMin[i] = min(arr[i], maxOrMin[i-1]+arr[i]);
		        if(maxOrMin[i]==arr[i]){
		        	minMap.put(maxOrMin[i], new Index(i, i));
		        	startIndex=i+1;
		        }else {
		        	minMap.put(maxOrMin[i], new Index(startIndex, i));
		        }
		            
		    }
		    
		    minHeap.addAll(minMap.entrySet());
		    System.out.println(maxHeap);
		    System.out.println(minHeap);
		    while(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
		    	Map.Entry<Integer, Index> maxPeek = maxHeap.peek();
		    	Map.Entry<Integer, Index> minPeek = minHeap.peek();
		    }
		}
	}
	
}

class Index{
	int start;
	int end;
	public Index(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}


/*
Input: [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 12
Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]

Input: [2, -1, -2, 1, -4, 2, 8]
Output: 16
Two subarrays are [-1, -2, 1, -4] and [2, 8] 


Input:
2
7
2 -1 -2 1 -4 2 8
8
-2 -3 4 -1 -2 1 5 -3
Output:
16
12

1
84
778 -794 -387 650 -363 -691 -764 541 173 212 568 -783 863 -68 -930 23 70 -394 12 230 -422 -785 -199 316 414 92 957 -863 997 -306 -85 -337 -847 -314 -125 -583 -815 -435 44 88 277 789 404 -755 -933 677 740 227 95 -796 435 468 -98 318 653 302 287 -866 -445 -441 -32 -98 -482 -710 -568 498 -587 -307 -220 529 -733 -504 -271 709 -341 -797 -619 -847 -922 -380 765 842 194 35


Its Correct output is:
12220

And Your Code's output is:
13692

Console:
1
84
778 -794 -387 650 -363 -691 -764 541 173 212 568 -783 863 -68 -930 23 70 -394 12 230 -422 -785 -199 316 414 92 957 -863 997 -306 -85 -337 -847 -314 -125 -583 -815 -435 44 88 277 789 404 -755 -933 677 740 227 95 -796 435 468 -98 318 653 302 287 -866 -445 -441 -32 -98 -482 -710 -568 498 -587 -307 -220 529 -733 -504 -271 709 -341 -797 -619 -847 -922 -380 765 842 194 35
[3308=[46, 56], 3021=[46, 55], 2719=[46, 54], 1913=[24, 28], 1801=[81, 82], 2442=[46, 57], 1836=[81, 83], 1556=[46, 59], 1846=[46, 51], 1602=[39, 42], 711=[8, 11], 1739=[46, 48], 2066=[46, 53], 1748=[46, 52], 1574=[8, 12], 1417=[46, 46], 1506=[8, 13], 1522=[24, 30], 1779=[24, 26], 765=[80, 80], 926=[8, 9], 669=[8, 16], 709=[73, 73], 1426=[46, 61], 1607=[81, 81], 1997=[46, 58], 677=[45, 45], 650=[3, 3], 847=[39, 43], 1494=[8, 10], 730=[24, 24], 95=[8, 20], 1378=[46, 50], 916=[24, 27], 944=[46, 62], 368=[74, 74], 822=[24, 25], 1524=[46, 60], 1644=[46, 47], -380=[79, 79], 529=[69, 69], -16=[0, 1], 576=[8, 14], 517=[8, 19], -199=[22, 22], -583=[35, 35], 541=[7, 7], 132=[39, 39], 714=[8, 8], 287=[8, 18], -204=[70, 70], 778=[0, 0], 1185=[24, 31], -334=[46, 64], -847=[77, 77], -404=[4, 5], 338=[24, 32], 44=[38, 38], -86=[39, 44], -429=[74, 75], 599=[8, 15], -89=[66, 66], 275=[8, 17], -815=[36, 36], -220=[68, 68], -387=[2, 2], 1198=[39, 41], -101=[24, 34], 234=[46, 63], -619=[76, 76], 943=[46, 49], -690=[8, 21], -271=[72, 72], -435=[37, 37], 498=[65, 65], -307=[67, 67], 409=[39, 40], -504=[71, 71], 24=[24, 33], -922=[78, 78], -764=[6, 6], 316=[23, 23]]
[-10384=[2, 79], -10004=[2, 78], -8777=[2, 81], -8548=[2, 83], -9619=[2, 80], -7616=[2, 75], -6478=[2, 73], -8235=[2, 76], -6819=[2, 74], -9082=[2, 77], -8583=[2, 82], -6412=[2, 70], -6916=[2, 71], -5024=[2, 63], -5592=[2, 64], -4315=[2, 49], -5988=[2, 67], -5128=[2, 38], -5679=[2, 69], -5681=[2, 66], -5040=[2, 39], -5172=[2, 37], -7187=[2, 72], -3519=[2, 48], -6208=[2, 68], -4763=[2, 40], -2508=[2, 24], -3922=[2, 35], -3412=[2, 51], -1750=[2, 15], -4737=[2, 36], -3238=[2, 22], -2053=[2, 31], -5258=[2, 44], -4581=[2, 45], -5094=[2, 65], -2922=[2, 23], -2416=[2, 25], -3702=[2, 59], -3832=[2, 61], -3841=[2, 46], -2816=[2, 57], -1459=[2, 26], -1716=[2, 30], -3339=[2, 34], -3510=[2, 52], -2237=[2, 55], -775=[2, 12], -3261=[2, 58], -794=[1, 1], -3734=[2, 60], -2062=[2, 18], -843=[2, 13], -2074=[2, 17], -2254=[2, 20], -1181=[2, 2], -3614=[2, 47], -2900=[2, 32], -3214=[2, 33], -1423=[2, 9], -855=[2, 10], -1950=[2, 56], -4314=[2, 62], -1808=[2, 7], -3039=[2, 21], -1631=[2, 29], -1635=[2, 8], -1680=[2, 16], -3880=[2, 50], -1832=[2, 19], -4325=[2, 43], -1638=[2, 11], -3974=[2, 41], -2349=[2, 6], -2539=[2, 54], -1325=[2, 28], -1773=[2, 14], -2322=[2, 27], -3570=[2, 42], 778=[0, 0], -3192=[2, 53], -1585=[2, 5], -894=[2, 4], -531=[2, 3]]


*/




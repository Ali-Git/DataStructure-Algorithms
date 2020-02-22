package com.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxOfSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int count = sc.nextInt();
			int arr[] = new int[count];
			int k = sc.nextInt();
			Deque<Integer> deque = new LinkedList<>();
			for (int i = 0; i < count; i++) {
				arr[i] = sc.nextInt();
				if(!deque.isEmpty() && deque.peekFirst()<=(i-k)) deque.pollFirst();
				while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i]) {
					deque.pollLast();
				}
				deque.add(i);
				if(i+1>=k) System.out.print(arr[deque.peek()]+" ");
			}
			System.out.println();
		}
	}

}

/*
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.

Input:
1
84 47
765 992 1 521 220 380 729 969 184 887 104 641 909 378 724 582 387 583 241 294 159 198 653 369 418 692 36 901 516 623 703 971 304 394 491 525 464 219 183 648 796 287 979 395 356 702 667 743 976 908 728 134 106 380 193 214 71 920 114 587 543 817 248 537 901 739 752 364 649 626 702 444 913 681 529 959 72 196 392 738 103 119 872 900

Its Correct output is:
992 992 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979 979

 */

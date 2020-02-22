package com.mcafee;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class McAfee {
	public static int nthMostRare(int[] elements, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new PriorityQueue<>((a, b)-> Integer.compare(map.get(a), map.get(b)));
		for (int i = 0; i < elements.length; i++) {
			if (map.containsKey(elements[i])) {
				map.put(elements[i], map.get(elements[i]) + 1);
			} else {
				map.put(elements[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			queue.add(entry.getKey());
		}
		while(n-- >1) {
			queue.poll();
		}
		System.out.println(queue);
		return queue.peek();
	}

	private static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int m = (r + l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int arr[], int l, int m, int r) {
		int arrL[] = new int[m - l + 1 + 1];
		int arrR[] = new int[r - m + 1];
		int arrL_i = 0;
		int arrR_i = 0;
		for (int i = l; i <= r; i++) {
			if (i <= m) {
				arrL[arrL_i++] = arr[i];
			} else {
				arrR[arrR_i++] = arr[i];
			}
		}
		arrL_i = 0;
		arrR_i = 0;
		arrL[arrL.length - 1] = Integer.MAX_VALUE;
		arrR[arrR.length - 1] = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) {
			if (arrL[arrL_i] < arrR[arrR_i]) {
				arr[i] = arrL[arrL_i];
				arrL_i++;
			} else {
				arr[i] = arrR[arrR_i];
				arrR_i++;
			}

		}

	}

	public static void main(String[] args) {
		int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
		System.out.println(x);
	}
}
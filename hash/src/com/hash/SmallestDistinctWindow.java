package com.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/smallest-distant-window/0
class SmallestDistinctWindow {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			Map<Character, Integer> input = new HashMap<>();
			for (Character c : ch) {
				input.put(c, 1);
			}
			int arr[] = new int[128];
			int size = input.size();
			int result = Integer.MAX_VALUE;
			int i=0, j=0, sizeCounter=0, l=ch.length;
			while(i<l && j<l) {
				arr[ch[j]]= arr[ch[j]]+1;
				if(input.containsKey(ch[j]) && arr[ch[j]] <= input.get(ch[j])) 
					sizeCounter++;
				while(sizeCounter==size && i<=j) {
					if(result>j-i+1) result=j-i+1;
					arr[ch[i]] = arr[ch[i]] -1;
					if(arr[ch[i]] < input.get(ch[i])) 
						sizeCounter--;
					i++;
				}
				j++;
			}
			System.out.println(result);
		}
	}
	
	
/*
 *Accepted and optimized solution but used map- O(n) 
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			Map<Character, Integer> input = new HashMap<>();
			for (Character c : ch) {
				input.put(c, 1);
			}
			Map<Character, Integer> map = new HashMap<>();
			int size = input.size();
			int l = ch.length;
			int result = Integer.MAX_VALUE;
			int i=0;
			int j=0;
			int sizeCounter=0;
			while(i<l && j<l) {
				if(map.containsKey(ch[j])) {
					map.put(ch[j], map.get(ch[j])+1);
				}else {
					map.put(ch[j], 1);
				}
				if(input.containsKey(ch[j]) && map.get(ch[j]) <= input.get(ch[j])) 
					sizeCounter++;
				while(sizeCounter==size && i<=j) {
					if(result>j-i+1) result=j-i+1;
					map.put(ch[i], map.get(ch[i])-1);
					if(map.get(ch[i]) < input.get(ch[i])) 
						sizeCounter--;
					i++;
				}
				j++;
			}
			System.out.println(result);
		}
	}
 */
	
/*
 Brute Force, though it is optimized a bit starting from smaller window to larger
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			Set<Character> set = new HashSet<>();
			for (Character c : ch) {
				set.add(c);
			}
			int result = ch.length;
			int length = ch.length;
			int size = set.size();
			boolean flag = false;
			for (int s = size; s <= ch.length; s++) {
				for (int i = 0; i <= ch.length - s; i++) {
					Set<Character> tempSet = new HashSet<>();
					int counter = 0;
					for (int j = i; j < i+s && j < ch.length; j++) {
						counter++;
						tempSet.add(ch[j]);
						if (tempSet.size() == size)
							break;
					}
					if (counter < result && tempSet.size() == size) {
						result = counter;
						flag = true;
						break;
					}

				}
				if (flag)
					break;
			}
			System.out.println(result);
		}
	}
 */
}

/*
Input:
2
aabcbcdbca
aaab

Output:
4
2
*/
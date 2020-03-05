package dynamic_programming;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

// Tushar - O(2^n)
// https://www.youtube.com/watch?v=xTNFs5KRV_g&t=514s
public class StringCombination {

	public static void main(String[] args) {
		// 2 AABC ABCDE
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		while(test_case-- >0) {
			String str = sc.nextLine();
			Map<Character, Integer> map = new TreeMap<>();
			for(int i=0; i<str.length(); i++) {
				if(map.containsKey(str.charAt(i))) {
					map.put(str.charAt(i), map.get(str.charAt(i))+1);
				}else {
					map.put(str.charAt(i), 1);
				}
			}
			Set<Character> set = map.keySet();
			char[] targetStr = new char[map.size()];
			int[] targetCount = new int[map.size()];
			char[] res = new char[str.length()];
			int i=0;
			for(Character ch:set) {
				targetStr[i] = ch;
				targetCount[i] = map.get(ch);
				i++;
			}
			printStringCombination(targetStr, targetCount, res, 0, 0);
			System.out.println();
		}


	}

	private static void printStringCombination(char[] str, int[] count, char[] res, int index, int k) {
		if (res.length == index) {
			return;
		}
		for (int i = 0+k; i < str.length; i++) {
			if (count[i] == 0)
				continue;
			res[index] = str[i];
			print(res, index);
			count[i] = --count[i];
			printStringCombination(str, count, res, index + 1, i);
			count[i] = ++count[i];
		}
	}

	private static void print(char[] res, int m) {
		for (int i = 0; i <=m; i++) {
			System.out.print(res[i]);
		}
		System.out.print(" ");
	}

}
/*
1
AABC
A AA AAB AABC AAC AB ABC AC B BC C 
*/


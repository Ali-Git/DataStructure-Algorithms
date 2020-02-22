package dynamic_programming;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StringPermutation {

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
			printStringPermutation(targetStr, targetCount, res, 0);
			System.out.println();
		}


	}

	private static void printStringPermutation(char[] str, int[] count, char[] res, int level) {
		if (res.length == level) {
			print(res);
			return;
		}
		for (int i = 0; i < str.length; i++) {
			if (count[i] == 0)
				continue;
			res[level] = str[i];
			count[i] = --count[i];
			printStringPermutation(str, count, res, level + 1);
			count[i] = ++count[i];
		}
	}

	private static void print(char[] res) {
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
		System.out.print(" ");
	}

}

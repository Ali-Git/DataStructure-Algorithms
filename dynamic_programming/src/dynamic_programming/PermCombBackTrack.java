package dynamic_programming;

//Count of strings that can be formed using a, b and c under given constraints

import java.util.Scanner;

public class PermCombBackTrack {
	
	private static int counter=0;
	public static void main(String[] args) {
		// 2 AABC ABCDE
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		while (test_case-- > 0) {
			int num = Integer.parseInt(sc.nextLine());
			char[] targetStr = { 'a', 'b', 'c' };
			int[] targetCount = { 300, 1, 2 };
			char[] res = new char[num];
			counter = 0;
			printStringPermutation(targetStr, targetCount, res, 0);
			System.out.println();
			System.out.println(counter);
		}
	}

	private static void printStringPermutation(char[] str, int[] count, char[] res, int level) {
		if (res.length == level) {
			print(res);
			counter++;
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
